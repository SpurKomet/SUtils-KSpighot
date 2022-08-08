package de.spurkomet.sutils.utils

import com.github.twitch4j.helix.TwitchHelixBuilder
import com.mojang.brigadier.arguments.StringArgumentType
import de.spurkomet.sutils.prefix
import de.spurkomet.sutils.settings.global.SettingsGUI
import de.spurkomet.sutils.settings.global.settings
import de.spurkomet.sutils.usages
import de.spurkomet.sutils.utils.admintools.placeBeacon
import de.spurkomet.sutils.utils.world.reset
import net.axay.kspigot.chat.col
import net.axay.kspigot.commands.*
import net.axay.kspigot.extensions.broadcast
import net.axay.kspigot.gui.*
import net.axay.kspigot.items.flag
import net.axay.kspigot.items.itemStack
import net.axay.kspigot.items.meta
import net.axay.kspigot.items.name
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag

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
                if (!settings.timer.timer){
                    settings.timer.timer = true
                    runTimer()
                }
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
    val adminTools = command("admintools"){
        //requiresPermission("Admin")
        literal("get"){
            literal("astronautenhelm"){
                runs {
                    this.player.inventory.helmet = itemStack(Material.GLASS){meta{ name = Component.text("${col("blue")}Astronauten Helm"); flag(ItemFlag.HIDE_ATTRIBUTES)}}
                }
            }
        }
        literal("place"){
           literal("beacon"){
               runs {
                   this.player.placeBeacon()
               }
            }
        }

    }
    val resetCommand = command("resetandrestart"){
        runs{
            this.player.sendMessage(usages.reset())
        }
        literal("true"){
            reset(true)
        }
        literal("false"){
            reset(false)
        }
    }
    val backpackCommand = command("backpack"){
        runs {

        }
    }
    val genWorldCommand = command("generateworld"){
        literal("copy"){

        }
        literal("byparameters"){
            literal("randomseed")
            argument("seed", StringArgumentType.string()){
                runs {
                    val arg = getArgument<String>("seed")
                    if (arg == "random"){

                    }
                }
            }
            /*private final NamespacedKey key; // Paper
            private final String name;
            private long seed;
            private World.Environment environment = World.Environment.NORMAL;
            private ChunkGenerator generator = null;
            private BiomeProvider biomeProvider = null;
            private WorldType type = WorldType.NORMAL;
            private boolean generateStructures = true;
            private String generatorSettings = "";
            private boolean hardcore = false;*/
        }
    }
    val tttCommand = command("fs"){
        runs {
            broadcast(this.player.flySpeed.toString())
            broadcast(this.player.walkSpeed.toString())
        }
    }
    /*val musicCommand = command("musik"){
        literal("play"){
            argument("Lied", StringArgumentType.string()){
                simpleSuggests { listOf() }
            }
        }
        literal("bot"){
            runs {

            }
        }
    }*/

    val twitch = command("twitch"){
        runs {
            val client = TwitchHelixBuilder.builder()
                .withClientId("q6jk9x099tfnx50vzmh1xod8413otl")
                .withClientSecret("2nuwg8x40yrzdcvlntq3ljs4ge35ql")
                .build()
        }
    }
}





