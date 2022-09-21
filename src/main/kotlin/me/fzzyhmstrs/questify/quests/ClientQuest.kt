package me.fzzyhmstrs.questify.quests

import me.fzzyhmstrs.questify.rewards.ClientQuestReward
import me.fzzyhmstrs.questify.tasks.ClientQuestTask
import me.fzzyhmstrs.questify.widgets.basic.MenuWidget
import me.fzzyhmstrs.questify.widgets.menu.QuestMenuWidget
import net.minecraft.text.Text

class ClientQuest(id: Int, var title: Text): AbstractQuest(id) {

    val tooltip: MutableList<Text> = mutableListOf()
    val flavorTip: MutableList<Text> = mutableListOf()
    var hasArrows: Boolean = false
    var isCompleted: Boolean = false
    var rewardsTaken: Boolean = false

    private val tasks: MutableList<ClientQuestTask> = mutableListOf()
    private val rewards: MutableList<ClientQuestReward> = mutableListOf()


    fun getQuestMenu(): MenuWidget{
        return QuestMenuWidget(title, tasks, rewards, flavorTip)
    }

}