import java.io.File
main()
fun main() {
    var goodPass = 0
    //val path = System.getProperty("user.dir")
    //println("Working Directory = $path")
    var fieldsFilled = BooleanArray(7)
    val lineList = File("input4.txt").readLines()
    for (passInfo in lineList) {
        if(passInfo=="") {
            if(!fieldsFilled.contains(false)) goodPass++
            fieldsFilled = BooleanArray(7)
            println(goodPass)
        } else {
                fieldsFilled =parseliner(passInfo,fieldsFilled)
        }
    }
}
fun parseliner(passIn: String,fieldCheck: BooleanArray): BooleanArray{
    when(passIn.substring(startIndex = 0, endIndex = 4)) {
        "byr" -> fieldCheck[0] = true
        "iyr" -> fieldCheck[1] = true
        "eyr" -> fieldCheck[2] = true
        "hgt" -> fieldCheck[3] = true
        "hcl" -> fieldCheck[4] = true
        "ecl" -> fieldCheck[5] = true
        "pid" -> fieldCheck[6] = true
    }
    if(passIn.contains(' '))
        return parseliner(passIn.drop(passIn.indexOf(' ')+1),fieldCheck)
    return fieldCheck
}