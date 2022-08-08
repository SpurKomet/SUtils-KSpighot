package de.spurkomet.sutils.utils

import net.axay.kspigot.event.listen
import org.bukkit.Material
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import de.spurkomet.sutils.settings.global.settings.soup.soup
import de.spurkomet.sutils.settings.global.settings.soup.heal
import de.spurkomet.sutils.settings.global.settings.soup.food
import de.spurkomet.sutils.settings.global.settings.soup.sateration
import net.axay.kspigot.extensions.bukkit.getHandItem
import org.bukkit.GameMode
import org.bukkit.attribute.Attribute
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemStack

fun soupHealing(){
    listen<PlayerInteractEvent> {
        if(soup){//Soup = true
            val player = it.player
            val action = it.action
            if (player.gameMode.equals(GameMode.SURVIVAL)){
                if (player.getHandItem(EquipmentSlot.HAND) == ItemStack(Material.MUSHROOM_STEW)){
                    if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK){
                        val playerHealth = player.health
                        val playerMaxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.value
                        val playerFoot = player.foodLevel
                        val playerSateration = player.saturation
                        if (playerMaxHealth != null && playerHealth < playerMaxHealth){
                            if (playerHealth + heal > playerMaxHealth) {player.health = playerMaxHealth} else {player.health = player.health + heal}
                            player.inventory.itemInMainHand.type = Material.BOWL
                        }else{
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
}
