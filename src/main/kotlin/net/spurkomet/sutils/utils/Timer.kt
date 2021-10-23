package net.spurkomet.sutils.utils

import net.axay.kspigot.chat.col
import net.axay.kspigot.extensions.broadcast
import net.axay.kspigot.extensions.bukkit.actionBar
import net.axay.kspigot.extensions.onlinePlayers
import net.axay.kspigot.runnables.task
import net.spurkomet.sutils.prefix
import net.spurkomet.sutils.settings.settings
import net.spurkomet.sutils.settings.settings.timer.countdown
import net.spurkomet.sutils.settings.settings.timer.time.time
import net.spurkomet.sutils.settings.settings.timer.time.sec
import net.spurkomet.sutils.settings.settings.timer.time.min
import net.spurkomet.sutils.settings.settings.timer.time.h
import net.spurkomet.sutils.settings.settings.timer.isRun
import net.spurkomet.sutils.settings.settings.timer.timer
import org.bukkit.Effect
import org.bukkit.GameMode
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns

fun runTimer(){
    calcToSec()
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
            it.actionBar("${col("red")}${col("italic")}Der Timer ist Pausiert.")
            it.addPotionEffect(PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 40, 5, false,false,false))
        }
    }
    else{
        onlinePlayers.forEach {
            it.actionBar("${col("black")}${if (h < 10)"0$h" else h}:${if (min < 10)"0$min" else min}:${if (sec < 10)"0$sec" else sec}")
        }
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

