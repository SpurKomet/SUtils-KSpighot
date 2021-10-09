package de.spurkomet.sutils.utils


import de.spurkomet.sutils.getPrefix
import de.spurkomet.sutils.settings.SettingsGUI
import de.spurkomet.sutils.settings.damageIndicator
import net.axay.kspigot.chat.col
import net.axay.kspigot.commands.command
import net.axay.kspigot.commands.literal
import net.axay.kspigot.commands.runs
import net.axay.kspigot.gui.*


val settingsComand = command("settings"){
    runs{
        this.player.openGUI(SettingsGUI().gui)
    }
    literal("damage"){
        runs {
            player.sendMessage("${getPrefix()}${col("gray")}Damage Indicator " +
                    "${col("white")}ist aktuell" +
                    "${if(damageIndicator){ "${col("green")} aktiv" } else{ "${col("red")} deaktiv" }}" +
                    "${col("white")}.")
        }
            literal("true"){
                runs {
                    if (damageIndicator){
                        player.sendMessage("${getPrefix()}${col("gray")}Damage Indicator " +
                                "${col("white")}ist bereits " +
                                "${col("green")}aktiv${col("white")}${col("white")}.")
                    }else{
                        damageIndicator = true
                        player.sendMessage("${getPrefix()}${col("gray")}Damage Indicator " +
                                "${col("white")}wurde " +
                                "${col("green")}aktiviert${col("white")}.")
                    }
                }
            }
            literal("false"){
                runs {
                    if (!damageIndicator){
                        player.sendMessage("${getPrefix()}${col("gray")}Damage Indicator " +
                                "${col("white")}ist bereits " +
                                "${col("red")}deaktiv${col("white")}.")
                    }else{
                        damageIndicator = false
                        player.sendMessage("${getPrefix()}${col("gray")}Damage Indicator " +
                                "${col("white")}wurde " +
                                "${col("red")}deaktiviert${col("white")}.")
                    }
                }
            }

    }
}




