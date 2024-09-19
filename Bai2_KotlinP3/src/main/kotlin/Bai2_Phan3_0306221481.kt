import java.util.Calendar

fun main(){
    var runing:Boolean=true
    do {
        println("1. Tính tổng từ 1 đến N")
        println("2. Tính biểu thức X Y")
        println("3. Chọn ngày gần nhất")
        println("4. Kiểm tra số đối xứng")
        println("5. Kiểm tra số tiến")
        println("6. Bao nhiêu số đối xứng")
        println("7. Bao nhiêu số tiến")
        println("Ấn số bất kì để thoát")
        print("Chọn bài thực hành: ")
        var choice= readln().toInt()
        when(choice){
            1 -> bai_1()
            2 -> bai_2()
            3 -> bai_3()
            4 -> bai_4()
            5 -> bai_5()
            6 -> bai_6()
            7 -> bai_7()
            else -> runing=false
        }
    }while (runing==true)


}

fun bai_1(){
    var n=nhapSoNguyen();
    println("Tổng từ 1 đến $n: ${tinhTong(n)}")
    println("----------------------------")
}
fun nhapSoNguyen():Int{
    var n:Int
    do {
        print("Nhập số nguyên: ")
        n = readln().toInt()
    }while(n<0)
    return n
}
fun tinhTong(n:Int): Int{
    var tong:Int=0
    for(i:Int in 1..n){
        tong+=i
    }
    return tong
}


fun bai_2(){
    var n=nhapSoNguyen();
    println("X($n) = ${X(n)})")
    println("Y($n) = ${Y(n)})")
    println("----------------------------")
}
fun X(n:Int):Int{
    if(n==0) return 1
    return X(n-1)+Y(n-1)
}
fun Y(n:Int):Int{
    if(n==0) return 0
    return 3*X(n-1) +2 *Y(n-1)
}


fun bai_3(){
    println("Nhập ngày thứ 1: ");
    val date1=nhapDate();

    println("-----------------------------")

    println("Nhập ngày thứ 2: ");
    val date2=nhapDate();

    when {
        date1.before(date2) -> println("Ngày sớm nhất là: ${date1.get(Calendar.DAY_OF_MONTH)}/${date1.get(Calendar.MONTH) + 1}/${date1.get(Calendar.YEAR)}")
        date2.before(date1) -> println("Ngày sớm nhất là: ${date2.get(Calendar.DAY_OF_MONTH)}/${date2.get(Calendar.MONTH) + 1}/${date2.get(Calendar.YEAR)}")
        else -> println("Hai ngày bằng nhau.")
    }
    println("-----------------------------")
}
fun nhapDate():Calendar{
    var Ngay:Int;
    var Thang:Int;
    var Nam:Int
    do {
        print("Nhập ngày: ")
        Ngay = readln().toInt()
        print("Nhập tháng: ")
        Thang = readln().toInt()
        print("Nhập năm: ")
        Nam = readln().toInt()
        if(ngayHopLe(Ngay,Thang,Nam)==false)
        {
            println("Nhập lại")
            println("----------------------------------")
        }
    }while (ngayHopLe(Ngay,Thang,Nam)==false)
    Thang-=1; //Calendar tháng bắt đầu từ 0

    return Calendar.getInstance().apply {
        set(Nam,Thang,Ngay);
    }
}
fun ngayHopLe(Day: Int,Month: Int,Year: Int): Boolean{
    if(Year<1)
        return false
    if(Month<1||Month>12)
        return false
    val ngayTrongThang = arrayOf(31,28,31,30,31,30,31,31,30,31,30,31)

    if(NamNhuan(Year))
        ngayTrongThang[1]=29
    if(Day<1 || Day>ngayTrongThang[Month-1])
        return false
    return true
}
fun NamNhuan(Year: Int): Boolean{
    if(Year%400==0||(Year%4==0&&Year%100!=0))
        return true
    return false
}


fun bai_4(){
    val n:Int=nhapSo();
    if(soDoiXung(n))
        println("$n là số đối xứng")
    else
        println("$n không là số đối xứng")
    println("-------------------------")
}
fun nhapSo():Int{
    var So:Int
    do{
        print("Nhập số nguyên có 4 đến 7 chữ số: ");
        So= readln().toInt();
    }while (So<1000||So>9999999)

    return So;
}
fun soDoiXung(n:Int):Boolean{
    val nStr=n.toString();
    val reversed = nStr.reversed();

    if(nStr==reversed)
        return true
    return false;
}

fun bai_5(){
    val n:Int=nhapSo()
    if(soTien(n))
        println("$n là số tiến")
    else
        println("$n không là số tiến")
    println("--------------------------")
}
fun soTien(n:Int):Boolean{
    val nStr:String=n.toString();

    for(i in 0 .. (nStr.length-2)){
        if(nStr[i]>=nStr[i+1])
            return false
    }
    return true
}

fun bai_6(){
    val n:Int=nhapSo();
    println("Từ 100 đến $n có: ${demGiaTriDX(n)} số đối xứng có tổng chữ số chia hết cho 3")
    println("---------------------------------")

}
fun tongChuSo(i:Int):Int{
    var tong:Int=0
    var n=i
    while (n>0){
        tong+=n%10
        n/=10
    }
    return tong
}
fun demGiaTriDX(n:Int):Int{
    var dem:Int=0
    for(i in 100..n)
    {
        if(soDoiXung(i) && tongChuSo(i)%3==0){
            dem++
        }
    }
    return dem
}

fun bai_7(){
    val n:Int=nhapSo();
    println("Từ 100 đến $n có: ${demGiaTriT(n)} số đối tiến có tổng chữ số chia hết cho 3")
    println("---------------------------------")
}
fun demGiaTriT(n:Int):Int{
    var dem:Int=0
    for(i in 100..n)
    {
        if(soTien(i) && tongChuSo(i)%5==0){
            dem++
        }
    }
    return dem
}
