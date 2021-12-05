package net.spurkomet.sutils.listener

import net.spurkomet.sutils.settings.settings.damageIndicator
import net.axay.kspigot.chat.*
import net.axay.kspigot.event.listen
import net.axay.kspigot.extensions.broadcast
import net.axay.kspigot.extensions.onlinePlayers
import net.kyori.adventure.text.Component
import net.spurkomet.sutils.colors
import net.spurkomet.sutils.prefix
import net.spurkomet.sutils.settings.settings
import org.bukkit.GameMode
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.PlayerChatEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import java.math.RoundingMode
import kotlin.math.roundToLong

fun mainListener() {
    listen<PlayerJoinEvent> {
        it.joinMessage(Component.text("${col("dark_gray")}[${col("dark_green")}+${col("dark_gray")}] ${col(if (it.player.isOp) colors.admin else "white")}${it.player.name}"))

        /*it.player.title( "${col("yellow")}Willkommen! ${if(it.player.isOp) col("aqua") else col("white")}${it.player.name}",
            "${col ("dark_aqua")}SUtils Server | powered by ${col("aqua")}Kot${col("white")}lin",
            4, 40, 10)*/
    }
    listen<PlayerQuitEvent> {
        it.quitMessage(Component.text("${col("dark_gray")}[${col("dark_red")}-${col("dark_gray")}] ${col(if (it.player.isOp) colors.admin else "withe")}${it.player.name}"))
        if (onlinePlayers.isEmpty()){
            settings.timer.isRun = false
        }
    }
    listen<PlayerChatEvent> {
        it.format = "${col(if (it.player.isOp) colors.admin else "white")}%1\$s${col("dark_gray")} | ${col("white")}%2\$s"
    }
    listen<EntityDamageEvent> {
        if (settings.timer.isRun || !settings.timer.timer) {
            if (it.entityType == EntityType.PLAYER && damageIndicator) {
                if (it.cause != EntityDamageEvent.DamageCause.ENTITY_ATTACK && it.cause != EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK && it.cause != EntityDamageEvent.DamageCause.ENTITY_EXPLOSION && it.cause != EntityDamageEvent.DamageCause.PROJECTILE) {
                    broadcast("${prefix()}${col("green")}${it.entity.name} ${col("red")}hat Schaden bekommen - [${it.finalDamage.roundToLong()}]")
                }
            }
        }
        //----- Timer -----
        if (it.entity.type == EntityType.PLAYER && !settings.timer.isRun && settings.timer.timer) {
            it.isCancelled = true
        }
        if (it.entity.type == EntityType.PLAYER && settings.timer.isRun) {
            it.isCancelled = false
        }
        if (settings.troll.oneHit) {
            it.damage = 2000000000.0
        }
    }

    listen<EntityDamageByEntityEvent> {
        if (settings.timer.isRun || !settings.timer.timer) {
            if (it.entityType == EntityType.PLAYER && damageIndicator) {
                broadcast(
                    "${prefix()}${col("green")}${it.entity.name} ${col("red")}was attacked by ${col("green")}${it.damager.name}${
                        col(
                            "red"
                        )
                    } - [${it.finalDamage.toBigDecimal().setScale(4, RoundingMode.FLOOR)}]"
                )
            }
        }
    }

    listen<PlayerDeathEvent> {
        val player = it.entity.player
        if (player != null){
            if (player.isOp) {
                val massage = literalText(
                    "${prefix()}Du bist an der Position "
                ) {
                    text(
                        "${col("red")}${col("bold")}${it.entity.location.blockX} ${col("blue")}${col("bold")}${it.entity.location.blockY} ${
                            col(
                                "green"
                            )
                        }${col("bold")}${it.entity.location.blockZ}"
                    ) {
                        color = col("gray")
                        onClickCommand("/tp @s ${it.entity.location.blockX} ${it.entity.location.blockY} ${it.entity.location.blockZ}")
                        hoverText("Click to teleport")
                    }
                    text(" gestorben.") { }
                }
                player.sendMessage(massage)
            } else {
                player.sendMessage(
                    "${prefix()}Du bist an der Position ${col("red")}${col("bold")}${it.entity.location.blockX} ${
                        col(
                            "blue"
                        )
                    }${col("bold")}${it.entity.location.blockY} ${col("green")}${col("bold")}${it.entity.location.blockZ} ${
                        col(
                            "white"
                        )
                    }gestorben."
                )
            }
        }
        if (settings.timer.timer){
            settings.timer.isRun = false
            onlinePlayers.forEach { it.gameMode = GameMode.SPECTATOR }
            broadcast("${col("red")}GameOver ${col("green")}- ${it.entity.name} died!")
        }
    }
}


