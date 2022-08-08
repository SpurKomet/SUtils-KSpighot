package de.spurkomet.sutils.settings.noneglobal

import de.spurkomet.sutils.settings.global.settings
import de.spurkomet.sutils.utils.runTimer
import net.axay.kspigot.commands.argument
import net.axay.kspigot.commands.command
import net.axay.kspigot.commands.literal
import net.axay.kspigot.commands.runs

class NonGlobalSettingsCommand {
    val nonGlobalSettingsCommand = command("privateSettings"){
        literal("mlg"){
            literal("true"){
                runs{
                    nonGlobalSettings.mlg[this.player] = true
                }
            }
            literal("false"){
                runs{
                    nonGlobalSettings.mlg[this.player] = false
                }
            }
        }
    }
}