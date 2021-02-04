import java.io.File
main()
fun main() {
    //var errorRate = 0
    val ruleList = File("input16rules.txt").readLines()
    var allRuleValues = mutableListOf<IntRange>()
    for (rule in ruleList) {
        val ruleNumbers1 = rule.split(": ", " or ")[1]
        allRuleValues.add(ruleNumbers1.split('-')[0].toInt()..ruleNumbers1.split('-')[1].toInt())
        println(allRuleValues.last())
        val ruleNumbers2 = rule.split(": ", " or ")[2]
        allRuleValues.add(ruleNumbers2.split('-')[0].toInt()..ruleNumbers2.split('-')[1].toInt())
        println(allRuleValues.last())
    }
    var validCount = Array<Array<Boolean>>(size=((allRuleValues.size/2).toInt()),init={Array((allRuleValues.size/2).toInt(),{true})})//first index is rule 2nd is column number is coming from
    val lineList = File("input16.txt").readLines()
    for (ticket in lineList) {
        val values = ticket.split(',')
        var numsInTicket = values.map { it.toInt() }
        for (columnInTicket in numsInTicket.indices) {
            //var accepted = false
            for(acceptindex in allRuleValues.indices step 2) {
                if (!(numsInTicket[columnInTicket] in allRuleValues[acceptindex])&&!(numsInTicket[columnInTicket] in allRuleValues[acceptindex+1])) {
                    validCount[(acceptindex/2).toInt()][columnInTicket]=false
                }
            }
            /*if(!accepted) {
                println("${numsInTicket[index]} is wrong in ticket ${lineList.indexOf(ticket)}")
                errorRate += numsInTicket[index]*/
        }
    }
    for(passes in validCount.indices) {
        for (check in validCount.indices) {
            if(validCount[check].count({it})==1){
                val clearcol = validCount[check].indexOf(true)
                for (clear in validCount.indices) {
                    if(clear!=check) {
                        validCount[clear][clearcol] = false
                    }
                }
            }
        }
    }
    for(x in validCount.indices) {
        for (y in validCount[x].indices) {
            print("${if(validCount[x][y]){"1"}else{"0"}} ")
        }
        println("rule ${x+1} had this array")
    }
    var total : Long = 1
    var myTicket = arrayOf(61,151,59,101,173,71,103,167,127,157,137,73,181,97,179,149,131,139,67,53)
    for (dep in 0..5 {
        total *= myTicket[validCount[dep].indexOf(true)].toLong()
        println(myTicket[validCount[dep].indexOf(true)])
    }
    println(total)
}