package me.fzzyhmstrs.questify.quests

abstract class AbstractQuest(val id: Int) {

    private val sisters: MutableList<AbstractQuest> = mutableListOf()

    fun hasSister(): Boolean{
        return sisters.isNotEmpty()
    }

}