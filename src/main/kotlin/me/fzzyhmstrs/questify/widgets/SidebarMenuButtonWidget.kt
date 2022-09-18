package me.fzzyhmstrs.questify.widgets

import me.fzzyhmstrs.questify.screen.QuestScreen
import net.minecraft.client.gui.widget.ButtonWidget
import net.minecraft.client.gui.widget.TexturedButtonWidget

class SidebarMenuButtonWidget(x: Int, y: Int, u: Int, v: Int, action: PressAction): TexturedButtonWidget(x, y, 12, 12, u, v, QuestScreen.SCREEN_TEX, action) {
}