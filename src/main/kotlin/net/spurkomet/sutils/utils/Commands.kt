package net.spurkomet.sutils.utils

import net.spurkomet.sutils.settings.SettingsGUI
import net.axay.kspigot.commands.command
import net.axay.kspigot.commands.literal
import net.axay.kspigot.commands.runs
import net.axay.kspigot.gui.*
import net.spurkomet.sutils.settings.settings
import net.spurkomet.sutils.usages


val settingsComand = command("settings"){
    runs{
        this.player.openGUI(SettingsGUI().gui)
    }
}
val timerComand = command("timer"){
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




