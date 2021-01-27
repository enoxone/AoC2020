import java.io.File
main()
fun main() {
    val lineList = File("input9.txt").readLines()
    var numList = lineList.map({it.toLong()})
    for (x in 25..numList.size-1) {
        var addSuccess = false
        for (a in (x-25)..(x-2)) {
          for (b in (a)..(x-1))
              if (numList[a]+numList[b]==numList[x]) addSuccess=true
        }
        if (!addSuccess) {
            println("index $x is ${numList[x]} and failed")
            break
        }
    }
    var failNum: Long = 36845998
    for (x in 0..532) {
        var runningTotal :Long = 0
        var totalNumbersadded = 0
        while (runningTotal<failNum) {
            runningTotal += numList[x+totalNumbersadded]
            totalNumbersadded++
        }
        if(runningTotal==failNum) {
            println("the range from index $x to index ${x + totalNumbersadded} worked")
            println("for clarity those are numbers ${numList[x]} and ${numList[x+totalNumbersadded]}")
            var notASet = mutableListOf<Long>()
            for (ran in x..(x+totalNumbersadded)) {
                println(ran)
                notASet.add(numList[ran.toInt()])
            }
            println("Max is ${notASet.maxOrNull()} and Min is ${notASet.minOrNull()} which add up to")
            println(notASet)
        }
    }
}
