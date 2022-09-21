package me.fzzyhmstrs.questify.widgets

import me.fzzyhmstrs.questify.rewards.ClientQuestReward
import me.fzzyhmstrs.questify.util.AlertUtils
import me.fzzyhmstrs.questify.widgets.basic.CustomToggleButtonWidget
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.text.Text

class QuestRewardWidget(x: Int, y: Int, tooltip: List<Text>, private val reward: ClientQuestReward):
    CustomToggleButtonWidget(x, y,104,82,18,18,AlertUtils.ALERT_W - 1,-1,18,18, tooltip, reward.pressAction) {

    private var haveCompleted = false

    init{
        checkComplete()
    }

    override fun renderButtonIcon(matrices: MatrixStack, mouseX: Int, mouseY: Int, delta: Float) {
            if (!haveCompleted) {
                checkComplete()
            }
        reward.icon.render(matrices, x + 1, y + 1, delta)
    }

    private fun checkComplete(){
        if (reward.available) {
            setToggle(true)
            if (reward.collected) {
                setAlerted(AlertUtils.IconAlert.GOLD_CHECK)
                haveCompleted = true
            } else {
                setAlerted(AlertUtils.IconAlert.GOLD_EXCLAIM)
            }
        }
    }
}