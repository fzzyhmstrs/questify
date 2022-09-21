package me.fzzyhmstrs.questify.widgets.menu

import me.fzzyhmstrs.questify.quests.ClientQuest
import me.fzzyhmstrs.questify.rewards.ClientQuestReward
import me.fzzyhmstrs.questify.tasks.ClientQuestTask
import me.fzzyhmstrs.questify.widgets.basic.MenuWidget
import net.minecraft.text.OrderedText
import net.minecraft.text.Text
import kotlin.math.ceil
import kotlin.math.max

class QuestEditWidget(title: Text, quest: ClientQuest): MenuWidget(title) {



    override fun customHeightNeeded(): Int {
        return 0
    }
}