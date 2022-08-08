package de.spurkomet.sutils.settings.global

import net.axay.kspigot.chat.col
import net.axay.kspigot.gui.GUIType
import net.axay.kspigot.gui.Slots
import net.axay.kspigot.gui.kSpigotGUI
import net.axay.kspigot.items.*
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import de.spurkomet.sutils.prefix
import de.spurkomet.sutils.prefixs
import de.spurkomet.sutils.settings.global.settings.betterMinecraft.noCreeperBlockDamage

import de.spurkomet.sutils.settings.global.settings.damageIndicator
import de.spurkomet.sutils.utils.calcToSec
import de.spurkomet.sutils.utils.runTimer
import de.spurkomet.sutils.utils.world.NoBlockDistroy
import net.axay.kspigot.event.register
import net.axay.kspigot.event.unregister
import net.kyori.adventure.text.Component
import de.spurkomet.sutils.settings.global.settings.timer.timer as timerTimer
import de.spurkomet.sutils.settings.global.settings.timer.time.sec as timerSec
import de.spurkomet.sutils.settings.global.settings.timer.time.min as timerMin
import de.spurkomet.sutils.settings.global.settings.timer.time.h as timerH
import de.spurkomet.sutils.settings.global.settings.timer.countdown as timerCountdown
import de.spurkomet.sutils.settings.global.settings.soup.soup as soupSoup
import de.spurkomet.sutils.settings.global.settings.soup.sateration as soupSaturation
import de.spurkomet.sutils.settings.global.settings.soup.food as soupFood
import de.spurkomet.sutils.settings.global.settings.soup.heal as soupHeal

class SettingsGUI {
    val gui = kSpigotGUI(GUIType.ONE_BY_NINE) {
        title = Component.text("Settings")
        defaultPage = 0

        page(0) {
            this.button(Slots.RowOneSlotOne, SettingsDisplayItem.generel.damageIndicator()) {
                if (damageIndicator) {
                    damageIndicator = false
                    it.player.sendMessage(
                        "${prefix()}${col("gray")}Damage Indicator " +
                                "${col("white")}wurde " +
                                "${col("red")}deaktiviert${col("white")}."
                    )
                } else {
                    damageIndicator = true
                    it.player.sendMessage(
                        "${prefix()}${col("gray")}Damage Indicator " +
                                "${col("white")}wurde " +
                                "${col("green")}aktiviert${col("white")}."
                    )
                }
                it.bukkitEvent.currentItem = SettingsDisplayItem.generel.damageIndicator()
            }
            this.pageChanger(Slots.RowOneSlotTwo, SettingsDisplayItem.generel.soup(), 1, null) {
                //it.player.sendMessage("settings.soup")
            }
            this.pageChanger(Slots.RowOneSlotThree, SettingsDisplayItem.generel.timer(),2, null){
                settings.timer.isRun = false
            }
            this.pageChanger(Slots.RowOneSlotFour, SettingsDisplayItem.generel.backpack(),3, null){
            }
            this.button(Slots.RowOneSlotFour, SettingsDisplayItem.generel.noCreeper()) {
                if (!noCreeperBlockDamage) {
                    noCreeperBlockDamage = true
                    NoBlockDistroy().listener.register()
                    it.player.sendMessage(
                        "${prefix()}${col("gray")}Creeper Block Damage " +
                                "${col("white")}wurde " +
                                "${col("red")}deaktiviert${col("white")}."
                    )
                } else {
                    noCreeperBlockDamage = false
                    NoBlockDistroy().listener.unregister()
                    it.player.sendMessage(
                        "${prefix()}${col("gray")}Creeper Block Damage " +
                                "${col("white")}wurde " +
                                "${col("green")}aktiviert${col("white")}."
                    )
                }
                it.bukkitEvent.currentItem = SettingsDisplayItem.generel.noCreeper()
            }
            //this.nextPage(Slots.CornerBottomLeft, itemStack(Material.MAGENTA_BED){meta{ name="page" }})
        }

        //------------------------ Soup --------------------------

        page(1) {
            this.button(Slots.RowOneSlotOne, SettingsDisplayItem.soup.soup()) {
                if (soupSoup) {
                    soupSoup = false
                    it.player.sendMessage(
                        "${prefix()}${col("gray")}Soup Healing " +
                                "${col("white")}wurde " +
                                "${col("red")}deaktiviert${col("white")}."
                    )
                } else {
                    soupSoup = true
                    it.player.sendMessage(
                        "${prefix()}${col("gray")}Soup Healing " +
                                "${col("white")}wurde " +
                                "${col("green")}aktiviert${col("white")}."
                    )
                }
                it.bukkitEvent.currentItem = SettingsDisplayItem.soup.soup()
            }
            //--------------- soup.heal ----------------------
            this.button(Slots.RowOneSlotThree, SettingsDisplayItem.soup.heal()) {
                if (it.bukkitEvent.click.isLeftClick) {
                    if(soupHeal < 20) {
                        soupHeal++
                        it.player.sendMessage("${prefixs.soup()}${col("gray")}Heal ${col("white")}wurde auf ${col("dark_red")}$soupHeal ${col("white")}gesetzt.")
                    }
                    else{
                        it.player.sendMessage("${prefixs.soup()}${col("gray")}Heal ${col("white")}ist bereits auf: ${col("dark_red")}$soupHeal")
                    }
                }
                if (it.bukkitEvent.click.isRightClick) {
                    if(soupHeal > 1) {
                        soupHeal--
                        it.player.sendMessage("${prefixs.soup()}${col("gray")}Heal ${col("white")}wurde auf ${col("dark_red")}$soupHeal ${col("white")}gesetzt.")
                    }
                    else{
                        it.player.sendMessage("${prefixs.soup()}${col("gray")}Heal ${col("white")}ist bereits auf: ${col("dark_red")}$soupHeal")
                    }
                }
                it.bukkitEvent.currentItem = SettingsDisplayItem.soup.heal()
            }

            //--------------- soup.food ----------------------
            this.button(Slots.RowOneSlotFive, SettingsDisplayItem.soup.food()) {
                if (it.bukkitEvent.click.isLeftClick) {
                    if(soupFood < 10) {
                        soupFood++
                        it.player.sendMessage("${prefixs.soup()}${col("gray")}Food ${col("white")}wurde auf ${col("dark_red")}$soupFood ${col("white")}gesetzt.")
                    }
                    else{
                        it.player.sendMessage("${prefixs.soup()}${col("gray")}Food ${col("white")}ist bereits auf: ${col("dark_red")}$soupFood")
                    }
                }
                if (it.bukkitEvent.click.isRightClick) {
                    if(soupFood > 0) {
                        soupFood--
                        it.player.sendMessage("${prefixs.soup()}${col("gray")}Food ${col("white")}wurde auf ${col("dark_red")}$soupFood ${col("white")}gesetzt.")
                    }
                    else{
                        it.player.sendMessage("${prefixs.soup()}${col("gray")}Food ${col("white")}ist bereits auf: ${col("dark_red")}$soupFood")
                    }
                }
                it.bukkitEvent.currentItem = SettingsDisplayItem.soup.food()
            }

            //--------------- soup.saturation ----------------------
            this.button(Slots.RowOneSlotSeven, SettingsDisplayItem.soup.saturation()) {
                if (it.bukkitEvent.click.isLeftClick) {
                    if(soupSaturation < 10) {
                        soupSaturation++
                        it.player.sendMessage("${prefixs.soup()}${col("gray")}Sateration ${col("white")}wurde auf ${col("dark_red")}$soupSaturation ${col("white")}gesetzt.")
                    }
                    else{
                        it.player.sendMessage("${prefixs.soup()}${col("gray")}Sateration ${col("white")}ist bereits auf: ${col("dark_red")}$soupSaturation")
                    }
                }
                if (it.bukkitEvent.click.isRightClick) {
                    if(soupSaturation > 0) {
                        soupSaturation--
                        it.player.sendMessage("${prefixs.soup()}${col("gray")}Sateration ${col("white")}wurde auf ${col("dark_red")}$soupSaturation ${col("white")}gesetzt.")
                    }
                    else{
                        it.player.sendMessage("${prefixs.soup()}${col("gray")}Sateration ${col("white")}ist bereits auf: ${col("dark_red")}$soupSaturation")
                    }
                }
                it.bukkitEvent.currentItem = SettingsDisplayItem.soup.saturation()
            }
            this.pageChanger(Slots.RowOneSlotNine, SettingsDisplayItem.back, 0, null){
                //it.player.sendMessage("settings")
            }
        }

    //--------------- Timer -------------------

    page(2) {
        this.button(Slots.RowOneSlotOne, SettingsDisplayItem.timer.timer()) {
            if (timerTimer) {
                timerTimer = false
                it.player.sendMessage(
                    "${prefix()}Der ${col("gray")}Timer " +
                            "${col("white")}wurde " +
                            "${col("red")}deaktiviert${col("white")}."
                )
            } else {
                timerTimer = true
                runTimer()
                it.player.sendMessage(
                    "${prefix()}Der ${col("gray")}Timer " +
                            "${col("white")}wurde " +
                            "${col("green")}aktiviert${col("white")}."
                )
            }
            it.bukkitEvent.currentItem = SettingsDisplayItem.timer.timer()
        }

        //--------------- timer.sec ----------------------
        this.button(Slots.RowOneSlotThree, SettingsDisplayItem.timer.sec()) {
            if (it.bukkitEvent.click.isLeftClick) {
                if(timerSec < 59) {
                    timerSec++
                    it.player.sendMessage("${prefixs.timer()}${col("gray")}Sekunden ${col("white")}wurde auf ${col("dark_red")}$timerSec ${col("white")}gesetzt.")
                }
                else{
                    it.player.sendMessage("${prefixs.timer()}${col("gray")}Sekunden ${col("white")}ist bereits auf: ${col("dark_red")}$timerSec")
                }
            }
            if (it.bukkitEvent.click.isRightClick) {
                if(timerSec > 0) {
                    timerSec--
                    it.player.sendMessage("${prefixs.timer()}${col("gray")}Sekunden ${col("white")}wurde auf ${col("dark_red")}$timerSec ${col("white")}gesetzt.")
                }
                else{
                    it.player.sendMessage("${prefixs.timer()}${col("gray")}Sekunden ${col("white")}ist bereits auf: ${col("dark_red")}$timerSec")
                }
            }
            calcToSec()
            it.bukkitEvent.currentItem = SettingsDisplayItem.timer.sec()
        }

        //--------------- timer.min ----------------------
        this.button(Slots.RowOneSlotFour, SettingsDisplayItem.timer.min()) {
            if (it.bukkitEvent.click.isLeftClick) {
                if(settings.timer.time.min < 59) {
                    settings.timer.time.min++
                    it.player.sendMessage("${prefixs.timer()}${col("gray")}Minuten ${col("white")}wurde auf ${col("dark_red")}$timerMin ${col("white")}gesetzt.")
                }
                else{
                    it.player.sendMessage("${prefixs.timer()}${col("gray")}Minuten ${col("white")}ist bereits auf: ${col("dark_red")}$timerMin")
                }
            }
            if (it.bukkitEvent.click.isRightClick) {
                if(settings.timer.time.min > 0) {
                    settings.timer.time.min--
                    it.player.sendMessage("${prefixs.timer()}${col("gray")}Minuten ${col("white")}wurde auf ${col("dark_red")}$timerMin ${col("white")}gesetzt.")
                }
                else{
                    it.player.sendMessage("${prefixs.timer()}${col("gray")}Minuten ${col("white")}ist bereits auf: ${col("dark_red")}$timerMin")
                }
            }
            calcToSec()
            it.bukkitEvent.currentItem = SettingsDisplayItem.timer.min()
        }

        //--------------- timer.h ----------------------
        this.button(Slots.RowOneSlotFive, SettingsDisplayItem.timer.h()) {
            if (it.bukkitEvent.click.isLeftClick) {
                if(timerH < 24) {
                    timerH++
                    it.player.sendMessage("${prefixs.timer()}${col("gray")}Stunden ${col("white")}wurde auf ${col("dark_red")}$timerH ${col("white")}gesetzt.")
                }
                else{
                    it.player.sendMessage("${prefixs.timer()}${col("gray")}Stunden ${col("white")}ist bereits auf: ${col("dark_red")}$timerH")
                }
            }
            if (it.bukkitEvent.click.isRightClick) {
                if(timerH > 0) {
                    timerH--
                    it.player.sendMessage("${prefixs.timer()}${col("gray")}Stunden ${col("white")}wurde auf ${col("dark_red")}$timerH ${col("white")}gesetzt.")
                }
                else{
                    it.player.sendMessage("${prefixs.timer()}${col("gray")}Stunden ${col("white")}ist bereits auf: ${col("dark_red")}$timerH")
                }
            }
            calcToSec()
            it.bukkitEvent.currentItem = SettingsDisplayItem.timer.h()
        }

        //--------------- timer.countdown ----------------------
        this.button(Slots.RowOneSlotSeven, SettingsDisplayItem.timer.countdown()) {
            if(timerCountdown) {
                timerCountdown = false
                it.player.sendMessage("${prefixs.timer()}${col("gray")}Countdown ${col("white")}wurde auf ${col("dark_red")}$timerCountdown ${col("white")}gesetzt.")
            }
            else{
                if (settings.timer.time.time != 0){
                    timerCountdown = true
                    it.player.sendMessage("${prefixs.timer()}${col("gray")}Countdown ${col("white")}wurde auf ${col("dark_green")}$timerCountdown ${col("white")}gesetzt.")
                }else{
                    it.player.sendMessage("${prefixs.timer()}${col("gray")}Countdown ${col("white")}wurde beibehalten [${col("dark_green")}$timerCountdown${col("white")}]. (null)")
                }
            }
            it.bukkitEvent.currentItem = SettingsDisplayItem.timer.countdown()
        }
        this.pageChanger(Slots.RowOneSlotNine,
            itemStack(Material.RED_STAINED_GLASS_PANE) {
                amount = 1
                meta {
                    name = Component.text("${col("dark_red")}<- ${col("gray")}Settings")
                    flag(ItemFlag.HIDE_ATTRIBUTES)
                }
            },
            0, null){
            //it.player.sendMessage("settings")
        }
    }

        // --------------- Backpack -------------------
        page(3){

            this.pageChanger(Slots.RowOneSlotNine,
                itemStack(Material.RED_STAINED_GLASS_PANE) {
                    amount = 1
                    meta {
                        name = Component.text("${col("dark_red")}<- ${col("gray")}Settings")
                        flag(ItemFlag.HIDE_ATTRIBUTES)
                    }
                },
                0, null){
                //it.player.sendMessage("settings")
            }
        }
    }
}

