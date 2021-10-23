package net.spurkomet.sutils

import net.spurkomet.sutils.listener.mainListener
import net.spurkomet.sutils.utils.settingsComand
import net.axay.kspigot.chat.col
import net.axay.kspigot.commands.command
import net.axay.kspigot.commands.register
import net.axay.kspigot.main.KSpigot
import net.spurkomet.sutils.utils.soupHealing

class InternalMainClass : KSpigot() {

    companion object {
        lateinit var INSTANCE: InternalMainClass; private set
    }


    override fun load() {
        INSTANCE = this
    }
    override fun startup() {
        mainListener()
        settingsComand.register()
        soupHealing()
    }

    override fun shutdown() { }
}
fun prefix(): String{
    return "${col("dark_gray")}[${col("dark_aqua")}SUtils${col("dark_gray")}] ${col("white")}"
}
/*TODO
InvSee(nur anschauen)
Settings
    - datei
Backpack
 */