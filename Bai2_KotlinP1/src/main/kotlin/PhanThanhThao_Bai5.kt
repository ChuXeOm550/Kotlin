import kotlin.math.pow

fun main(){
    print("Nhap ban kinh R: ")
    var R = readln().toFloat()
    print("Nhap do cao h: ")
    var h = readln().toFloat()
    val PI=3.14
    var Stron=PI*R.pow(2)
    println("The tih hinh tru: ${Stron*h}")
}