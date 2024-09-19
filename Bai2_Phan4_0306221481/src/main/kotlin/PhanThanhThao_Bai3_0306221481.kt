fun main(){
    var danhSach_QG = mutableMapOf<String,String>()
    var runing:Boolean=true

    do {
        println("---VUI LÒNG CHỌN CHỨC NĂNG---")
        println("1.Nhập - Xuất danh sách")
        println("2.Thêm mới danh sách")
        println("3.Xóa quốc gia")
        println("4.Tìm quốc gia")
        println("5.Hiển thị danh mục theo kí tự đầu")
        println("6.Thoát")
        print("Nhập chọn: ")
        var choice:Int= readln().toInt()

        when(choice){
            1 -> Nhap_Xuat(danhSach_QG)
            2 -> them_Moi(danhSach_QG)
            3 -> xoa_QG(danhSach_QG)
            4 -> tim_Kiem(danhSach_QG)
            5 -> hienThi_dsTheoKiTu(danhSach_QG)
            else -> runing=false
        }
    }while (runing==true)

}

fun Nhap_Xuat(danhSach:MutableMap<String,String>){
    if(danhSach.isEmpty()){
        println("Danh sách hiện đang trống")
    }
    else{
        for((ma,ten) in danhSach){
            println("$ma - $ten")
        }
    }
    println("-------------------------")
}

fun them_Moi(danhSach: MutableMap<String, String>){
    print("Nhập mã quốc gia: ")
    var ma_QG = readln().uppercase()
    print("Nhập tên quốc gia: ")
    var ten_QG = readln()

    if(danhSach.containsKey(ma_QG)){
        println("Mã quốc gia này đã tồn tại")
    }
    else{
        danhSach.put(ma_QG,ten_QG)
        println("Thêm thành công")
    }
    println("-------------------------")
}

fun xoa_QG(danhSach: MutableMap<String, String>){
    print("Nhập mã quốc gia muốn xóa: ")
    var ma_QG= readln().uppercase()

    if(danhSach.containsKey(ma_QG)){
        danhSach.remove(ma_QG)
    }
    else{
        println("Không tìm thấy quốc gia mã $ma_QG để xóa")
    }
    println("-------------------------")
}

fun tim_Kiem(danhSach: MutableMap<String, String>){
    print("Nhập tên quốc gia muốn tìm mã: ")
    var ten_QG= readln()

    val result=danhSach.filterValues { it.equals(ten_QG, ignoreCase = true) }

    if(result.isEmpty())
        println("Không tìm thấy quốc gia $ten_QG")
    else
    {
        for((ma,ten) in result){
            println("Quốc gia $ten_QG có mã: $ma")
        }
    }
    println("-------------------------")
}

fun hienThi_dsTheoKiTu(danhSach: MutableMap<String, String>){
    print("Nhập 1 kí tự: ");
    var word= readln().uppercase()

    val result=danhSach.filterKeys { it.startsWith(word) } //Bắt đầu mới

    if(result.isEmpty()){
        println("Không tồn tại quốc gia có kí tự đầu là $word")
    }
    else{
        println("Danh mục các quốc gia có mã bắt đầu là kí tự $word")
        for((ma,ten) in result){
            println("$ma")
        }
    }
    println("-------------------------")
}