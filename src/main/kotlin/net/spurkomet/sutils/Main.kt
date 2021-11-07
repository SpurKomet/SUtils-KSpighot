package net.spurkomet.sutils

import net.spurkomet.sutils.listener.mainListener
import net.axay.kspigot.chat.col
import net.axay.kspigot.commands.register
import net.axay.kspigot.main.KSpigot
import net.spurkomet.sutils.utils.Commands
import net.spurkomet.sutils.utils.soupHealing

class InternalMainClass : KSpigot() {

    companion object {
        lateinit var INSTANCE: InternalMainClass; private set
    }


    override fun load() {
        INSTANCE = this
    }
    override fun startup() {
        Commands()
        mainListener()
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
Timer:
- kein blockdamige(bei explosion) bei pause
- autopause bei alle disconackt
- kein Hunger bei pause
 */