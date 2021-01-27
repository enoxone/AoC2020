main()
fun main() {
    var allCalls = mutableListOf<Int>(1,17,0,10,18,11)
    var lastCall = 6
    for (next in 6.. 30000000) {
        if (allCalls.lastIndexOf(lastCall) == -1) {
            allCalls.add(lastCall)
            lastCall = 0
        } else {
            val holder = allCalls.lastIndexOf(lastCall)
            allCalls.add(lastCall)
            lastCall = (next - holder)
        }
        println(lastCall)
    }
    allCalls.add(lastCall)
    println(allCalls.size)
}