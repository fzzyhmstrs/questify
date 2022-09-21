package me.fzzyhmstrs.questify.widgets.menu

import me.fzzyhmstrs.questify.rewards.ClientQuestReward
import me.fzzyhmstrs.questify.tasks.ClientQuestTask
import me.fzzyhmstrs.questify.widgets.basic.MenuWidget
import net.minecraft.text.OrderedText
import net.minecraft.text.Text
import kotlin.math.ceil
import kotlin.math.max

class QuestMenuWidget(title: Text, private val tasks: List<ClientQuestTask>, private val rewards: List<ClientQuestReward>, flavor: List<Text>): MenuWidget(title) {

    val flavorLines: List<OrderedText> = listOf() //update with init-ing later

    private val flavorHeight = 10 + 10 * flavorLines.size
    private val subtitleHeight = 11
    private val taskHeight = (ceil(tasks.size.toFloat()/3.0f) * buttonHeight) + 2
    private val rewardHeight = (ceil(rewards.size.toFloat()/2.0f) * buttonHeight) + 2
    private val taskRewardHeight = max(taskHeight, rewardHeight).toInt()
    private var actualButtonHeight = buttonHeight




    override fun customHeightNeeded(): Int {
        return flavorHeight + subtitleHeight + taskRewardHeight
    }

    companion object {
        const val buttonHeight = 19
    }
}