package de.spurkomet.sutils.utils.admintools

import de.spurkomet.sutils.prefix
import net.axay.kspigot.chat.col
import org.bukkit.Material
import org.bukkit.entity.Player
import kotlin.random.Random

fun Player.placeBeacon(){
    val Location = this.location
    val WorldSetType = this.world

    val random = arrayOf(Material.WHITE_STAINED_GLASS_PANE, Material.ORANGE_STAINED_GLASS_PANE, Material.MAGENTA_STAINED_GLASS_PANE, Material.LIGHT_BLUE_STAINED_GLASS_PANE, Material.YELLOW_STAINED_GLASS_PANE, Material.LIME_STAINED_GLASS_PANE, Material.PINK_STAINED_GLASS_PANE, Material.GRAY_STAINED_GLASS_PANE, Material.LIGHT_GRAY_STAINED_GLASS_PANE, Material.CYAN_STAINED_GLASS_PANE, Material.PURPLE_STAINED_GLASS_PANE, Material.BLUE_STAINED_GLASS_PANE, Material.BROWN_STAINED_GLASS_PANE, Material.GREEN_STAINED_GLASS_PANE, Material.RED_STAINED_GLASS_PANE, Material.BLACK_STAINED_GLASS_PANE)

    if(Location.blockY <= -64 || Location.blockY >= 320 ){
        this.sendMessage(prefix() + col("red") + "Bereich außerhalb der Welt")
    }else{
        for (z in Location.blockZ-1..Location.blockZ+1){
            for (x in Location.blockX-1..Location.blockX+1){
                WorldSetType.setType(x, Location.blockY-1, z, Material.IRON_BLOCK)
            }
        }
        if(Location.blockY != 320 ) {
            WorldSetType.setType(Location.blockX, Location.blockY, Location.blockZ, Material.BEACON)
            for (y in 320 downTo Location.blockY + 1) {
                WorldSetType.setType(
                    Location.blockX,
                    y,
                    Location.blockZ,
                    random[Random.nextInt(random.lastIndex)]
                )
            }
        }
    }
}