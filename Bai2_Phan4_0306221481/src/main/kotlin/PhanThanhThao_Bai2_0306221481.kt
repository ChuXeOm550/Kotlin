

fun main(){
    print("Hãy nhập 1 đoạn văn bản: ")
    var van_ban= readln();

    var tach_chuoi=van_ban.split(" ")

    var dem_tu= mutableMapOf<String,Int>()

    for(tu in tach_chuoi){
        dem_tu[tu] = dem_tu.getOrDefault(tu,0)+1
    }

    println("Số lần xuất hiện của các từ trong văn bản: ")
    for((tu,solan) in dem_tu){
        println("$tu : $solan lần")
    }
}


