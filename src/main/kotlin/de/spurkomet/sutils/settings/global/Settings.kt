package de.spurkomet.sutils.settings.global

import org.bukkit.World
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

object settings {
    val dir = File("./plugins/SUtils/")
    val file = File(dir, "config.yml")
    var configuration = YamlConfiguration.loadConfiguration(file)

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
        //var positions = ArrayList<String>()
    }
    object backpack{
        var backpack = false
        var slots = 27 //vielfacher von 9
        var global = true
    }
    object troll{
        var oneHit = false
    }
    object betterMinecraft{
        var mlgOnLeavs = true
        var noCreeperBlockDamage = true
    }
    object generateWorld{
        var seed: Long = 0
        var environment = World.Environment.NORMAL
    }

    fun save(){
        damageIndicator.setConf("settings.damageIndicator")
        gravestone.setConf("settings.gravestone")
        // --- timer ---
        timer.countdown.setConf("settings.timer.countdown")
        timer.timer.setConf("settings.timer.timer")
        timer.isRun.setConf("settings.timer.isRun")
        timer.time.time.setConf("settings.timer.time.time")
        timer.time.sec.setConf("settings.timer.time.sec")
        timer.time.min.setConf("settings.timer.time.min")
        timer.time.h.setConf("settings.timer.time.h")
        // --- soup ---
        soup.soup.setConf("settings.soup.soup")
        soup.heal.setConf("settings.soup.heal")
        soup.food.setConf("settings.soup.food")
        soup.sateration.setConf("settings.soup.sateration")
        // --- pos ---
        position.position.setConf("settings.position.position")
        position.move.setConf("settings.position.move")
        // --- backpack ---
        backpack.backpack.setConf("settings.backpack.backpack")
        backpack.slots.setConf("settings.backpack.slots")
        backpack.global.setConf("settings.backpack.global")
    }
    fun load(){
        damageIndicator = getConf("settings.damageIndicator", damageIndicator)
        gravestone = getConf("settings.gravestone", gravestone)
        // --- timer ---
        timer.countdown = getConf("settings.timer.countdown", timer.countdown)
        timer.timer = getConf("settings.timer.timer", timer.timer)
        timer.isRun = getConf("settings.timer.isRun", timer.isRun)
        timer.time.time = getConf("settings.timer.time.time", timer.time.time)
        timer.time.sec = getConf("settings.timer.time.sec", timer.time.sec)
        timer.time.min = getConf("settings.timer.time.min", timer.time.min)
        timer.time.h = getConf("settings.timer.time.h", timer.time.h)
        // --- soup ---
        soup.soup = getConf("settings.soup.soup", soup.soup)
        soup.heal = getConf("settings.soup.heal", soup.heal)
        soup.food = getConf("settings.soup.food", soup.food)
        soup.sateration = getConf("settings.soup.sateration", soup.sateration)
        // --- pos ---
        position.position = getConf("settings.position.position", position.position)
        position.move = getConf("settings.position.move", position.move)
        // --- backpack ---
        backpack.backpack = getConf("settings.backpack.backpack", backpack.backpack)
        backpack.slots = getConf("settings.backpack.slots", backpack.slots)
        backpack.global = getConf("settings.backpack.global", backpack.global)
    }
}