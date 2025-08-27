fun main(){
    val song1 = Song("High","Vybz Kartel",2010,20000)
    song1.songDescription()
    println(song1.isPopular)

}


class Song(
    val title:String,
    val artist:String,
    val yearPublished:Int,
    val playCount: Int,
){
    val isPopular: Boolean =  playCount >= 1000

//    val isPopular: Boolean
//        get() = playCount >= 1000

    fun songDescription(){
        println("$title, performed by $artist, was released in $yearPublished.")
    }
}