
class ThiSinh{
    var CCCD: String=""
    var hoTen: String=""
    var toan: Double = 0.0
    var li:Double = 0.0
    var hoa:Double = 0.0
    var van: Double = 0.0
    var anh:Double = 0.0
    var khoiThi:String=""

    constructor()

    constructor(CCCD:String,hoTen:String,toan:Double,li:Double,hoa:Double,van:Double,anh:Double,khoiThi:String)
    {
        this.CCCD=CCCD
        this.hoTen=hoTen
        this.toan=toan
        this.li=li
        this.hoa=hoa
        this.van=van
        this.anh=anh
        this.khoiThi=khoiThi
    }

    fun tinhTongDiem():Double{
        return when(khoiThi){
            "A00"-> toan + li + hoa
            "A01"-> toan + li + anh
            "D01"-> toan + van + anh
            else -> 0.0
        }
    }

    fun soSanh(thiSinhKhac:ThiSinh):Int{
        var bangchucai:String="A,Á,À,Ả,Ã,Ạ,Ă,Ắ,Ằ,Ẳ,Ẵ,Ặ,Â,Ấ,Ầ,Ẩ,Ẫ,Ậ,B,C,D,Đ,E,É,È,Ẻ,Ẽ,Ẹ,Ê,Ế,Ề,Ể,Ễ,Ệ,G,H,I,Í,Ì,Ỉ,Ĩ,Ị,K,L,M,N,O,Ó,Ò,Ỏ,Õ,Ọ,Ô,Ố,Ồ,Ổ,Ỗ,Ộ,Ơ,Ớ,Ờ,Ở,Ỡ,Ợ,P,Q,R,S,T,U,Ú,Ù,Ủ,Ũ,Ụ,Ư,Ứ,Ừ,Ử,Ữ,Ự,V,X,Y"
        var tenThiSinh1=this.hoTen.substringAfterLast(" ").uppercase()
        var tenThiSinh2=thiSinhKhac.hoTen.substringAfterLast(" ").uppercase()

        var i=0
        while(i<tenThiSinh1.length&&i<tenThiSinh2.length){
            if(bangchucai.indexOf(tenThiSinh1[i])>bangchucai.indexOf(tenThiSinh2[i])){
                return 1
            }
            else if (bangchucai.indexOf(tenThiSinh1[i])<bangchucai.indexOf(tenThiSinh2[i])){
                return -1
            }
            else{
                var hoThiSinh1=this.hoTen.substringBeforeLast(" ").uppercase().replace(" ","")
                //print("$hoThiSinh1")
                var hoThiSinh2=thiSinhKhac.hoTen.substringBeforeLast(" ").uppercase().replace(" ","")
                //print("$hoThiSinh2")
                if(bangchucai.indexOf(hoThiSinh1[i])>bangchucai.indexOf(hoThiSinh2[i])){
                    return 1
                }
                else if (bangchucai.indexOf(hoThiSinh1[i])<bangchucai.indexOf(hoThiSinh2[i])){
                    return -1
                }
                else
                    return 0
            }
        }
        return 0

//        val soSanhTen=tenThiSinh1.substringAfterLast(" ").compareTo(tenThiSinh2.substringAfterLast(" "))
//
//        if(soSanhTen<0){
//            return -1;
//        }
//        else if(soSanhTen>0){
//            return 1;
//        }
//        else{
//            val soSanhHo=tenThiSinh1.substringBeforeLast(" ").compareTo(tenThiSinh2.substringBeforeLast(" "))
//            if(soSanhHo<0){
//                return -1;
//            }
//            else if(soSanhHo>0){
//                return 1;
//            }
//            else
//                return 0;
//        }
    }

    fun hienThiThongTin() {
        println("CCCD: $CCCD, Họ tên: $hoTen, Khối thi: $khoiThi, Tổng điểm: ${tinhTongDiem()}")
    }

}

fun nhapDanhSachThiSinh(): MutableList<ThiSinh> {
    val danhSach = mutableListOf<ThiSinh>()
    print("Nhập số lượng thí sinh:")
    val soLuong = readLine()?.toIntOrNull() ?: 0

    for (i in 1..soLuong) {
        println("-------------------------------")
        println("Nhập thông tin thí sinh thứ $i:")
        print("CCCD:")
        val CCCD = readLine().orEmpty()
        print("Họ tên:")
        val hoTen = readLine().orEmpty()
        print("Điểm Toán:")
        val diemToan = readLine()?.toDoubleOrNull() ?: 0.0
        print("Điểm Lý:")
        val diemLy = readLine()?.toDoubleOrNull() ?: 0.0
        print("Điểm Hóa:")
        val diemHoa = readLine()?.toDoubleOrNull() ?: 0.0
        print("Điểm Văn:")
        val diemVan = readLine()?.toDoubleOrNull() ?: 0.0
        print("Điểm Anh:")
        val diemAnh = readLine()?.toDoubleOrNull() ?: 0.0
        print("Khối thi (A00, A01, D01):")
        val khoiThi = readLine().orEmpty()

        val thiSinh = ThiSinh(CCCD, hoTen, diemToan, diemLy, diemHoa, diemVan, diemAnh, khoiThi)
        danhSach.add(thiSinh)
    }

    return danhSach
}
fun main(){
    val danhSachThiSinh = nhapDanhSachThiSinh()

    danhSachThiSinh.sortWith { ts1, ts2 -> ts1.soSanh(ts2) }

    print("Nhập điểm chuẩn:")
    val diemChuan = readLine()?.toDoubleOrNull() ?: 0.0

    println("Danh sách thí sinh trúng tuyển:")
    for (thiSinh in danhSachThiSinh) {
        if (thiSinh.tinhTongDiem() >= diemChuan) {
            thiSinh.hienThiThongTin()
        }
    }
}