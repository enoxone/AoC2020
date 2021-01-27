import java.io.File
main()
fun main() {
    //val path = System.getProperty("user.dir")
    //println("Working Directory = $path")
    var x = 0
    var treeCount = 0
    var linecounter = 0
    val lineList = File("3input.txt").readLines()
    for(line in lineList) {
        if(linecounter%2==0) {
            if (line[x] == '#') treeCount++
            x = x + 1
            println("line.length is ${line.length}")
            x = x % line.length
            println(treeCount)
        }
        linecounter++
    }
    println(242*82*71*67*24)
}