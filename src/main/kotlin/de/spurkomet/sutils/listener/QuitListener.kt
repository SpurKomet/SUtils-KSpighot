package de.spurkomet.sutils.listener

import net.axay.kspigot.chat.col
import net.axay.kspigot.event.listen
import org.bukkit.event.player.PlayerQuitEvent


fun quitListener(){
    listen<PlayerQuitEvent> {
        it.quitMessage = "${col("dark_gray")}[${col("dark_red")}-${col("dark_gray")}] ${col(if (it.player.isOp)"aqua" else "withe")}${it.player.name}"
    }
}
