package me.fzzyhmstrs.questify.widgets.basic

import net.minecraft.client.gui.DrawableHelper
import net.minecraft.client.gui.Element
import net.minecraft.client.gui.Selectable
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder
import net.minecraft.client.util.math.MatrixStack
import java.awt.Component

open class MenuWidget(): DrawableHelper(), Element, Selectable {

    private val alertableChildren: MutableList<AlertableWidget> = mutableListOf()

    fun addAlertableChild(child: AlertableWidget){
	alertableChildren.add(child)
    }

    override fun appendNarrations(builder: NarrationMessageBuilder) {
        TODO("Not yet implemented")
    }

    override fun getType(): Selectable.SelectionType {
        return Selectable.SelectionType.HOVERED
    }

    fun renderMenu(matrices: MatrixStack, mouseX: Double, mouseY: Double, delta: Float){
	
    }


}