fun main(){
    print("Nhập số điện: ")
    var elec = readln().toInt();
    print("Nhập loại hộ gia đình (K:Hộ kinh doanh) : ")
    var houseHold= readln().toString()
    var tongTien=0
    if(houseHold=="K")
        if(elec<=50)
            tongTien=1678
        else if(elec<=100)
            tongTien=1734
        else
            tongTien=2014
    else
        if(elec<=50)
            tongTien=1549
        else if(elec<=100)
            tongTien=1600
        else
            tongTien=1858
    print("Tổng tiền điện: $tongTien")
}