package net.spurkomet.sutils.listener

import net.axay.kspigot.chat.col
import net.axay.kspigot.event.listen
import org.bukkit.event.player.PlayerJoinEvent


fun joinListener(){
    listen<PlayerJoinEvent>{
        it.joinMessage = "${col("dark_gray")}[${col("dark_green")}+${col("dark_gray")}] ${col(if (it.player.isOp)"aqua" else "white")}${it.player.name}"
        /*it.player.title( "${col("yellow")}Willkommen! ${if(it.player.isOp) col("dark_red") else col("gray")}${it.player.name}",
            "${col ("dark_blue")}SUtils Server | powered by ${col("aqua")}Kot${col("white")}lin",
            4, 40, 10)*/
    }
}
