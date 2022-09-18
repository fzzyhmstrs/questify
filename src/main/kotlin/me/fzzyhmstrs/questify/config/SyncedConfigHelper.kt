package me.fzzyhmstrs.questify.config

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import me.fzzyhmstrs.questify.Questify
import net.fabricmc.loader.api.FabricLoader
import net.minecraft.network.PacketByteBuf
import java.io.File
import java.io.FileWriter

object SyncedConfigHelper {

    val gson: Gson = GsonBuilder().setPrettyPrinting().create()

    /**
     * basic function for creating and passing the config settings for a particular configuration class to/from json.
     */
    inline fun <reified T> readOrCreate(file: String, child: String = "", base: String = Questify.MOD_ID, configClass: () -> T): T {
        val (dir,dirCreated) = makeDir(child, base)
        if (!dirCreated) {
            return configClass()
        }
        val f = File(dir, file)
        try {
            if (f.exists()) {
                return gson.fromJson(f.readLines().joinToString(""), T::class.java)
            } else if (!f.createNewFile()) {
                println("Failed to create default config file ($file), using default config.")
            } else {
                f.writeText(gson.toJson(configClass()))
            }
            return configClass()
        } catch (e: Exception) {
            println("Failed to read config file! Using default values: " + e.message)
            return configClass()
        }
    }

    @Suppress("UNUSED_PARAMETER")
    inline fun <reified T, reified P> readOrCreateUpdated(file: String, previous: String, child: String = "", base: String = Questify.MOD_ID, configClass: () -> T, previousClass: () -> P): T{
        val (dir,dirCreated) = makeDir(child, base)
        if (!dirCreated) {
            return configClass()
        }
        val p = File(dir, previous)
        try {
            if (p.exists()) {
                val previousConfig = gson.fromJson(p.readLines().joinToString(""), P::class.java)
                if (previousConfig is OldClass){
                    val newClass = previousConfig.generateNewClass()
                    if (newClass !is T){
                        throw RuntimeException("Old config class is not returning the proper new config class: ${P::class.simpleName} is returning ${newClass.javaClass.simpleName}; expected ${T::class.simpleName}")
                    } else {
                        val f = File(dir,file)
                        if (f.exists()){
                            p.delete() //attempts to delete the now useless old config version file
                            return gson.fromJson(f.readLines().joinToString(""), T::class.java)
                        } else if (!f.createNewFile()){
                            //don't delete old file if the new one can't be generated to take its place
                            println("Failed to create new config file ($file), using old config with new defaults.")
                        } else {
                            p.delete() //attempts to delete the now useless old config version file
                            f.writeText(gson.toJson(newClass))
                        }
                        return newClass
                    }
                } else {
                    throw RuntimeException("Old config not properly set up as an OldConfig: ${P::class.simpleName}")
                }
            } else {
                return readOrCreate(file,child, base, configClass)
            }
        } catch (e: Exception) {
            println("Failed to read config file! Using default values: " + e.message)
            return configClass()
        }
    }

    /**
     * method can be used to create a directory in the config parent directory. If the directory can't be created, the right member of the returning Pair will be false.
     */
    fun makeDir(child: String, base: String): Pair<File,Boolean>{
        val dir = if (child != ""){
            File(File(FabricLoader.getInstance().configDir.toFile(), base), child)
        } else {
            File(FabricLoader.getInstance().configDir.toFile(), base)
        }
        if (!dir.exists() && !dir.mkdirs()) {
            println("Could not create directory, using default configs.")
            return Pair(dir,false)
        }
        return Pair(dir,true)
    }

    /**
     * basic interface for creating a synced configurator as described above
     */
    interface SyncedConfig{
        fun readFromServer(buf: PacketByteBuf)
        fun writeToClient(buf: PacketByteBuf)
        fun initConfig()
    }

    /**
     * used to generate backward compatibility with an old version of a config file and a new one. See Amethyst Imbuements config for example implementations.
     */
    interface OldClass{

        fun generateNewClass(): Any

    }

    interface ReadMeWriter{
        fun writeReadMe(file: String, base: String = Questify.MOD_ID){
            val textLines: List<String> = readmeText()
            val dirPair = makeDir("", base)
            if (!dirPair.second){
                println("Couldn't make directory for storing the readme")
            }
            val f = File(dirPair.first,file)
            val fw = FileWriter(f)
            textLines.forEach {
                    value -> fw.write(value)
                fw.write(System.getProperty("line.separator"))
            }
            fw.close()
        }

        fun readmeText(): List<String>
    }
}