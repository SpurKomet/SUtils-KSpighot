package de.spurkomet.sutils.listener

import de.spurkomet.sutils.getPrefix
import net.axay.kspigot.chat.col
import net.axay.kspigot.event.listen
import net.axay.kspigot.extensions.bukkit.title
import org.bukkit.Effect
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType


fun joinListener(){
    listen<PlayerJoinEvent>{
        it.joinMessage = "${col("dark_gray")}[${col("dark_green")}+${col("dark_gray")}] ${col(if (it.player.isOp)"aqua" else "white")}${it.player.name}"
        /*it.player.title( "${col("yellow")}Willkommen! ${if(it.player.isOp) col("dark_red") else col("gray")}${it.player.name}",
            "${col ("dark_blue")}SUtils Server | powered by ${col("aqua")}Kot${col("white")}lin",
            4, 40, 10)*/
    }
}
