package me.fzzyhmstrs.questify.widgets

import com.mojang.blaze3d.systems.RenderSystem
import me.fzzyhmstrs.questify.screen.QuestScreen
import me.fzzyhmstrs.questify.util.TextureUtils
import net.minecraft.client.gui.widget.ToggleButtonWidget
import net.minecraft.client.render.GameRenderer
import net.minecraft.client.util.math.MatrixStack

class QuestTaskRewardWidget {





    open class TaskRewardButtonWidget(x: Int, y: Int, width: Int, height: Int, toggled: Boolean, private var alerted: Boolean = false): ToggleButtonWidget(x, y, width, height, toggled){
        init{
            init()
        }
        private fun init(){
            setTextureUV(104,82,18,18, TextureUtils.SCREEN_TEX)
        }

        override fun renderButton(matrices: MatrixStack?, mouseX: Int, mouseY: Int, delta: Float) {
            RenderSystem.setShader { GameRenderer.getPositionTexShader() }
            RenderSystem.setShaderTexture(0, texture)
            RenderSystem.disableDepthTest()
            var i = u
            var j = v
            if (toggled) {
                i += pressedUOffset
            }
            if (this.isHovered) {
                j += hoverVOffset
            }
            this.drawTexture(matrices, x, y, i, j, width, height)
            if (alerted){

            }
            RenderSystem.enableDepthTest()
        }

    }

}