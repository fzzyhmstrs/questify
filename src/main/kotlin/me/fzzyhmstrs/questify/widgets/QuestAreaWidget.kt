package me.fzzyhmstrs.questify.widgets

import net.minecraft.client.gui.DrawableHelper
import net.minecraft.client.gui.Element
import net.minecraft.client.gui.Selectable
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder
import net.minecraft.client.util.math.MatrixStack
import java.awt.Component

class QuestAreaWidget(var width: Int, var height: Int, var xOffset: Int): DrawableHelper(), Element, Selectable {

    companion object{
        const val borderWidth = 16
        const val minViewableWidth = 66
        const val borderTexHeight = 240
        const val borderTexWidth = 256
    }

    private var innerWidth = width - borderWidth
    private var innerHeight = height - borderWidth
    private var horizontalTiles = innerWidth / 22
    private var verticalTiles = innerHeight / 22
    private var horizontalOffset = innerWidth % 22
    private var verticalOffset = innerHeight % 22

    fun resize(width: Int, height: Int, xOffset: Int){
        this.width = width
        this.height = height
        this.xOffset = xOffset
        innerWidth = width - borderWidth
        innerHeight = height - borderWidth
        horizontalTiles = innerWidth / 22
        verticalTiles = innerHeight / 22
        horizontalOffset = innerWidth % 22
        verticalOffset = innerHeight % 22
    }

    override fun appendNarrations(builder: NarrationMessageBuilder?) {
        TODO("Not yet implemented")
    }

    override fun getType(): Selectable.SelectionType {
        return Selectable.SelectionType.HOVERED
    }

    fun draw(matrixStack: MatrixStack, mouseX: Int, mouseY: Int, delta: Float){
        //first draw the
        drawTexture(matrixStack,xOffset,0,0,195,8,8)
        drawTexture(matrixStack,xOffset + width - 8,0,8,195,8,8)
        drawTexture(matrixStack,xOffset,height - 8,16,195,8,8)
        drawTexture(matrixStack,xOffset + width - 8,height - 8,24,195,8,8)
        var remainingHeight = innerHeight
        var yOffset = 8
        while (remainingHeight >= borderTexHeight){
            drawTexture(matrixStack,xOffset,yOffset,231,0,8, borderTexHeight)
            yOffset+= borderTexHeight
            remainingHeight-= borderTexHeight
        }
        drawTexture(matrixStack,xOffset,yOffset,231,0,8,remainingHeight)
        var xBorderOffset = 8
        var remainingWidth = innerWidth
        while (remainingWidth >= borderTexWidth){
            drawTexture(matrixStack,xOffset,yOffset,0,240, borderTexWidth, borderTexHeight)
            yOffset+= borderTexHeight
            remainingHeight-= borderTexHeight
        }


    }
}