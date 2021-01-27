import java.io.File
main()
fun main() {
    var filledSeats:BooleanArray = BooleanArray(1024)
    //val path = System.getProperty("user.dir")
    //println("Working Directory = $path")
    val lineList = File("input5.txt").readLines()
    for (passInfo in lineList) {
        var rowString = passInfo.substring(0..6)
        var aisleString = passInfo.substring(7..9)
        rowString=rowString.replace('F', '0')
        rowString=rowString.replace('B', '1')
        val rowValue = rowString.toInt(2)
        println(rowValue)
        aisleString=aisleString.replace('L', '0')
        aisleString=aisleString.replace('R', '1')
        val aisleValue = aisleString.toInt(2)
        println(aisleValue)
        filledSeats[(rowValue*8)+aisleValue] = true
    }
    for (seatID in 1..(filledSeats.size-1)) {
        if(filledSeats[seatID] == false && filledSeats[seatID-1]==true && filledSeats[seatID+1] == true) println("ID equals $seatID")
    }
}