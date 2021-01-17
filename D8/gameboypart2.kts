import java.io.File
main()
fun doesItWork(assemCode:MutableList<String>) : Boolean {
    var repeatCheck = BooleanArray(618)
    var accounter = 0
    var currentLine = 0
    var repeated = false
    while(!repeated) {
        if(repeatCheck[currentLine]==true) {
            return false
        }
        else {
            repeatCheck[currentLine] = true
        }
        var lineCode = assemCode[currentLine].split(' ')
        var numberPart = lineCode[1].toInt()
        when (lineCode[0]) {
            "acc" -> accounter += numberPart
            "jmp" -> currentLine += (numberPart - 1)
        }
        currentLine++
        if(currentLine==617) {
            println(accounter)
            return true
        }
    }
    return false
}
fun main() {
    var lineList = File("D8.txt").readLines().toMutableList()
    for (index in 0..(lineList.size-1)) {
        if(lineList[index].split(' ')[0]=="jmp") {
            lineList[index] = "nop " +  lineList[index].split(' ')[1]
        }
        else if (lineList[index].split(' ')[0]=="nop") {
            lineList[index] = "jmp " + lineList[index].split(' ')[1]
        }
        if(doesItWork(lineList)) println("index $index became ${lineList[index]} and it worked")
        lineList = File("D8.txt").readLines().toMutableList()
    }
}