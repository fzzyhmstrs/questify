package me.fzzyhmstrs.questify.widgets

import me.fzzyhmstrs.questify.arrow.AbstractArrow
import me.fzzyhmstrs.questify.util.Vertex
import net.minecraft.client.gui.widget.ToggleButtonWidget
import net.minecraft.item.Item
import net.minecraft.item.Items

class QuestButtonWidget(x: Int, y: Int, height: Int, width: Int, toggled: Boolean, questId: Int, icon: Item = Items.WRITABLE_BOOK): ToggleButtonWidget(x, y, width, height, toggled) {

    private val arrows: Map<Vertex,AbstractArrow> = mutableMapOf()

    fun hasArrows(): Boolean{
        return arrows.isNotEmpty()
    }

}