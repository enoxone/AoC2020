import java.io.File
main()
fun main() {
    var goodPass = 0
    //val path = System.getProperty("user.dir")
    //println("Working Directory = $path")
    var fieldsFilled =BooleanArray(7,)
    //order goes birth year, issue year, expire year, geight, hair, eye, passID
    val lineList = File("input4.txt").readLines()
    for (passInfo in lineList) {
        if(passInfo=="") {
            if(!fieldsFilled.contains(false)) goodPass++
            fieldsFilled = BooleanArray(7)
            println(goodPass)
        } else {
            val passPieces = passInfo.split(' ')
            for(passPiece in passPieces){
                when(passPiece.substring(startIndex = 0, endIndex = 3)) {
                    "byr" -> if(passPiece.substring(startIndex = 4, endIndex = passPiece.lastIndex+1).toInt() in 1920..2020)
                        fieldsFilled[0] = true
                    "iyr" -> if(passPiece.substring(startIndex = 4, endIndex = passPiece.lastIndex+1).toInt() in 2010..2020)
                        fieldsFilled[1] = true
                    "eyr" -> if(passPiece.substring(startIndex = 4, endIndex = passPiece.lastIndex+1).toInt() in 2020..2030)
                        fieldsFilled[2] = true
                    "hgt" -> {
                        if (passPiece.substring(passPiece.lastIndex - 1, passPiece.lastIndex+1) == "in") {
                            if (passPiece.substring(4, passPiece.lastIndex - 1).toInt() in 59..76) fieldsFilled[3] = true
                        }
                        else if (passPiece.substring(passPiece.lastIndex - 1, passPiece.lastIndex+1) == "cm") {
                            if (passPiece.substring(4, passPiece.lastIndex - 1).toInt() in 150..193) fieldsFilled[3] = true
                        }
                    }
                    "hcl" -> if (passPiece.indexOf('#') == 4 && passPiece.length == 11)
                                 if(passPiece.substring(6..10).matches("-?[0-9a-f]+".toRegex()))
                                     fieldsFilled[4] = true
                    "ecl" -> if(passPiece.length == 7)
                                when (passPiece.substring(4..6)) {
                                    "amb", "blu", "brn", "gry", "grn", "hzl", "oth" -> fieldsFilled[5] = true
                                }
                    "pid" -> if(passPiece.length == 13)
                        fieldsFilled[6] = true

                }
            }
        }
    }
}