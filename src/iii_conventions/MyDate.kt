package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
	override fun compareTo(other: MyDate): Int {
		return when {
			other.year != year -> year - other.year
			other.month != month -> month - other.month
			else -> dayOfMonth - other.dayOfMonth
		}
	}

	operator fun plus(year: TimeInterval): MyDate {
		return addTimeIntervals(year,1)
	}

	operator fun plus(interval : RepeatedTimeInterval) : MyDate {
		return addTimeIntervals(interval.interval, interval.count)
	}

}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

class RepeatedTimeInterval(val interval: TimeInterval, val count:Int)

enum class TimeInterval {
	DAY,
	WEEK,
	YEAR;

	operator fun times(i: Int): RepeatedTimeInterval {
		return RepeatedTimeInterval(this, i)
	}
}

class DateRange(val start: MyDate, val endInclusive: MyDate) {
	operator fun contains(date: MyDate): Boolean {
		return date >= start && date <= endInclusive
	}

	operator fun iterator() = DateRangeIterator(this)
}

class DateRangeIterator(private val range: DateRange) : Iterator<MyDate> {
	//需要用一个current对象保存range中的起始日期，然后每次调用next的时候使用nextDay方法修改current的值，
	//这样来判断是否hasNext
	var current: MyDate
	init {
		current = range.start
	}

	override fun next(): MyDate {
		val result = current
		current = current.nextDay()
		return result
	}

	override fun hasNext(): Boolean {
		return current <= range.endInclusive
	}

}
