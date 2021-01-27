import java.io.File
main()
open class colorBag(val name:String) {
    var subbags= mutableListOf<colorBag>()
    var bagcount= mutableListOf<Int>()
}
fun main() {
    var counter = 1
    var allBags = mutableListOf<colorBag>()
    var goldenTotal = 0
    val lineList = File("input7.txt").readLines()
    for (line in lineList) {
        var containerBag = line.split(" bags contain ")[0]
        var bigBag = allBags.find({it.name==containerBag})
        if (bigBag==null) {
            bigBag = colorBag(containerBag)
            allBags.add(bigBag)
        }
        var containedList = line.split("contain ")[1].split(Regex(""" bags?,?.? ? ?[0-0]?"""))
        containedList=containedList.dropLast(1)
        //println(containedList)
        for (abag in containedList) {
            var aBag = abag.drop(2)
            //println(aBag)
            var lilBag = allBags.find({ it.name == aBag })
            if (lilBag == null) {
                lilBag = colorBag(aBag)
                allBags.add(lilBag)
            }
            bigBag.subbags.add(lilBag)
            if(aBag==" other")
                bigBag.bagcount.add(0)
            else {
                //println(abag[0].toInt())
                println(abag)
                println(abag[0])
                bigBag.bagcount.add(Character.getNumericValue(abag[0]))
            }
        }
        //println(bigBag.bagcount)
        //println("Line $counter is ${bigBag.subbags.size}")
        counter++
    }
    println(allBags.size)
    for (cBag in allBags) {
        if(bagChecker(cBag)) goldenTotal++
    }
    println(goldenTotal)
    val aShinyBag = allBags.find({it.name=="shiny gold"})
    if(aShinyBag is colorBag) println(bagCounter(aShinyBag))
}

fun bagChecker(checkBag: colorBag) : Boolean {
    for (subBag in checkBag.subbags) {
        if (subBag.name == "shiny gold") {
            return true
        }
        else {
            if(bagChecker(subBag) == true)
                return true
        }
    }
    return false
}
fun bagCounter(checkBag: colorBag) : Int {
    var counter = 1
    for (subBag in checkBag.subbags) {
        if(subBag.name == " other")
            return 1
        else {
            counter += (bagCounter(subBag) * checkBag.bagcount[checkBag.subbags.indexOf(subBag)])
        }
    }
    return counter
}