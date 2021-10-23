package net.spurkomet.sutils.settings

import net.axay.kspigot.chat.col
import net.axay.kspigot.extensions.broadcast
import net.axay.kspigot.items.*
import org.bukkit.Material
import net.spurkomet.sutils.prefixs
import net.spurkomet.sutils.settings.settings.damageIndicator
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import net.spurkomet.sutils.settings.settings.timer.timer as timerTimer
import net.spurkomet.sutils.settings.settings.timer.time.time as timerTime
import net.spurkomet.sutils.settings.settings.timer.time.sec as timerSec
import net.spurkomet.sutils.settings.settings.timer.time.min as timerMin
import net.spurkomet.sutils.settings.settings.timer.time.h as timerH
import net.spurkomet.sutils.settings.settings.timer.countdown as timerCountdown
import net.spurkomet.sutils.settings.settings.soup.soup as soupSoup
import net.spurkomet.sutils.settings.settings.soup.sateration as soupSaturation
import net.spurkomet.sutils.settings.settings.soup.food as soupFood
import net.spurkomet.sutils.settings.settings.soup.heal as soupHeal

object SettingsDisplayItem {
    object generel{
        fun damageIndicator(): ItemStack{
            return  itemStack(Material.IRON_SWORD) {
                amount = 1
                meta {
                    name = "${col("gray")}Damage Indicator " +
                            "${col("white")}[${
                                if (damageIndicator) {
                                    "${col("green")}aktiv"
                                } else {
                                    "${col("red")}deaktiv"
                                }
                            }${col("white")}]"
                    flag(ItemFlag.HIDE_ATTRIBUTES)
                }
            }
        }
        fun soup(): ItemStack{
            return itemStack(Material.MUSHROOM_STEW) {
                amount = 1
                meta {
                    name = "${col("gray")}Soup Settings ${col("dark_green")}->"
                    flag(ItemFlag.HIDE_ATTRIBUTES)
                }
            }
        }
        fun timer(): ItemStack{
            return itemStack(Material.CLOCK) {
                amount = 1
                meta {
                    name = "${col("gray")}Timer Settings ${col("dark_green")}->"
                    flag(ItemFlag.HIDE_ATTRIBUTES)
                }
            }
        }
    }
    object soup{
        fun soup(): ItemStack{
            return itemStack(Material.MUSHROOM_STEW) {
                amount = 1
                meta {
                    name = "${col("gray")}Soup Healing " +
                            "${col("white")}[${
                                if (soupSoup) {
                                    "${col("green")}aktiv"
                                } else {
                                    "${col("red")}deaktiv"
                                }
                            }${col("white")}]"
                }
            }
        }
        fun heal(): ItemStack{
            return itemStack(Material.ENCHANTED_GOLDEN_APPLE) {
                amount = soupHeal
                meta {
                    name = "${col("white")}Heal"
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
                    name = "${col("white")}Foot"
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
                    name = "${col("white")}Sateration"
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
                    name = "${col("white")}$timerH ${col("gray")}Stunden"
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
                    name = "${col("white")}$timerMin ${col("gray")}Minuten"
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
                    name = "${col("white")}$timerSec ${col("gray")}Sekunden"
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
                    name = "${col("gray")}Countdown ${col("white")}[${
                        if (timerCountdown) {
                            "${col("green")}aktiv"
                        } else {
                            "${col("red")}deaktiv"
                        }
                    }${col("white")}]"
                }
            }
        }
        fun timer(): ItemStack{
            return itemStack(Material.CLOCK) {
                amount = 1
                meta {
                    name = "${col("gray")}Timer${col("white")} [${
                                if (timerTimer) {
                                    "${col("green")}aktiv"
                                } else {
                                    "${col("red")}deaktiv"
                                }
                            }${col("white")}]"
                }
            }
        }
    }
}