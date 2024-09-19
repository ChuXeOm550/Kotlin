fun main(){
    val danhsach=ArrayList<String>()
    print("Nhập số lượng sinh viên: ")
    var n:Int= readln().toInt()

    println("---------------------------")
    println("Hãy nhập họ tên sinh viên")

    for(i in 1..n){
        println("Họ và tên sinh viên thứ $i: ")
        var name:String= readln()
        danhsach.add(name)
        println("---------------------------")
    }
    println("Danh sách sinh viên sau khi sắp xếp")

    val danhsach_sapxep=sap_xep(danhsach)
    danhsach_sapxep.forEach{println(it)}

}

fun sap_xep(a:ArrayList<String>):List<String>{
    //val chuyen_doi=Collator.getInstance(Locale("vi","VN"))
    var sorted=a.sortedWith(compareBy<String>({tach_ten(it)},{tach_ho(it)}))//.thenComparing(chuyen_doi::compare))
    return sorted
}

fun tach_ten(a:String):String{
    return a.substringAfterLast(" ") //tách mỗi tên ra vd: Phan Thành Thảo --> Thảo
}

fun tach_ho(a:String):String{
    return a.substringBeforeLast(" ") // Phan Thành
}

