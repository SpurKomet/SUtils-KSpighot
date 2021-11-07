package net.spurkomet.sutils.utils

import net.axay.kspigot.chat.col
import net.axay.kspigot.event.listen
import net.axay.kspigot.extensions.broadcast
import net.spurkomet.sutils.prefix
import net.spurkomet.sutils.settings.*
import org.bukkit.Material
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack
import net.spurkomet.sutils.settings.settings.soup.soup
import net.spurkomet.sutils.settings.settings.soup.heal
import net.spurkomet.sutils.settings.settings.soup.food
import net.spurkomet.sutils.settings.settings.soup.sateration

fun soupHealing(){
    listen<PlayerInteractEvent> {
        if(soup){//Soup = true
            val player = it.player
            val action = it.action
            broadcast(player.inventory.itemInMainHand.toString() + "|" + ItemStack(Material.MUSHROOM_STEM).toString())
            if (player.inventory.itemInMainHand.toString() != ItemStack(Material.MUSHROOM_STEM).toString()){
                broadcast(player.inventory.itemInMainHand.toString())
                broadcast(action.toString())
                if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK){
                    broadcast("action.toString()")
                    player.sendMessage("Soup")
                    val playerHealth = player.health
                    val playerMaxHealth = player.maxHealth
                    val playerFoot = player.foodLevel
                    val playerSateration = player.saturation
                    broadcast("$soup\nHeal: $heal\nfood: $food\nsad: $sateration")

                    if (playerHealth < playerMaxHealth){
                        if (playerHealth + heal > playerMaxHealth) {player.health = playerMaxHealth} else {player.health = player.health + heal}
                        player.inventory.itemInMainHand.type = Material.BOWL
                    }
                    else{
                        if (playerFoot < 20) {
                            if (playerFoot + food > 20) {player.foodLevel = 20} else {player.foodLevel = playerFoot + food}
                            if (playerSateration + sateration > 20) player.saturation = 20F else player.saturation = playerSateration + sateration
                            player.inventory.itemInMainHand.type = Material.BOWL
                        }
                    }
                }
            }
        }
    }
}