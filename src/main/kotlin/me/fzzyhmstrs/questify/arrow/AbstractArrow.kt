package me.fzzyhmstrs.questify.arrow

abstract class AbstractArrow {

    val children: MutableList<AbstractArrow> = mutableListOf()

    fun arrowChildren(): List<AbstractArrow>{
        return children
    }

    abstract fun possibleChildren(): List<AbstractArrow>

    open fun xOffset(): Int{
        return -2
    }
    open fun yOffset(): Int{
        return -2
    }

}