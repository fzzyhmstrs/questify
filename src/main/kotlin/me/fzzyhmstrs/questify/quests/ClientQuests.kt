package me.fzzyhmstrs.questify.quests

import me.fzzyhmstrs.questify.quests.categories.Category
import me.fzzyhmstrs.questify.util.Vertex
import me.fzzyhmstrs.questify.widgets.QuestButtonWidget
import me.fzzyhmstrs.questify.widgets.SidebarWidget

object ClientQuests {

    internal val buttons: MutableMap<Vertex,QuestButtonWidget> = mutableMapOf()
    internal val categories: MutableMap<Int,Category<ClientQuest>> = mutableMapOf()
    internal val currentCategory = 0
    internal val categoryCount = 0
    internal val sidebar: SidebarWidget = SidebarWidget(240)


}