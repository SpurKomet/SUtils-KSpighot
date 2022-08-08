package de.spurkomet.sutils

import de.spurkomet.sutils.listener.mainListener
import net.axay.kspigot.chat.col
import net.axay.kspigot.main.KSpigot
import de.spurkomet.sutils.settings.global.Config
import de.spurkomet.sutils.settings.global.settings
import de.spurkomet.sutils.utils.Commands
import de.spurkomet.sutils.utils.soupHealing
import de.spurkomet.sutils.utils.world.leaveWaterLog

class InternalMainClass : KSpigot() {

    companion object {
        lateinit var INSTANCE: InternalMainClass; private set
    }


    override fun load() {
        INSTANCE = this
        var config = Config()
        settings.load()
    }
    override fun startup() {
        Commands()
        mainListener()
        soupHealing()
        leaveWaterLog()
    }

    override fun shutdown() {
        settings.save()
    }
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
- shift klick = 10er schritt
- kein blockdamige(bei explosion) bei pause
- autopause bei alle disconackt
- kein Hunger bei pause
 */