import java.io.File
main()
fun main() {
    var lineList = File("input11.txt").readLines().toMutableList()
    var stagnated = false
    while (!stagnated) {
        stagnated=true
        var singlestep = arrayListOf<ArrayList<Char>>()
        for(fcord in 0..(lineList.size-1) {
            for(scord in 0..(lineList[fcord].length-1)) {
                var occSeats = 0
                if(lineList[fcord][scord]=='.') {
                    singlestep.add
                }
            }
        }
    }
}