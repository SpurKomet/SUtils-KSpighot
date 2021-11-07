package net.spurkomet.sutils.utils

import net.axay.kspigot.chat.col
import net.spurkomet.sutils.settings.SettingsGUI
import net.axay.kspigot.commands.command
import net.axay.kspigot.commands.literal
import net.axay.kspigot.commands.runs
import net.axay.kspigot.gui.*
import net.spurkomet.sutils.prefix
import net.spurkomet.sutils.settings.settings
import net.spurkomet.sutils.usages

class Commands{
    val settingsCommand = command("settings"){
        runs{
            if (this.player.isOp){
                this.player.openGUI(SettingsGUI().gui)
            }else{
                this.player.sendMessage("${prefix()}${col("red")}Du brauchst ${col("aqua")}op${col("red")}, um diesen command auszuführen")
            }
        }
    }
    val timerCommand = command("timer"){
        runs{
            this.player.sendMessage(usages.timer())
        }
        literal("resume"){
            runs{
                settings.timer.isRun = true
            }
        }
        literal("pause"){
            runs{
                settings.timer.isRun = false
            }
        }
        literal("reset"){
            runs{
                settings.timer.isRun = false
                settings.timer.time.time = 0
                calcToRead()
            }
        }
    }
    val positionCommand = command("position") {
        literal("set") {

        }
        literal("get") {

        }
        literal("move") {


        }
    }
}





