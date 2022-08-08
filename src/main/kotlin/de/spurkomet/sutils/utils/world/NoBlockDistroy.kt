package de.spurkomet.sutils.utils.world

import de.spurkomet.sutils.settings.global.settings.betterMinecraft.noCreeperBlockDamage
import net.axay.kspigot.event.listen
import net.axay.kspigot.sound.sound
import org.bukkit.Sound
import org.bukkit.event.entity.EntityExplodeEvent

class NoBlockDistroy{
    val listener = listen<EntityExplodeEvent> (register = noCreeperBlockDamage){
        it.isCancelled = true
        it.location.sound(Sound.ENTITY_GENERIC_EXPLODE)
    }
}