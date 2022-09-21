package me.fzzyhmstrs.questify.util.icons

import me.fzzyhmstrs.questify.util.TextureUtils
import me.fzzyhmstrs.questify.widgets.basic.AlertableWidget
import net.minecraft.client.util.math.MatrixStack

interface IconProvider {

    val pressAction: AlertableWidget.PressAction

    fun render(matrices: MatrixStack, x: Int, y: Int, delta: Float){
        renderIcon(matrices, x, y, delta)
        TextureUtils.setScreenTex()
    }

    fun renderIcon(matrices: MatrixStack, x: Int, y: Int, delta: Float)

}