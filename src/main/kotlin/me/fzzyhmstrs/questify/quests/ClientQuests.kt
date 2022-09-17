package me.fzzyhmstrs.questify.quests

import me.fzzyhmstrs.questify.util.Vertex
import me.fzzyhmstrs.questify.widgets.QuestButtonWidget

object ClientQuests {

    internal val buttons: MutableMap<Vertex,QuestButtonWidget> = mutableMapOf()
    internal val quests: MutableMap<Int,ClientQuest> = mutableMapOf()
    internal var centerTile: Vertex = Vertex(0,0)
    internal var upperBoundTile: Vertex = Vertex(0,0)
    internal var lowerBoundTile: Vertex = Vertex(0,0)

}