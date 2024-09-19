fun NgayHopLe(Day: Int,Month: Int,Year: Int): Boolean{
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

fun main(){
    print("Nhập ngày: ")
    var a = readln().toInt()
    print("Nhập tháng: ")
    var b = readln().toInt()
    print("Nhập năm: ")
    var c = readln().toInt()
    if(NgayHopLe(a,b,c))
        print("Ngày hợp lệ")
    else
        print("Ngày không hợp lệ")
}