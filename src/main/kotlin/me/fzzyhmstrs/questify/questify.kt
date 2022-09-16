package me.fzzyhmstrs.questify

import net.fabricmc.api.ModInitializer
import kotlin.random.Random


object Questify: ModInitializer {
    const val MOD_ID = "questify"
    val questifyRandom = Random(System.currentTimeMillis())

    override fun onInitialize() {
    }
}