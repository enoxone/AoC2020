import java.io.File
main()
fun main() {
    //val path = System.getProperty("user.dir")
    //println("Working Directory = $path")
    val numList = File("p1input.txt").readLines().map{it.toInt()}
    for (num1 in numList) for (num2 in numList) for (num3 in numList) if((num1 + num2 + num3)== 2020) println("$num1 * $num2 * $num3 = ${num1*num2*num3}")
}
