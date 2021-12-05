package net.spurkomet.sutils

import net.axay.kspigot.chat.col

object prefixs{
    fun timer(): String{
        return "${prefix()}${col("dark_aqua")}Timer:${col("dark_gray")} ${col("white")}"
    }
    fun soup(): String{
        return "${prefix()}${col("dark_aqua")}Soup:${col("dark_gray")} ${col("white")}"
    }
}
object usages{
    fun timer(): String{
        return "${prefix()}Verwendung: ${col("gray")}/timer ${col("blue")}resume ${col("white")}| ${col("blue")}pause ${col("white")}| ${col("blue")}reset"
    }
    fun reset(): String{
        return "${prefix()}Verwendung: ${col("gray")}/resetandrestart ${col("blue")}true ${col("white")}| ${col("blue")}false"
    }
}
object colors{
    val admin = "dark_red"
}
