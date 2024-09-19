fun main(){
    var a: Int

    do{
        print("Nhập số N (100<N<999): ")
        a= readln().toInt()
    }while (a<100 || a>999)
    var ht: Int=a/100
    var hc=a%100/10
    var hdv=a%100%10

    ChuSo(ht)
    print(" Trăm ")
    if(hc==0){
        if(hdv==0)
            print("")
        else
            print("Linh ")
    }
    else if(hc==1)
        print("Mười ")
    else{
        ChuSo(hc)
        print(" Mươi ")
    }

    if(hdv==0)
        print("")
    if(hdv==1){
        if(hc<2)
            print("Một")
        else
            print("Mốt")
    }
    else if(hdv==5){
        if(hc==0)
            ChuSo(hdv)
        else
            print("Lăm")
    }
    else{
        ChuSo(hdv)
    }
}

fun ChuSo(num:Int){
    var chu = when(num){
        1->"Một"
        2->"Hai"
        3->"Ba"
        4->"Bốn"
        5->"Năm"
        6->"Sáu"
        7->"Bảy"
        8->"Tám"
        9->"Chín"
        else->""
    }
    print(chu);
}