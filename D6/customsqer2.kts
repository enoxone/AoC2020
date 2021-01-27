import java.io.File
main()
fun main() {
    var yesTotal = 0
    val lineList = File("input6.txt").readLines()
    var groupyes = "first"
    for (line in lineList) {
        if (line == "") {
            yesTotal += groupyes.toSet().size
            println("group has ${groupyes.toSet().size} yeses")
            groupyes="first"
            println(yesTotal)
        } else {
            if(groupyes=="first") groupyes = line
            else {
            groupyes=line.filter{groupyes.contains(it)}
            println(groupyes)
            //for (oldq in groupyes) {
            //    if(!groupyes.contains(oldq)) groupyes.replace(oldq,'')
            }
        }
    }
}