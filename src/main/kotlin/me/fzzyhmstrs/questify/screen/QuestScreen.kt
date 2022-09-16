package me.fzzyhmstrs.questify.screen

import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.screen.ingame.HandledScreen
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText

class QuestScreen(handler: QuestScreenHandler, inventory: PlayerInventory, title: Text): HandledScreen<QuestScreenHandler>(handler, inventory, title) {
    override fun drawBackground(matrices: MatrixStack?, delta: Float, mouseX: Int, mouseY: Int) {
        TODO("Not yet implemented")
    }
}