package me.fzzyhmstrs.questify.quests

import me.fzzyhmstrs.questify.quests.conditions.ItemStackCondition
import net.minecraft.item.ItemStack
import java.util.function.Predicate

object ServerQuests {

    internal val quests: MutableMap<Int,ServerQuest> = mutableMapOf()
    internal var itemListeners: MutableList<ItemStackCondition> = mutableListOf()

}