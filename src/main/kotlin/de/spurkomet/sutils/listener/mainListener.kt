package de.spurkomet.sutils.listener

import de.spurkomet.sutils.getPrefix
import de.spurkomet.sutils.settings.damageIndicator
import de.spurkomet.sutils.utils.SuppenHeilung
import net.axay.kspigot.chat.*
import net.axay.kspigot.event.listen
import net.axay.kspigot.extensions.broadcast
import net.axay.kspigot.extensions.onlinePlayers
import net.md_5.bungee.api.chat.ClickEvent
import net.md_5.bungee.api.chat.HoverEvent
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.event.block.Action
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.PlayerChatEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerItemDamageEvent
import org.bukkit.inventory.ItemStack

fun mainListener() {
    listen<PlayerChatEvent> {
        it.format = "${col(if (it.player.isOp) "aqua" else "white")}%1\$s${col("dark_gray")} | ${col("white")}%2\$s"
    }
    listen<EntityDamageEvent> {
        if (it.entityType == EntityType.PLAYER && damageIndicator) {
            broadcast("${getPrefix()}${it.entity.name} hat ${it.finalDamage} HP Schaden bekommen.")
        }
    }

    listen<PlayerDeathEvent> {
        if(it.entity.player!!.isOp){
            val massage = literalText(
                "${getPrefix()}Du bist an der Position "
            ) {
                text("${col("red")}${col("bold")}${it.entity.location.blockX} ${col("blue")}${col("bold")}${it.entity.location.blockY} ${col("green")}${col("bold")}${it.entity.location.blockZ}") {
                    color = col("gray")
                    onClickCommand("/tp @s ${it.entity.location.blockX} ${it.entity.location.blockY} ${it.entity.location.blockZ}")
                    hoverText("click to teleport")
                }
                text(" gestorben.") {  }
            }
            it.entity.player!!.sendMessage(massage)
        }else{
            it.entity.player!!.sendMessage("${getPrefix()}Du bist an der Position ${col("red")}${col("bold")}${it.entity.location.blockX} ${col("blue")}${col("bold")}${it.entity.location.blockY} ${col("green")}${col("bold")}${it.entity.location.blockZ} ${col("white")}gestorben.")
        }




    }

    /*listen<PlayerInteractEvent> {
        val player = it.player
        val action = it.action
        player.sendMessage(player.inventory.itemInMainHand.toString())
        player.sendMessage(ItemStack(Material.MUSHROOM_STEM).toString())
        val soupHeal = 4
        val soupFood = 5
        val soupSateration = 3
        if (player.inventory.itemInMainHand.isSimilar(ItemStack(Material.MUSHROOM_STEM))){
            it.player.sendMessage("item in Main")
            if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK){
                player.sendMessage("Soup")
                val health = player.health
                val maxHealth = player.maxHealth
                val foot = player.foodLevel
                val sateration = player.saturation

                if (health < maxHealth){
                    if (health + soupHeal > maxHealth) player.health = maxHealth else player.health = player.health + soupHeal
                }
                else{
                    if (foot < 20) {
                        if (foot + soupFood > 20) player.foodLevel = 20 else player.foodLevel = player.foodLevel + soupFood
                        if (sateration + soupSateration > 20) player.saturation = 20F else player.saturation = player.saturation + soupSateration
                    }
                }
                player.inventory.itemInMainHand.type = Material.BOWL
            }
        }
    }*/

}


