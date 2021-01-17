import java.io.File
main()

fun main() {
    var lineList = File("D8-2.txt").readLines()
    var repeatCheck = BooleanArray(618)
    repeatCheck[617]=true
    var accounter = 0
    var currentLine = 0
    var repeated = false
    while(!repeated) {
        if(repeatCheck[currentLine]==true) {
            repeated = true
        }
        else {
            repeatCheck[currentLine] = true
        }
        var lineCode = lineList[currentLine].split(' ')
        var numberPart = lineCode[1].toInt()
        when (lineCode[0]) {
            "acc" -> accounter += numberPart
            "jmp" -> currentLine += (numberPart - 1)
        }
        println(currentLine)
        currentLine++
        if(currentLine==617)
            println("hit the end")
    }
    println(accounter)
    for (index in 0..616) {
        if (lineList[index].contains("nop")&&(index + lineList[index].split(' ')[1].toInt()) in 328..333)
            println("look at nop index $index leading to ${(index+lineList[index].split(' ')[1].toInt())}")
    }
    for (index in 0..616) {
        if (lineList[index].contains("jmp") && (index + lineList[index].split(' ')[1].toInt()) in 327..333)
        println("look at jump index $index leading to ${(index + lineList[index].split(' ')[1].toInt())}")
    }
}