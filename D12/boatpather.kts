import java.io.File
import kotlin.math.absoluteValue

main()
fun main() {
    var lineListInput = File("input12.txt").readLines().toMutableList()
    var xCord = 0
    var yCord = 0
    var wayxCord = 10
    var wayyCord = 1
    for (line in lineListInput) {
        when(line[0]) {
            'N' -> wayyCord += line.drop(1).toInt()
            'S' -> wayyCord -= line.drop(1).toInt()
            'E' -> wayxCord += line.drop(1).toInt()
            'W' -> wayxCord -= line.drop(1).toInt()
            'L' -> {
                var rots = line.drop(1).toInt()/90
                for (a in 1..rots) {
                    var hold = wayxCord
                    wayxCord = (wayyCord * -1)
                    wayyCord = hold
                }
            }
            'R' -> {
                var rots = line.drop(1).toInt()/90
                for (a in 1..rots) {
                    var hold = wayyCord
                    wayyCord = (wayxCord * -1)
                    wayxCord = hold
                }
            }
            'F' -> {
                var drives = line.drop(1).toInt()
                for (a in 1..drives) {
                    xCord += wayxCord
                    yCord += wayyCord
                }
            }
        }
    }
    println(yCord)
    println(xCord)
    println("${xCord.absoluteValue + yCord.absoluteValue}")
}