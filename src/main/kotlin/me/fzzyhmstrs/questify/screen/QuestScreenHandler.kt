package me.fzzyhmstrs.questify.screen

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerType

class QuestScreenHandler(type: ScreenHandlerType<*>,syncId: Int): ScreenHandler(type,syncId) {
    override fun canUse(player: PlayerEntity?): Boolean {
        TODO("Not yet implemented")
    }

}