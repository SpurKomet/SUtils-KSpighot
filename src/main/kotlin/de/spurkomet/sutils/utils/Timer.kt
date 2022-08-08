package de.spurkomet.sutils.utils

import net.axay.kspigot.chat.col
import net.axay.kspigot.extensions.broadcast
import net.axay.kspigot.extensions.bukkit.actionBar
import net.axay.kspigot.extensions.onlinePlayers
import net.axay.kspigot.runnables.task
import de.spurkomet.sutils.settings.global.settings
import de.spurkomet.sutils.settings.global.settings.timer.countdown
import de.spurkomet.sutils.settings.global.settings.timer.time.time
import de.spurkomet.sutils.settings.global.settings.timer.time.sec
import de.spurkomet.sutils.settings.global.settings.timer.time.min
import de.spurkomet.sutils.settings.global.settings.timer.time.h
import de.spurkomet.sutils.settings.global.settings.timer.isRun
import de.spurkomet.sutils.settings.global.settings.timer.timer
import org.bukkit.GameMode

fun runTimer(){
    task(
        true,
        20,
        20
    )
    {
        if (!timer){
            it.cancel()
        }
        if (isRun){
            if (countdown){
                time--
                if (time == 0){
                    broadcast("${col("red")}GameOver ${col("green")}- Zeit abgelaufen")
                    settings.timer.countdown = false
                    settings.timer.isRun = false
                    onlinePlayers.forEach { it.gameMode = GameMode.SPECTATOR }
                }
            }else{
                time++
            }
            calcToRead()
        }
        barTimer()
    }
}

fun barTimer(){
    if (!isRun){
        onlinePlayers.forEach {
            it.actionBar("${col("aqua")}${col("italic")}${if (h < 10)"0$h" else h}:${if (min < 10)"0$min" else min}:${if (sec < 10)"0$sec" else sec} (frozed)")
        }
    }
    else{
        onlinePlayers.forEach {
            it.actionBar("${col("black")}${if (h < 10)"0$h" else h}:${if (min < 10)"0$min" else min}:${if (sec < 10)"0$sec" else sec}")

        }
    }
    if (!timer){
        onlinePlayers.forEach{it.actionBar("")}
    }
}
fun calcToSec(){
    time = ((h*3600)+(min*60)+sec)
}
fun calcToRead(){
    sec = (time-(time/60)*60)
    min = (time/60-(time/3600)*60)
    h = time/3600
}

