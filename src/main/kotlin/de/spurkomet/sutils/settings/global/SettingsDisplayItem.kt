package de.spurkomet.sutils.settings.global

import de.spurkomet.sutils.settings.global.settings.betterMinecraft.noCreeperBlockDamage
import net.axay.kspigot.chat.col
import net.axay.kspigot.items.*
import org.bukkit.Material
import de.spurkomet.sutils.settings.global.settings.damageIndicator
import net.kyori.adventure.text.Component
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import de.spurkomet.sutils.settings.global.settings.timer.timer as timerTimer
import de.spurkomet.sutils.settings.global.settings.timer.time.sec as timerSec
import de.spurkomet.sutils.settings.global.settings.timer.time.min as timerMin
import de.spurkomet.sutils.settings.global.settings.timer.time.h as timerH
import de.spurkomet.sutils.settings.global.settings.timer.countdown as timerCountdown
import de.spurkomet.sutils.settings.global.settings.soup.soup as soupSoup
import de.spurkomet.sutils.settings.global.settings.soup.sateration as soupSaturation
import de.spurkomet.sutils.settings.global.settings.soup.food as soupFood
import de.spurkomet.sutils.settings.global.settings.soup.heal as soupHeal

object SettingsDisplayItem {
    val back = itemStack(Material.IRON_SWORD) {
        amount = 1
        meta {
            name = Component.text("${col("dark_red")}<- ${col("gray")}Settings")
            flag(ItemFlag.HIDE_ATTRIBUTES)
        }
    }
    object generel{
        fun damageIndicator(): ItemStack{
            return  itemStack(Material.IRON_SWORD) {
                amount = 1
                meta {
                    name = Component.text("${col("gray")}Damage Indicator " +
                            "${col("white")}[${
                                if (damageIndicator) {
                                    "${col("green")}aktiv"
                                } else {
                                    "${col("red")}deaktiv"
                                }
                            }${col("white")}]")
                    flag(ItemFlag.HIDE_ATTRIBUTES)
                }
            }
        }
        fun soup(): ItemStack{
            return itemStack(Material.MUSHROOM_STEW) {
                amount = 1
                meta {
                    name = Component.text("${col("gray")}Soup Settings ${col("dark_green")}->")
                    flag(ItemFlag.HIDE_ATTRIBUTES)
                }
            }
        }
        fun timer(): ItemStack{
            return itemStack(Material.CLOCK) {
                amount = 1
                meta {
                    name = Component.text("${col("gray")}Timer Settings ${col("dark_green")}->")
                    flag(ItemFlag.HIDE_ATTRIBUTES)
                }
            }
        }
        fun backpack(): ItemStack{
            return itemStack(Material.BUNDLE) {
                amount = 1
                meta {
                    name = Component.text("${col("gray")}Backpack Settings ${col("dark_green")}->")
                    flag(ItemFlag.HIDE_ATTRIBUTES)
                }
            }
        }
        fun noCreeper(): ItemStack = itemStack(Material.CREEPER_HEAD) {
            amount = 1
            meta {
                name = Component.text("${col("gray")}Creeper Block Damage " +
                        "${col("white")}[${
                            if (!noCreeperBlockDamage) {
                                "${col("green")}aktiv"
                            } else {
                                "${col("red")}deaktiv"
                            }
                        }${col("white")}]")
                flag(ItemFlag.HIDE_ATTRIBUTES)
            }
        }
    }
    object soup{
        fun soup(): ItemStack{
            return itemStack(Material.MUSHROOM_STEW) {
                amount = 1
                meta {
                    name = Component.text("${col("gray")}Soup Healing " +
                            "${col("white")}[${
                                if (soupSoup) {
                                    "${col("green")}aktiv"
                                } else {
                                    "${col("red")}deaktiv"
                                }
                            }${col("white")}]")
                }
            }
        }
        fun heal(): ItemStack{
            return itemStack(Material.ENCHANTED_GOLDEN_APPLE) {
                amount = soupHeal
                meta {
                    name = Component.text("${col("white")}Heal (in HP)")
                    addLore {
                        +"Right Click to Up"
                        +"Left Click to Down"
                    }
                }
            }
        }
        fun food(): ItemStack{
            return itemStack(Material.COOKED_PORKCHOP) {
                amount = if (soupFood == 0) 1 else soupFood
                meta {
                    name = Component.text("${col("white")}Foot")
                    addLore {
                        +"Right Click to Up"
                        +"Left Click to Down"
                    }
                }
            }
        }
        fun saturation(): ItemStack{
            return itemStack(Material.GOLDEN_CARROT) {
                amount = if (soupSaturation == 0) 1 else soupSaturation
                meta {
                    name = Component.text("${col("white")}Sateration")
                    addLore {
                        +"Right Click to Up"
                        +"Left Click to Down"
                    }
                }
            }
        }
    }
    object timer {
        fun h(): ItemStack{
            return itemStack(Material.COMPASS) {
                amount = if (timerH == 0) 1 else timerH
                meta {
                    name = Component.text("${col("white")}$timerH ${col("gray")}Stunden")
                    addLore {
                        +"Left Click to Up"
                        +"Right Click to Down"
                    }
                }
            }
        }
        fun min(): ItemStack{
            return itemStack(Material.COMPASS) {
                amount = if (timerMin == 0) 1 else timerMin
                meta {
                    name = Component.text("${col("white")}$timerMin ${col("gray")}Minuten")
                    addLore {
                        +"Left Click to Up"
                        +"Right Click to Down"
                    }
                }
            }
        }
        fun sec(): ItemStack{
            return itemStack(Material.COMPASS) {
                amount = if (timerSec == 0) 1 else timerSec
                meta {
                    name = Component.text("${col("white")}$timerSec ${col("gray")}Sekunden")
                    addLore {
                        +"Left Click to Up"
                        +"Right Click to Down"
                    }
                }
            }
        }
        fun countdown(): ItemStack{
            return itemStack(Material.COMMAND_BLOCK) {
                amount = 1
                meta {
                    name = Component.text("${col("gray")}Countdown ${col("white")}[${
                        if (timerCountdown) {
                            "${col("green")}aktiv"
                        } else {
                            "${col("red")}deaktiv"
                        }
                    }${col("white")}]")
                }
            }
        }
        fun timer(): ItemStack{
            return itemStack(Material.CLOCK) {
                amount = 1
                meta {
                    name = Component.text("${col("gray")}Timer${col("white")} [${
                                if (timerTimer) {
                                    "${col("green")}aktiv"
                                } else {
                                    "${col("red")}deaktiv"
                                }
                            }${col("white")}]")
                }
            }
        }
    }
    /*object generateWorld{
        fun randomSeed(): ItemStack{
            return itemStack(Material.WHEAT_SEEDS){

            }
        }
        fun environment(): ItemStack{
            when{}
            return itemStack(Material.NETHERRACK){

            }
            return itemStack(Material.NETHERRACK){

            }
        }
    }*/
}