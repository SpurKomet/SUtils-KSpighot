package de.spurkomet.sutils.utils

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.block.Action
import org.bukkit.inventory.ItemStack

fun SuppenHeilung(player: Player, action: Action){
    val soupHeal = 4
    val soupFood = 5
    val soupSateration = 3
        if(true){//Soup = true
            if (player.inventory.itemInMainHand.isSimilar(ItemStack(Material.MUSHROOM_STEM))){
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
        }
    }