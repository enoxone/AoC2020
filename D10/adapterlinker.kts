import java.io.File
main()
fun main() {
    val lineList = File("input10.txt").readLines()
    var numList = lineList.map({ it.toInt() })
    var sortedList = numList.sortedBy({ it })
    println(sortedList)
    var joltDiffs = mutableListOf<Int>()
    joltDiffs.add(1)
    for (x in 1..(sortedList.size - 1)) {
        joltDiffs.add(sortedList[x] - sortedList[x - 1])
    }
    joltDiffs.add(3)
    println(joltDiffs)
    var pathways = MutableList<Long>(size = sortedList.size, {0})
    var oneJolt = joltDiffs.count({ it == 1 })
    var triJolt = joltDiffs.count({ it == 3 })
    println("${oneJolt} * $triJolt = ${triJolt * oneJolt}")
    pathways[0] = 1
    for (current in pathways.indices) {
        if ((pathways.size - current) > 1 && (sortedList[current + 1]-sortedList[current]<4)) {
            pathways[current + 1] += pathways[current].toLong()
        }
        if ((pathways.size - current > 2) && (sortedList[current + 2]-sortedList[current]<4)) {
            pathways[current + 2] += pathways[current].toLong()
        }
        if ((pathways.size - current > 3) && (sortedList[current + 3]-sortedList[current]<4)) {
            pathways[current + 3] += pathways[current].toLong()
        }
        println(pathways[current])
    }
}