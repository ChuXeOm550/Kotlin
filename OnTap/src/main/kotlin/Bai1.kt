
fun NhapSoNguyen(): Int{
    var a:Int;
    do{
        print("Hãy nhập số nguyên N: ")
        a= readln().toInt()
    }while (a<=0)
    return a
}
fun tinhGiaiThua(n:Int):Int{
    if(n==0||n==1){
        return 1;
    }
    return n*tinhGiaiThua(n-1)
}

fun main(args: Array<String>) {
    var n=NhapSoNguyen();
    println("$n=${tinhGiaiThua(n)}")
}