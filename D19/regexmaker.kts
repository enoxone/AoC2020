import java.io.File
main()
fun main() {
    val inputListRules = File("input19rules.txt").readLines()
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
    //(a((aa)|(bb)(ab)|(ba))|((ab)|(ba)(aa)|(bb))b) for testcode
    //((((a(b(((b(ba)|(aa))|(a(ba))b)|((a(bb))|(b(aa))a)a)|(((a(aa)|(bb))|(b(bb)|(ba))b)|((b(ab))|(a(ba)|(aa))a)b))|(a((((a)|(b)(aa)|(bb))a)|((((a)|(b)b)|(aa)a)b)b)|(((a((a)|(b)b)|(aa))|(b(aa)|(ab))a)|((b((a)|(b)(a)|(b)))|(a((a)|(b)b)|(ba))b)a)))|(b(b(b((b((a)|(b)b)|(ba))|(a(ba))a)|((b(aa)|(bb))|(a(aa)|(ab))b))|(a(b(a((a)|(b)b)|(aa))|(b(aa)|(ab)))|(a(b(aa)|(ab))|(a(bb)|(ba)))))|(a((a(a(ba))|(b(ba)|(ab)))|(b(b(ab))|(a(ba)|(aa)))b)|((a(a(ba))|(b(bb)|((a)|(b)a)))|(b(a(ab))|(b(bb)))a)))b)|((((a((((a)|(b)b)|(aa)b)|((bb)|((a)|(b)a)a)a)|(((a)|(b)(aa)|(bb))b))|(b(a(b((a)|(b)b)|(ba))|(a(aa)|(bb)))|(b((aa)|(bb)b)|((ab)a)))a)|((((b(aa)|(ab))a)|((((a)|(b)b)|(ba)a)|((ba)|(ab)b)b)b)|(((b((a)|(b)(a)|(b)))|(a((a)|(b)b)|(ba))b)|((a(bb)|((a)|(b)a))|(b(aa)|(ab))a)a)b)a)|((a(a(((bb)b)|(((a)|(b)(a)|(b))a)a)|(((bb)|(ba)a)b))|(b((b((a)|(b)b)|(ba))|(a(aa)|(bb))a)|((b((a)|(b)b)|(ba))|(a(ba))b)))|(b((((bb)|(ba)b)|((bb)a)b)|((((a)|(b)b)|(ba)a)|((aa)|(ab)b)a)a)|(((a(bb)|((a)|(b)a))|(b(aa)|(ab))a)|(((aa)b)|((ab)a)b)b))b)a))(((a(b(((b(ba)|(aa))|(a(ba))b)|((a(bb))|(b(aa))a)a)|(((a(aa)|(bb))|(b(bb)|(ba))b)|((b(ab))|(a(ba)|(aa))a)b))|(a((((a)|(b)(aa)|(bb))a)|((((a)|(b)b)|(aa)a)b)b)|(((a((a)|(b)b)|(aa))|(b(aa)|(ab))a)|((b((a)|(b)(a)|(b)))|(a((a)|(b)b)|(ba))b)a)))|(b(b(b((b((a)|(b)b)|(ba))|(a(ba))a)|((b(aa)|(bb))|(a(aa)|(ab))b))|(a(b(a((a)|(b)b)|(aa))|(b(aa)|(ab)))|(a(b(aa)|(ab))|(a(bb)|(ba)))))|(a((a(a(ba))|(b(ba)|(ab)))|(b(b(ab))|(a(ba)|(aa)))b)|((a(a(ba))|(b(bb)|((a)|(b)a)))|(b(a(ab))|(b(bb)))a)))b)|((((a((((a)|(b)b)|(aa)b)|((bb)|((a)|(b)a)a)a)|(((a)|(b)(aa)|(bb))b))|(b(a(b((a)|(b)b)|(ba))|(a(aa)|(bb)))|(b((aa)|(bb)b)|((ab)a)))a)|((((b(aa)|(ab))a)|((((a)|(b)b)|(ba)a)|((ba)|(ab)b)b)b)|(((b((a)|(b)(a)|(b)))|(a((a)|(b)b)|(ba))b)|((a(bb)|((a)|(b)a))|(b(aa)|(ab))a)a)b)a)|((a(a(((bb)b)|(((a)|(b)(a)|(b))a)a)|(((bb)|(ba)a)b))|(b((b((a)|(b)b)|(ba))|(a(aa)|(bb))a)|((b((a)|(b)b)|(ba))|(a(ba))b)))|(b((((bb)|(ba)b)|((bb)a)b)|((((a)|(b)b)|(ba)a)|((aa)|(ab)b)a)a)|(((a(bb)|((a)|(b)a))|(b(aa)|(ab))a)|(((aa)b)|((ab)a)b)b))b)a)(((a(((a((a)|(b)(a)|(b)))|(b(ba)|(aa))b)|(((aa)b)|((ab)a)a)b)|(((b(ab))|(a(ba))a)|(((a)|(b)(ba)|(ab))b)a))|(b(b((b((a)|(b)b)|(aa))|(a(aa)|(ab))b)|(((bb)|((a)|(b)a)a)|((ba)|(ab)b)a))|(a(b((aa)a))|(a(a(ba))|(b(aa)))))a)|(((b((b(aa))|(a((a)|(b)(a)|(b)))b)|(((aa)a)|((bb)|(ba)b)a))|(a(b((aa)b)|((ba)|(ab)a))|(a(a(bb)|(ab))|(b(ab))))a)|(((b(b((a)|(b)(a)|(b)))|(a(aa)|(bb)))|(a(a((a)|(b)(a)|(b)))|(b(aa)|(ab)))b)|((b(b(bb)|(ba))|(a(ab)))|(a((aa)b)|((bb)|((a)|(b)a)a))a)b)b)a)|((((((a(ba))|(b((a)|(b)(a)|(b)))a)|((a((a)|(b)(a)|(b)))|(b(bb)|(ab))b)a)|(((a(bb)|(ab))|(b(ab))b)|(((ba)|(ab)b)|((ab)a)a)b)a)|((((b(aa)|(bb))|(a(ba)|(aa))a)|(((ba)b)|((bb)|(ba)a)b)a)|(((a(bb)|(ba))|(b((a)|(b)(a)|(b)))a)|((b(ba))|(a(bb)|(ba))b)b)b)a)|(((a(b(a(bb)|(ab))|(b(bb)|((a)|(b)a)))|(a((a)|(b)(ba)|(ab))))|(b(a(((a)|(b)b)|(aa)a)|((bb)b))|(b((aa)a)|((bb)|(ba)b)))a)|((b(b(a(bb)|(ab))|(b(ba)|(ab)))|(a((ba)|(aa)a)|(((a)|(b)(a)|(b))b)))|(a((a((a)|(b)(a)|(b)))|(b(ba)|(aa))b)|((a(ba))|(b(ba)|(ab))a))b)b)b)))
    val inputList = File("testinput19.txt").readLines()
    var total = inputList.count{myRegex.matches(it)}
    println(total)
}