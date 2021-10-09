package de.spurkomet.sutils.settings

import net.axay.kspigot.chat.col
import net.axay.kspigot.commands.command
import net.axay.kspigot.extensions.broadcast
import net.axay.kspigot.gui.GUIType
import net.axay.kspigot.gui.Slots
import net.axay.kspigot.gui.kSpigotGUI
import net.axay.kspigot.items.flag
import net.axay.kspigot.items.itemStack
import net.axay.kspigot.items.meta
import net.axay.kspigot.items.name
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag

class SettingsGUI {
    val gui = kSpigotGUI(GUIType.ONE_BY_NINE){
        title = "Settings"
        defaultPage = 0

        page(0){
            this.button(Slots.RowOneSlotOne,
                itemStack(Material.IRON_SWORD){
                    amount = 1
                    meta {
                        name = "${col("gray")}Damage Indicator " +
                                "${col("white")}[${if(damageIndicator){"${col("green")}aktiv"}
                                else{"${col("red")}deaktiv"}}${col("white")}]"
                        flag(ItemFlag.HIDE_ATTRIBUTES)
                    }
                }){
                if (damageIndicator){
                    damageIndicator = false
                    it.player.sendMessage("${de.spurkomet.sutils.getPrefix()}${col("gray")}Damage Indicator " +
                            "${col("white")}wurde " +
                            "${col("red")}deaktiviert${col("white")}.")
                }else{
                    damageIndicator = true
                    it.player.sendMessage("${de.spurkomet.sutils.getPrefix()}${col("gray")}Damage Indicator " +
                            "${col("white")}wurde " +
                            "${col("green")}aktiviert${col("white")}.")
                }
            }
            //this.nextPage(Slots.CornerBottomLeft, itemStack(Material.MAGENTA_BED){meta{ name="page" }})
        }
        page(1){
            this.button(Slots.RowOneSlotOne,
                itemStack(Material.GLASS){
                    amount = 1
                    meta {
                        name = "test"
                    }
                }){
                broadcast("test")
            }
            this.previousPage(Slots.CornerBottomLeft, itemStack(Material.MAGENTA_BED){meta{ name="page" }})
        }
    }
}