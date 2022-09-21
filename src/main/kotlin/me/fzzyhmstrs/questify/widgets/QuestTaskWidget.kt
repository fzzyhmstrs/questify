package me.fzzyhmstrs.questify.widgets

import com.mojang.blaze3d.systems.RenderSystem
import me.fzzyhmstrs.questify.screen.QuestScreen
import me.fzzyhmstrs.questify.tasks.ClientQuestTask
import me.fzzyhmstrs.questify.util.AlertUtils
import me.fzzyhmstrs.questify.util.TextureUtils
import me.fzzyhmstrs.questify.widgets.basic.CustomToggleButtonWidget
import net.minecraft.client.gui.widget.ToggleButtonWidget
import net.minecraft.client.render.GameRenderer
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.text.Text

class QuestTaskWidget(x: Int, y: Int, tooltip: List<Text>, private val task: ClientQuestTask):
    CustomToggleButtonWidget(x, y,104,82,18,18,AlertUtils.ALERT_W - 1,-1,18,18, tooltip, task.icon.pressAction) {

    private var haveCompleted = false

    init{
        checkComplete()
    }

    override fun renderButtonIcon(matrices: MatrixStack, mouseX: Int, mouseY: Int, delta: Float) {
            if (!haveCompleted) {
                checkComplete()
            }
        task.icon.render(matrices, x + 1, y + 1, delta)
    }

    private fun checkComplete(){
        if (task.complete) {
            setToggle(true)
            setAlerted(AlertUtils.IconAlert.GOLD_CHECK)
            haveCompleted = true
        }
    }
}