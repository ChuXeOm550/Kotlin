
open class SinhVien(mssv:String, hoTen: String, namSinh: Int=2005){
    var mssv: String=""
    var hoTen: String=""
    var namSinh: Int?=null

    init{
        this.mssv=mssv
        this.hoTen=hoTen
        this.namSinh=namSinh
    }
    open fun HienThi(){
        var mess="Sinh viên tên $hoTen có mssv $mssv"
        if(namSinh!=null){
            mess+=" sinh năm $namSinh"
        }
        println(mess)
    }
}

class SinhVienCNTT(mssv: String, hoTen: String, namSinh: Int):SinhVien(mssv,hoTen,namSinh){
    init {
        println("Sinh viên CNTT")
        this.mssv=mssv
        this.hoTen=hoTen
        this.namSinh=namSinh
    }

    override fun HienThi() {
        //super.HienThi()
        var mess="Sinh viên tên $hoTen có mssv $mssv"
        if(namSinh!=null){
            mess+=" sinh năm $namSinh"
        }
        println(mess+ " là sinh viên CNTT")
    }


}


fun main(){
    var s= SinhVien("0306221481","Phan Thành Thảo",2003)
//    s.hoTen="Phan Thành Thảo"
//    s.mssv="030622141"
//    s.namSinh=2004
//    s.hoTen="Thành"
    s.HienThi()
    var s1=SinhVienCNTT("111","Thành", 2004)
    s1.HienThi()
}