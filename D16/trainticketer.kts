import java.io.File
main()
fun main() {
    val lineList = File("input16.txt").readLines()
    for (ticket in lineList) {
        val values=ticket.split(',')
        var num = values.map{it.toInt()}

    }