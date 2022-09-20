package me.fzzyhmstrs.questify.widgets

import me.fzzyhmstrs.questify.screen.QuestScreen
import me.fzzyhmstrs.questify.util.TextureUtils
import net.minecraft.client.gui.widget.ButtonWidget
import net.minecraft.client.gui.widget.TexturedButtonWidget

class SidebarMenuButtonWidget(x: Int, y: Int, u: Int, v: Int, action: PressAction): TexturedButtonWidget(x, y, 12, 12, u, v, TextureUtils.SCREEN_TEX, action) {
}