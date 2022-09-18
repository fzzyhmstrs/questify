package me.fzzyhmstrs.questify.quests.conditions

import net.minecraft.entity.player.PlayerInventory
import net.minecraft.item.ItemStack

abstract class AbstractInventoryCondition {

    abstract fun test(stack: ItemStack, inventory: PlayerInventory): Boolean

}