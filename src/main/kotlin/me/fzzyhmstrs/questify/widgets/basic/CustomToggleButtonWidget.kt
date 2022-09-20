package me.fzzyhmstrs.questify.widgets.basic

import com.mojang.blaze3d.systems.RenderSystem
import me.fzzyhmstrs.questify.util.AlertUtils
import me.fzzyhmstrs.questify.util.TextureUtils
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder
import net.minecraft.client.gui.widget.ButtonWidget
import net.minecraft.client.gui.widget.ClickableWidget
import net.minecraft.client.render.GameRenderer
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.text.LiteralText
import net.minecraft.text.Text

open class CustomToggleButtonWidget(
    x: Int,
    y: Int,
    private val u: Int,
    private val v: Int,
    width: Int,
    height: Int,
    private val toggleOffset: Int,
    private val hoverOffset: Int,
    private val tooltip: List<Text>):
    ClickableWidget(x,y,width,height,LiteralText.EMPTY) {

    protected var toggled: Boolean = false
    protected var alerted: Boolean = false
    protected var alert: AlertUtils.AbstractAlert = AlertUtils.IconAlert.EMPTY
    protected var pressAction: PressAction? = null

    var uu: Int = u + if (toggled) toggleOffset else 0

    fun setToggle(toggled: Boolean){
        uu = u + if (toggled) toggleOffset else 0
        this.toggled = toggled
    }

    fun setAlerted(alert: AlertUtils.AbstractAlert){
        alerted = alert != AlertUtils.IconAlert.EMPTY
        this.alert = alert
    }
    fun clearAlert(){
        setAlerted(AlertUtils.IconAlert.EMPTY)
    }

    fun setPos(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

    override fun onClick(mouseX: Double, mouseY: Double) {
        onPressed(mouseX, mouseY)
    }

    open fun onPressed(mouseX: Double, mouseY: Double){
        pressAction?.onPress(this)
    }

    override fun renderButton(matrices: MatrixStack, mouseX: Int, mouseY: Int, delta: Float) {
        RenderSystem.setShader { GameRenderer.getPositionTexShader() }
        RenderSystem.disableDepthTest()
        val vv = v + if (hovered) hoverOffset else 0
        this.drawTexture(matrices, x, y, uu, vv, width, height)
        RenderSystem.enableDepthTest()
        renderButtonIcon(matrices, mouseX, mouseY, delta)
        if (alerted){
            AlertUtils.drawAlert(matrices, alert, x, y, hovered)
        }
        if (hovered){
            renderTooltip(matrices, mouseX, mouseY)
        }
    }

    open fun renderButtonIcon(matrices: MatrixStack, mouseX: Int, mouseY: Int, delta: Float){
    }

    override fun renderTooltip(matrices: MatrixStack, mouseX: Int, mouseY: Int) {
        TextureUtils.renderQuestTooltip(matrices,tooltip,mouseX, mouseY)
    }

    override fun appendNarrations(builder: NarrationMessageBuilder?) {
        this.appendDefaultNarrations(builder)
    }


    @Environment(value = EnvType.CLIENT)
    interface PressAction {
        fun onPress(var1: CustomToggleButtonWidget?)
    }

}