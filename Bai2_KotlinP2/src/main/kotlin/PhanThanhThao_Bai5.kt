fun tinhThanhTien(soKg: Double,donGia: Double): Double{
    var thanhtien=soKg*donGia

    when{
        soKg>500 -> thanhtien*=0.95
        soKg>100 -> thanhtien*=0.97
        soKg>50 -> thanhtien*=0.98
    }
    return  thanhtien
}


fun main(){
    var tongTien=0.0

    while (true){
        print("Nhập số kg gạo: ")
        var soKg = readln().toDoubleOrNull() ?: break

        print("Nhập đơn giá gạo: ")
        var donGia = readln().toDoubleOrNull() ?: break

        if(soKg<=0||donGia<=0) break

        tongTien+=tinhThanhTien(soKg,donGia);
        print("Thành tiền loại gạo này: ${tinhThanhTien(soKg,donGia)}\n")
    }
    print("Tổng tiền các loại gạo là: $tongTien")
}