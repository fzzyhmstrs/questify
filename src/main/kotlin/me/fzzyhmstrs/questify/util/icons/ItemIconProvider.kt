package me.fzzyhmstrs.questify.util.icons

import me.fzzyhmstrs.questify.widgets.basic.AlertableWidget
import net.minecraft.client.MinecraftClient
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.item.ItemStack

class ItemIconProvider(private val item: ItemStack): IconProvider {

    private val client = MinecraftClient.getInstance()
    override val pressAction: AlertableWidget.PressAction = object: AlertableWidget.PressAction{
        override fun onPress(var1: AlertableWidget?) {
        }
    }

    override fun renderIcon(matrices: MatrixStack, x: Int, y: Int, delta: Float) {
        client.itemRenderer.renderInGui(item,x, y)
    }

}