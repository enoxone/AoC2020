import java.io.File
main()
fun main() {
    var currentCube = HashMap<Quadruple<Int,Int,Int,Int>,Boolean>()
    val inputList = File("input17.txt").readLines()
    var inCordX = 0
    var inCordY = 0
    var inCordZ = 0
    var inCordW = 0
    for (line in inputList) {
        for (loc in line) {
            if(loc=='#') {
                currentCube.put(Quadruple(inCordX,inCordY,inCordZ,inCordW),true)
            }
            inCordX++
        }
        inCordY++
        inCordX = 0
    }
    println(currentCube)
    for (step in 1..6) {
        var nextstep = HashMap<Quadruple<Int,Int,Int,Int>,Boolean>()
        nextstep.putAll(currentCube)
        for (element in currentCube.keys) {
            println("checking for places surrounding $element")
            var locBeingChecked = mutableListOf<Quadruple<Int,Int,Int,Int>>(element)
            locBeingChecked.addAll(surroundingCords(element))
            for(surroundingElement in locBeingChecked) {
                val spotsToCheck = surroundingCords(surroundingElement)
                var activeAround = spotsToCheck.count{currentCube[it]?:false}
                println("$surroundingElement is surrounded by $activeAround actives")
                if (currentCube[surroundingElement]?:false) {
                    if(activeAround<2||activeAround>3) {
                        nextstep.remove(surroundingElement)
                    }
                }
                else {
                    if(activeAround==3) {
                        nextstep[surroundingElement] = true
                    }
                }
            }
        }
        currentCube = nextstep
    }
    //println(currentCube)
    println(currentCube.size)
    //println(surroundingCords(Triple(0,0,0)))
}
fun surroundingCords(center : Quadruple<Int,Int,Int,Int>) : MutableList<Quadruple<Int,Int,Int,Int>> {
    var returnList = mutableListOf<Quadruple<Int,Int,Int,Int>>()
    for(xC in (center.component1()-1)..(center.component1()+1)){
        for(yC in (center.component2()-1)..(center.component2()+1)){
            for(zC in (center.component3()-1)..(center.component3()+1)){
                for(wC in (center.component4()-1)..(center.component4()+1))
                if(Quadruple(xC,yC,zC,wC)!=center) {
                    returnList.add(Quadruple(xC,yC,zC,wC))
                }
            }
        }
    }
    //println(returnList.size)
    return returnList
}
public data class Quadruple<out A, out B, out C, out D>(
    public val first: A,
    public val second: B,
    public val third: C,
    public val fourth: D
    ){
    public override fun toString(): String = "($first, $second, $third, $fourth)"
}