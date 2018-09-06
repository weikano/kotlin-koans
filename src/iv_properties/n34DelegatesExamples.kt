package iv_properties

import util.TODO
import util.doc34

class LazyPropertyUsingDelegates(initializer: () -> Int) {
	val lazyValue : Int by lazy(initializer)
//	val lazyValue: Int by todoTask34(initializer)
}

