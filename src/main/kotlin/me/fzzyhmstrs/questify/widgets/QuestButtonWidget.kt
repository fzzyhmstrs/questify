package me.fzzyhmstrs.questify.widgets

import me.fzzyhmstrs.questify.arrow.AbstractArrow
import me.fzzyhmstrs.questify.util.Vertex
import net.minecraft.client.gui.widget.ToggleButtonWidget

class QuestButtonWidget(x: Int, y: Int, height: Int, width: Int, toggled: Boolean, questId: Int): ToggleButtonWidget(x, y, width, height, toggled) {

    private val arrows: Map<Vertex,AbstractArrow> = mutableMapOf()

    fun hasArrows(): Boolean{
        return arrows.isNotEmpty()
    }

}