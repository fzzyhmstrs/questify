package me.fzzyhmstrs.questify

import me.fzzyhmstrs.questify.registry.RegisterCommand
import me.fzzyhmstrs.questify.registry.RegisterItem
import me.fzzyhmstrs.questify.registry.RegisterScreen
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.ModInitializer
import kotlin.random.Random


object Questify: ModInitializer {
    const val MOD_ID = "questify"
    val questifyRandom = Random(System.currentTimeMillis())

    override fun onInitialize() {
        RegisterItem.registerAll()
        RegisterCommand.registerAll()
    }
}

object QuestifyClient: ClientModInitializer{

    override fun onInitializeClient() {
        RegisterScreen.registerAll()
    }

}