package de.spurkomet.sutils.utils.world

import net.axay.kspigot.extensions.server
import org.bukkit.Bukkit
import org.bukkit.Server
import org.bukkit.World
import java.io.File
import java.io.IOException

fun reset(save: Boolean){
    if (save){

    }else{
        val delWorlds = arrayOf(File("./world"), File("./world_the_end"), File("./world_nether"))
        delWorlds.forEach {
            try {
                it.delete()
            }catch (e: IOException){e.printStackTrace()}
        }
        //Bukkit.shutdown()
    }
}