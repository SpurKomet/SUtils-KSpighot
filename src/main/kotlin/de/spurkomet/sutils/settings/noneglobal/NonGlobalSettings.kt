package de.spurkomet.sutils.settings.noneglobal

import org.bukkit.entity.Player


object nonGlobalSettings{
    fun Player.addPlayer(){
        if (mlg[this] == null) mlg[this] = true
    }
    val mlg = HashMap<Player, Boolean>()
}
