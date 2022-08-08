package de.spurkomet.sutils.utils.world

import de.spurkomet.sutils.settings.noneglobal.nonGlobalSettings
import de.spurkomet.sutils.utils.world.LeaveWaterLog.isLeave
import net.axay.kspigot.event.listen
import net.axay.kspigot.extensions.bukkit.getHandItem
import net.axay.kspigot.extensions.geometry.plus
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemStack

fun leaveWaterLog(){
    listen<PlayerInteractEvent> {
        var mlg = nonGlobalSettings.mlg[it.player]
        if (mlg == null || mlg){
            if (it.action.isLeftClick) return@listen
            val block = it.clickedBlock ?: return@listen
            val blockFace = it.blockFace
            val player = it.player
            if (player.getHandItem(EquipmentSlot.HAND) == ItemStack(Material.WATER_BUCKET)){
                if (block.type.isLeave()){
                    it.isCancelled = true
                    val pLoc = player.location
                    val bLoc = block.location
                    player.world.setBlockData(bLoc.plus(blockFace.direction), Material.WATER.createBlockData())
                    //player.world.setBlockData(Location(player.world, bLoc.x, bLoc.y+1, bLoc.z), Material.WATER.createBlockData())
                    if(player.gameMode != GameMode.CREATIVE){
                        player.inventory.itemInMainHand.type = Material.BUCKET
                    }
                }
            }
        }
    }
}
object LeaveWaterLog{
    fun Material.isLeave(): Boolean =
        when(this){
            Material.JUNGLE_LEAVES -> true
            Material.SPRUCE_LEAVES -> true
            Material.MANGROVE_LEAVES -> true
            Material.DARK_OAK_LEAVES -> true
            Material.OAK_LEAVES -> true
            Material.BIRCH_LEAVES -> true
            Material.AZALEA_LEAVES -> true
            Material.FLOWERING_AZALEA_LEAVES -> true
            Material.ACACIA_LEAVES -> true
            else -> false
        }

}
