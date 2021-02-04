import java.io.File
main()
fun main() {
    val inputList = File("input18.txt").readLines()
    var runningTotal: Long =0
    for (line in inputList){

        runningTotal+= mathsolver(line).toLong()

        println(runningTotal)
    }
    println(runningTotal)
}
fun mathsolver(input:String): String {
    var equationString =input
    var noParens = true
    var outerParens = 0
    var index = 0
    var openIndex = 0
    //println("input string is $equationString")
    while(index<(equationString.length)) {
        if(equationString[index]=='(') {
            if(noParens) {
                openIndex = index
                noParens = false
            }
            outerParens++
        }
        else if (equationString[index]==')') {
            outerParens--
            if (outerParens==0) {
                var minisolver = mathsolver(equationString.substring((openIndex+1),index))
                equationString = equationString.substringBefore('(') + minisolver + equationString.substring(index+1)
                noParens=true
                index = 0
            }
        }
        index++
    }
    //println("output string is $equationString")
    var equationArray = equationString.split(' ').toMutableList()
    var total : Long = 1
    var tempPlusHolder:Long = equationArray[0].toLong()
    for (mathindex in 1..(equationArray.size-1) step 2) {
        if (equationArray[mathindex]=="*") {
            total *= tempPlusHolder
            tempPlusHolder = equationArray[mathindex+1].toLong()
        }
        else if (equationArray[mathindex]=="+") {
            tempPlusHolder += equationArray[mathindex+1].toLong()
        }
        else {
            println("something with wrong when you gave me a ${equationArray[mathindex]}")
        }
    }
    total *= tempPlusHolder
    //println(total)
    return total.toString()
}