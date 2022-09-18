package me.fzzyhmstrs.questify.widgets

import net.minecraft.client.gui.Element
import net.minecraft.client.gui.Selectable
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.entity.player.PlayerEntity

class SidebarWidget(private var height: Int): Element,Selectable {

    companion object {
        val sidebarWidth = 79
    }

    fun draw(matrixStack: MatrixStack, mouseX: Int, mouseY: Int, delta: Float){

    }

    override fun appendNarrations(builder: NarrationMessageBuilder) {
        TODO("Not yet implemented")
    }

    override fun getType(): Selectable.SelectionType {
        return Selectable.SelectionType.HOVERED
    }

}