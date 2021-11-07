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
}

