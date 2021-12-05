package net.spurkomet.sutils.settings

import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

object settings {
    val dir = File("./plugins/SUtils/")
    val file = File(dir, "config.yml")
    var config = YamlConfiguration.loadConfiguration(file)

    var damageIndicator = false
    var gravestone = false

    object timer{
        var countdown = false
        var timer = false
        var isRun = false
        object time{
            var time = 0
            var sec = 0
            var min = 0
            var h = 0
        }
    }

    object soup{
        var soup = false
        var heal = 4
        var food = 5
        var sateration = 3
    }
    object position{
        var position = false
        var move = false
        var positions = ArrayList<String>()
    }
    object backpack{
        var backpack = false
        var slots = 27 //vielfacher von 9
        var global = true
    }
    object troll{
        var oneHit = false
    }
    fun save(){
        //config.set("settungs.alowNether", alowNether)
    }
    fun load(){
        //if (config.contains("settungs.alowNether")){alowNether = config.getBoolean("settungs.alowNether")}
    }
}