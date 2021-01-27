import java.io.File
main()
fun main() {
    var yesTotal = 0
    val lineList = File("input6.txt").readLines()
    var groupyes = ""
    for (line in lineList) {
        if (line == "") {
            yesTotal += groupyes.toSet().size
            println("group has ${groupyes.toSet().size} yeses")
            groupyes=""
            println(yesTotal)
        } else groupyes += line
    }
}