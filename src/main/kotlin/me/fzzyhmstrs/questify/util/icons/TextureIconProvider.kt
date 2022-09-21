package me.fzzyhmstrs.questify.util.icons

import com.mojang.blaze3d.systems.RenderSystem
import me.fzzyhmstrs.questify.util.TextureUtils
import me.fzzyhmstrs.questify.widgets.basic.AlertableWidget
import net.minecraft.client.gui.DrawableHelper
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.item.Item
import net.minecraft.util.Identifier

class TextureIconProvider(private val texture: Identifier, private val u: Int, private val v: Int): IconProvider {
    override val pressAction = object: AlertableWidget.PressAction {
        override fun onPress(var1: AlertableWidget?) {
        }
    }

    override fun renderIcon(matrices: MatrixStack, x: Int, y: Int, delta: Float) {
        RenderSystem.setShaderTexture(0,texture)
        TextureUtils.drawTexture(matrices,x,y,u,v,16,16)
    }
}