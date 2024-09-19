import kotlin.math.*

fun main(){
    print("Nhap toa do A: ")
    var xa = readln().toDouble()
    var ya = readln().toDouble()
    print("Nhap toa do B: ")
    var xb = readln().toDouble()
    var yb = readln().toDouble()
    var kq= sqrt((xb-xa).pow(2)+(yb-ya).pow(2))
    println("Ket qua la :${kq}")
}