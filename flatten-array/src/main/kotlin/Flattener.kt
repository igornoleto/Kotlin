object Flattener {

    fun flatten(nestedList: List<Any?>): List<Any> =
        nestedList.filterNotNull().flatMap {
            if (it is List<*>) flatten(it) else listOf(it)
        }
}