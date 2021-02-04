import java.io.File
main()
fun main() {
    val inputListRules = File("testinput19rules.txt").readLines()
    var rulesList = MutableList<String>(size=inputListRules.size,init={""})
    for (line in inputListRules){
        rulesList[line.split(": ")[0].toInt()] = line.split(": ")[1]
    }
    fun lamdatest(input:String) : String {
        val inputSplit = input.split(' ')
        var Regexaddition: String = "("
        if(input.contains('"')) {
            return input[1].toString()
        }
        for (token in inputSplit) {
            if (token == "|") {
                Regexaddition += ")|("
            } else {
                Regexaddition += lamdatest(rulesList[token.toInt()])
            }
        }
        Regexaddition+=")"
        return Regexaddition
    }
    val myRegex = lamdatest(rulesList[0]).toRegex()
    println(myRegex)
    val inputList = File("testinput19.txt").readLines()
    var total = inputList.count{myRegex.matches(it)}
    println(total)
}