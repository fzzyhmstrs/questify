package me.fzzyhmstrs.questify.util

import com.mojang.blaze3d.systems.RenderSystem
import me.fzzyhmstrs.questify.Questify
import me.fzzyhmstrs.questify.screen.QuestScreen
import me.fzzyhmstrs.questify.widgets.basic.MenuWidget
import net.minecraft.client.MinecraftClient
import net.minecraft.client.font.TextRenderer
import net.minecraft.client.gui.DrawableHelper
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.text.Text
import net.minecraft.util.Identifier

object TextureUtils: DrawableHelper() {

    internal val SCREEN_TEX = Identifier(Questify.MOD_ID,"textures/gui/buttons_widgets.png")
    internal val ARROW_TEX = Identifier(Questify.MOD_ID,"textures/gui/arrows.png")


    private var screenTexId = 0
    private var arrowTextId = 0
    private var questScreen: QuestScreen? = null


    fun initTextureUtils(client: MinecraftClient){
        val textureManager = client.textureManager
        screenTexId = textureManager.getTexture(SCREEN_TEX).glId
        arrowTextId = textureManager.getTexture(ARROW_TEX).glId
    }

    fun setScreenTex() {
        RenderSystem.setShaderTexture(0, screenTexId)
    }

    fun setArrowTex(){
        RenderSystem.setShaderTexture(0, arrowTextId)
    }

    fun setQuestScreen(screen: QuestScreen?){
        questScreen = screen
    }

    fun getQuestScreenHeight(): Int{
        return questScreen?.height?:0
    }

    fun renderQuestTooltip(matrices: MatrixStack, texts: List<Text>, x: Int, y: Int){
        questScreen?.renderTooltip(matrices, texts, x, y)
    }

    fun openMenuWidget(menu: MenuWidget){
        questScreen?.setMenuWidget(menu)
    }

}