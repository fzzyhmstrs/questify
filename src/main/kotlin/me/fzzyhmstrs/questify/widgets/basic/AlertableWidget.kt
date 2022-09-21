package me.fzzyhmstrs.questify.widgets.basic

import me.fzzyhmstrs.questify.util.AlertUtils
import me.fzzyhmstrs.questify.util.TextureUtils
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder
import net.minecraft.client.gui.widget.ClickableWidget
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.text.LiteralText
import net.minecraft.text.Text
import org.lwjgl.glfw.GLFW

open class AlertableWidget(
    x: Int,
    y: Int,
    width: Int,
    height: Int,
    alertXOffset: Int = AlertUtils.ALERT_W,
    alertYOffset: Int = 0,
    private val tooltip: List<Text>,
    private val pressAction: PressAction):
    ClickableWidget(x,y,width,height,LiteralText.EMPTY) {

    protected var alerted: Boolean = false
    protected var alert: AlertUtils.AbstractAlert = AlertUtils.IconAlert.EMPTY
    private var alertX = x + width - alertXOffset
    private var alertY = y - alertYOffset

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
        alertX = x + width - AlertUtils.ALERT_W
    }

    override fun mouseClicked(mouseX: Double, mouseY: Double, button: Int): Boolean {
        if (button == GLFW.GLFW_MOUSE_BUTTON_RIGHT && this.clicked(mouseX, mouseY)){
            playDownSound(MinecraftClient.getInstance().soundManager)
            onRightClick(mouseX, mouseY)
            return true
        }
        return super.mouseClicked(mouseX, mouseY, button)
    }

    override fun onClick(mouseX: Double, mouseY: Double) {
        onPressed(mouseX, mouseY)
    }

    open fun onPressed(mouseX: Double, mouseY: Double){
        pressAction.onPress(this)
    }

    open fun onRightClick(mouseX: Double, mouseY: Double){

    }

    override fun renderButton(matrices: MatrixStack, mouseX: Int, mouseY: Int, delta: Float) {
        renderButtonBase(matrices, mouseX, mouseY, delta)
        renderButtonIcon(matrices, mouseX, mouseY, delta)
        if (alerted){
            AlertUtils.drawAlert(matrices, alert, alertX, y, hovered)
        }
        if (hovered){
            renderTooltip(matrices, mouseX, mouseY)
        }
    }

    open fun renderButtonBase(matrices: MatrixStack, mouseX: Int, mouseY: Int, delta: Float){
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
        fun onPress(var1: AlertableWidget?)
    }

}
