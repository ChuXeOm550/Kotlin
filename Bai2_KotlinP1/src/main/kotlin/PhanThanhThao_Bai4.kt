import kotlin.math.sqrt

fun main() {
    print("Nhap canh a: ")
    var a = readln().toFloat()
    print("Nhap canh b: ")
    var b = readln().toFloat()
    print("Nhap canh c: ")
    var c = readln().toFloat()
    var C= a+b+c
    val p=C/2
    val S=sqrt(p*(p-a)*(p-b)*(p-c))
    println("Chu vi tam giac: $C")
    println("Dien tich tam giac: $S")
}