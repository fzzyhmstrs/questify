package me.fzzyhmstrs.questify.screen

import com.mojang.blaze3d.systems.RenderSystem
import me.fzzyhmstrs.questify.Questify
import me.fzzyhmstrs.questify.widgets.QuestAreaWidget
import me.fzzyhmstrs.questify.widgets.SidebarWidget
import net.minecraft.client.gui.DrawableHelper
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.render.GameRenderer
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.text.TranslatableText
import net.minecraft.util.Identifier

class QuestScreen: Screen(TranslatableText("questify.screen.title")) {

    companion object{
        private val SCREEN_TEX = Identifier(Questify.MOD_ID,"textures/gui/buttons_widgets.png")
    }
    private var sidebarHeight = 0
    private var questAreaWidth = 0
    private var questAreaWidget: QuestAreaWidget? = null
    private var sidebarWidget: SidebarWidget? = null

    override fun init() {
        super.init()
        sidebarHeight = this.height
        questAreaWidth = this.width - SidebarWidget.sidebarWidth
        if (questAreaWidth <= (QuestAreaWidget.borderWidth + QuestAreaWidget.minViewableWidth)) close()

    }

    override fun render(matrices: MatrixStack?, mouseX: Int, mouseY: Int, delta: Float) {
        RenderSystem.setShader { GameRenderer.getPositionTexShader() }
        RenderSystem.setShaderTexture(0, SCREEN_TEX)
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f)
        //start by filling in the background with the dark grey color
        DrawableHelper.fill(matrices,0,0,this.width,this.height,0x373737)
    }

}