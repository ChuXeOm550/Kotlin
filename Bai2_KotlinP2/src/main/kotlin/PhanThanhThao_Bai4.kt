fun demNgay(Day: Int,Month: Int, Year: Int):Int{
    val ngayTrongThang = arrayOf(31,28,31,30,31,30,31,31,30,31,30,31)
    if(NamNhuan(Year))
        ngayTrongThang[1]=29
    var tongNgay: Int=0
    for (i in 0..Month-2)
        tongNgay+=ngayTrongThang[i]
    tongNgay+=Day
    return tongNgay
}

fun main(){
    var a: Int
    var b: Int
    var c: Int
    do{
        print("Nhập ngày: ")
        a = readln().toInt()
        print("Nhập tháng: ")
        b = readln().toInt()
        print("Nhập năm: ")
        c = readln().toInt()
        print("--------------------------\n")
    }while (NgayHopLe(a,b,c)==false)

    print("Ngày $a/$b/$c là ngày thứ ${demNgay(a,b,c)} của năm")
}