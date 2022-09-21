package me.fzzyhmstrs.questify.widgets.basic

import me.fzzyhmstrs.questify.util.TextureUtils
import net.minecraft.client.gui.DrawableHelper
import net.minecraft.client.gui.Element
import net.minecraft.client.gui.ParentElement
import net.minecraft.client.gui.Selectable
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.text.Text
import java.awt.Component
import kotlin.math.min

open class MenuWidget(val title: Text): DrawableHelper(), Element, Selectable {

    protected val baseHeight = 23

    private val alertableChildren: MutableList<AlertableWidget> = mutableListOf()
    val heightGiven: Int

    init{
        heightGiven = min(TextureUtils.getQuestScreenHeight(),heightNeeded())
    }

    private fun heightNeeded(): Int{
        return baseHeight + customHeightNeeded()
    }

    open fun customHeightNeeded(): Int{
        return 0
    }

    fun addAlertableChild(child: AlertableWidget){
	alertableChildren.add(child)
    }

    override fun appendNarrations(builder: NarrationMessageBuilder) {
        TODO("Not yet implemented")
    }

    override fun getType(): Selectable.SelectionType {
        return Selectable.SelectionType.HOVERED
    }

    open fun renderMenu(matrices: MatrixStack, mouseX: Double, mouseY: Double, delta: Float){
	
    }


}