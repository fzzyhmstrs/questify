package me.fzzyhmstrs.questify.widgets

import net.minecraft.client.gui.Element
import net.minecraft.client.gui.Selectable
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder

class QuestAreaWidget(var width: Int, var height: Int): Element, Selectable {

    companion object{
        const val borderWidth = 16
        const val minViewableWidth = 66
    }

    private var innerWidth = width - borderWidth


    override fun appendNarrations(builder: NarrationMessageBuilder?) {
        TODO("Not yet implemented")
    }

    override fun getType(): Selectable.SelectionType {
        return Selectable.SelectionType.HOVERED
    }
}