package chapter_5

private val cachedSites: MutableMap<String, String> = HashMap()

private fun cachedSites(url: String): String? {
    return if (cachedSites.containsKey(url)) {
        println("get data from cache")
        cachedSites[url]
    } else {
        println("get data from server")
        val data = getDataFromServer(url)
        cachedSites[url] = data
        data
    }
}
fun getDataFromServer(url : String):String{
    return "data $url"
}

fun main() {
    println(cachedSites("facebook") )
    println(cachedSites("youtube") )
    println(cachedSites("facebook") )
    println(cachedSites("youtube") )


}