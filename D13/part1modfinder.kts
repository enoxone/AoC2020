import java.io.File
main()
fun main() {
    var line = File("input.txt").readLines()[1]
    println(line.split(',').size)
    val busLoc:Array<Long> = arrayOf(0,7,11,17,36,40,46,48,61)
    val busIDs:Array<Long> = arrayOf(17,41,37,367,19,23,29,613,13)
    var timeCheck : Long = 1
    var step : Long = 1

    for (index in 0..(busIDs.size-1)) {
        var done = false
        while(!done) {
            if((timeCheck+busLoc[index])%busIDs[index]!=0.toLong()) {
                timeCheck += step
            } else {
                done = true
                step *= busIDs[index]
            }
        }
        println(timeCheck)
    }
}
