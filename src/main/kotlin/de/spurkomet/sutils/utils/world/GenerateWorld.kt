package de.spurkomet.sutils.utils.world

import org.bukkit.Bukkit
import org.bukkit.WorldCreator


fun String.copy(target: String){
    val worldCopy = Bukkit.getWorld(this)
    if (worldCopy != null){
        WorldCreator(target).copy(worldCopy).createWorld()
    }
}