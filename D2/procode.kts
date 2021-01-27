import java.io.File
main()
fun main() {
    var goodPass: Int =0
    //val path = System.getProperty("user.dir")
    //println("Working Directory = $path")
    val lineList = File("p1input.txt").readLines()
    var lowCount :Int
    var highCount :Int
    var keyChar :Char
    var password :String
    for (passString in lineList) {
        lowCount = passString.substring(startIndex = 0,endIndex = (passString.indexOf('-'))).toInt()
        highCount = passString.substring((passString.indexOf('-')+1),(passString.indexOf(' '))).toInt()
        keyChar = passString[passString.indexOf(':')-1]
        password = passString.drop(passString.indexOf(':')+2)
        if((password[lowCount-1] == keyChar)!=(password[highCount-1] != keyChar)) goodPass++
        println(goodPass)
    }
}