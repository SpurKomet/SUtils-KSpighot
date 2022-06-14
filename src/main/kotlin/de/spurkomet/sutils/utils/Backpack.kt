package de.spurkomet.sutils.utils

import de.spurkomet.sutils.prefix
import de.spurkomet.sutils.settings.settings
import org.bukkit.entity.Player

fun Player.backpack(){
    if (settings.backpack.backpack){

    }else{
        this.sendMessage(prefix() + "Der Rucksack ist aktuell deaktiviert!")
    }
}