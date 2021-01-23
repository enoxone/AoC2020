import java.io.File
main()
fun main() {
    var lineListInput = File("input11.txt").readLines().toMutableList()
    var lineList = arrayListOf<ArrayList<Char>>()
    for(fc in 0..(lineListInput.size-1)) {
        lineList.add(arrayListOf<Char>())
        for (sc in 0..(lineListInput[fc].length - 1)) {
            lineList[fc].add(lineListInput[fc][sc])
        }
    }
    var counter = 0
    var stagnated = false
    while (!stagnated) {
        stagnated=true
        println(counter)
        counter++
        var singlestep = arrayListOf<ArrayList<Char>>()
        for(fcord in 0..(lineList.size-1)) {
            singlestep.add(arrayListOf<Char>())
            for(scord in 0..(lineList[fcord].size-1)) {
                var occSeats = 0
                if(fcord>0) {//skipped if this is top row
                    if(scord>0) {//skipped if this is left column
                        var step1 = 1
                        var hitEdge1 = false //this is diagnal top left
                        while(!hitEdge1) {
                            if (lineList[fcord - step1][scord - step1] != '.' || (fcord - step1) == 0 || (scord - step1) == 0) {
                                hitEdge1 = true
                                if (lineList[fcord - step1][scord - step1] == '#') {
                                    occSeats++
                                }
                            }
                            else step1++
                        }
                    }
                    var step2 = 1
                    var hitEdge2 = false //this is up
                    while(!hitEdge2) {
                        if (lineList[fcord - step2][scord] != '.' || (fcord - step2) == 0) {
                            hitEdge2 = true
                            if (lineList[fcord - step2][scord] == '#') {
                                occSeats++
                            }
                        }
                        else step2++
                    }
                    if(scord<(lineList[fcord].size-1)) {//skipped if this is right column
                        var step3 = 1
                        var hitEdge3 = false //this is diagnal top right
                        while(!hitEdge3) {
                            if (lineList[fcord - step3][scord + step3] != '.' || (fcord - step3) == 0 || (scord + step3) == (lineList[fcord].size-1)) {
                                hitEdge3 = true
                                if (lineList[fcord - step3][scord + step3] == '#') {
                                    occSeats++
                                }
                            }
                            else step3++
                        }
                    }
                }
                if(scord>0) {//skipped if this is left column
                    var step4 = 1
                    var hitEdge4 = false //this is left
                    while(!hitEdge4) {
                        if (lineList[fcord][scord - step4] != '.' || (scord - step4) == 0) {
                            hitEdge4 = true
                            if (lineList[fcord][scord - step4] == '#') {
                                occSeats++
                            }
                        }
                        else step4++
                    }
                }
                if(scord<(lineList[fcord].size-1)) {//skipped if this is right column
                    var step5 = 1
                    var hitEdge5 = false //this is right
                    while(!hitEdge5) {
                        if (lineList[fcord][scord + step5] != '.' || (scord + step5) == (lineList[fcord].size-1)) {
                            hitEdge5 = true
                            if (lineList[fcord][scord + step5] == '#') {
                                occSeats++
                            }
                        }
                        else step5++
                    }
                }
                if(fcord<(lineList.size-1)) {//skipped if this is bottom row
                    if(scord>0) {//skipped if this is left column
                        var step6 = 1
                        var hitEdge6 = false //this is diagnal down left
                        while(!hitEdge6) {
                            if (lineList[fcord + step6][scord - step6] != '.' || (fcord + step6) == (lineList.size-1) || (scord - step6) == 0) {
                                hitEdge6 = true
                                if (lineList[fcord + step6][scord - step6] == '#') {
                                    occSeats++
                                }
                            }
                            else step6++
                        }
                    }
                    var step7 = 1
                    var hitEdge7 = false //this is down
                    while(!hitEdge7) {
                        if (lineList[fcord + step7][scord] != '.' || (fcord + step7) == (lineList.size-1)) {
                            hitEdge7 = true
                            if (lineList[fcord + step7][scord] == '#') {
                                occSeats++
                            }
                        }
                        else step7++
                    }
                    if(scord<(lineList[fcord].size-1)) {//skipped if this is right column
                            var step8 = 1
                            var hitEdge8 = false //this is diagnal down right
                            while(!hitEdge8) {
                                if (lineList[fcord + step8][scord + step8] != '.' || (fcord + step8) == (lineList.size-1) || (scord + step8) == (lineList[fcord].size-1)) {
                                    hitEdge8 = true
                                    if (lineList[fcord + step8][scord + step8] == '#') {
                                        occSeats++
                                    }
                                }
                                else step8++
                            }
                        }
                }
                when (lineList[fcord][scord]) {
                    '.' -> singlestep[fcord].add('.')
                    'L' -> {
                        if (occSeats > 0) singlestep[fcord].add('L')
                        else {
                            singlestep[fcord].add('#')
                            stagnated = false
                        }
                    }
                    '#' -> {
                        if (occSeats<5) singlestep[fcord].add('#')
                        else {
                            singlestep[fcord].add('L')
                            stagnated = false
                        }
                    }
                }
            }
        }
        lineList = singlestep
    }
    var lCount =0
    for(fcord in 0..(lineList.size-1)) {
        println(lineList[fcord])
        lCount += lineList[fcord].count({ it == '#' })
    }
    println(lCount)
}