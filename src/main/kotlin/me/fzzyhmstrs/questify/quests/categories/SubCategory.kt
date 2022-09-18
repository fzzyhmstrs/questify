package me.fzzyhmstrs.questify.quests.categories

import me.fzzyhmstrs.questify.quests.AbstractQuest
import me.fzzyhmstrs.questify.util.Vertex

abstract class SubCategory<T: AbstractQuest> {

    private val quests: MutableMap<Int,T> = mutableMapOf()
    internal var centerTile: Vertex = Vertex(0,0)
    internal var upperBoundTile: Vertex = Vertex(0,0)
    internal var lowerBoundTile: Vertex = Vertex(0,0)
}