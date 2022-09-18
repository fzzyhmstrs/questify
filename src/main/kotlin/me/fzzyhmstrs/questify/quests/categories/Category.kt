package me.fzzyhmstrs.questify.quests.categories

import me.fzzyhmstrs.questify.quests.AbstractQuest

abstract class Category<T: AbstractQuest> {

    private val subCategories: MutableList<SubCategory<T>> = mutableListOf()
    internal val currentSubCategory: Int = 0

}