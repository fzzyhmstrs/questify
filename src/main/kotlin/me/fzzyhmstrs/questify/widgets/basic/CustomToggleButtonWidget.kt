package me.fzzyhmstrs.questify.widgets.basic

import com.mojang.blaze3d.systems.RenderSystem
import me.fzzyhmstrs.questify.util.AlertUtils
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder
import net.minecraft.client.render.GameRenderer
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.text.Text

open class CustomToggleButtonWidget(
    x: Int,
    y: Int,
    private val u: Int,
    private val v: Int,
    width: Int,
    height: Int,
    alertXOffset: Int = AlertUtils.ALERT_W,
    alertYOffset: Int = 0,
    private val toggleOffset: Int,
    private val hoverOffset: Int,
    tooltip: List<Text>,
    pressAction: PressAction):
    AlertableWidget(x,y,width,height,alertXOffset,alertYOffset,tooltip,pressAction) {

    private var toggled: Boolean = false

    var uu: Int = u + if (toggled) toggleOffset else 0

    fun setToggle(toggled: Boolean){
        uu = u + if (toggled) toggleOffset else 0
        this.toggled = toggled
    }
    
    fun isToggled(): Boolean{
        return toggled
    }

    override fun renderButtonBase(matrices: MatrixStack, mouseX: Int, mouseY: Int, delta: Float) {
        RenderSystem.setShader { GameRenderer.getPositionTexShader() }
        RenderSystem.disableDepthTest()
        val vv = v + if (hovered) hoverOffset else 0
        this.drawTexture(matrices, x, y, uu, vv, width, height)
        RenderSystem.enableDepthTest()
    }

    override fun appendNarrations(builder: NarrationMessageBuilder?) {
        this.appendDefaultNarrations(builder)
    }
}
