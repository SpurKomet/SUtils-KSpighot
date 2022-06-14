package de.spurkomet.sutils.settings

import de.spurkomet.sutils.InternalMainClass
import de.spurkomet.sutils.settings.settings.configuration
import de.spurkomet.sutils.settings.settings.dir
import de.spurkomet.sutils.settings.settings.file
import java.io.IOException

fun Config(){
    if (!dir.exists()) {
        dir.mkdirs()
    }

    if (!file.exists()){
        try {
            file.createNewFile()
        }catch (e: IOException){
            e.printStackTrace()
        }
    }

}
fun save(){
    try {
        configuration.save(file)
    }catch (e: IOException){
        e.printStackTrace()
    }
}


fun Boolean.setConf(path: String){
    InternalMainClass.INSTANCE.config.set(path, this)
}
fun Int.setConf(path: String){
    InternalMainClass.INSTANCE.config.set(path, this)
}

fun getConf(path: String, orginal: Boolean): Boolean{
    var ret: Boolean = orginal
    if (configuration.contains(path)){ret = configuration.getBoolean(path)}
    return ret
}
fun getConf(path: String, orginal: Int): Int{
    var ret: Int = orginal
    if (configuration.contains(path)){ret = configuration.getInt(path)}
    return ret
}