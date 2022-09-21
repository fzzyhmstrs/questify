package me.fzzyhmstrs.questify.tasks

import me.fzzyhmstrs.questify.util.icons.IconProvider
import net.minecraft.util.Identifier

class ClientQuestTask(val id: Identifier , val icon: IconProvider, var complete: Boolean = false) {
}