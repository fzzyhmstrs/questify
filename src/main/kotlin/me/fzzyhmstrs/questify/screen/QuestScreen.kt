package me.fzzyhmstrs.questify.screen

import com.mojang.blaze3d.systems.RenderSystem
import me.fzzyhmstrs.questify.Questify
import me.fzzyhmstrs.questify.widgets.QuestAreaWidget
import me.fzzyhmstrs.questify.widgets.SidebarWidget
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.DrawableHelper
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.network.ClientPlayerEntity
import net.minecraft.client.render.GameRenderer
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.text.TranslatableText
import net.minecraft.util.Identifier

class QuestScreen(private val player: ClientPlayerEntity, val oldScreen: Screen?): Screen(TranslatableText("questify.screen.title")) {

    companion object{
        internal val SCREEN_TEX = Identifier(Questify.MOD_ID,"textures/gui/buttons_widgets.png")

        fun openQuestScreen(player: ClientPlayerEntity, oldScreen: Screen?){
            MinecraftClient.getInstance().setScreen(QuestScreen(player, oldScreen))
        }
    }
    private var questAreaWidth = 0
    private var questAreaWidget: QuestAreaWidget? = null
    private var sidebarWidget: SidebarWidget? = null

    override fun init() {
        super.init()
        questAreaWidth = this.width - SidebarWidget.sidebarWidth
        if (questAreaWidth <= (QuestAreaWidget.borderWidth + QuestAreaWidget.minViewableWidth)) {
            player.sendMessage(TranslatableText("questify.screen.too_narrow"),false)
            close()
        }
        if (height <= (QuestAreaWidget.borderWidth + QuestAreaWidget.minViewableWidth)) {
            player.sendMessage(TranslatableText("questify.screen.too_short"),false)
            close()
        }
        sidebarWidget = SidebarWidget(height)
        setInitialFocus(sidebarWidget)
    }

    override fun render(matrices: MatrixStack, mouseX: Int, mouseY: Int, delta: Float) {
        RenderSystem.setShader { GameRenderer.getPositionTexShader() }
        RenderSystem.setShaderTexture(0, SCREEN_TEX)
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f)
        //start by filling in the background with the dark grey color
        DrawableHelper.fill(matrices,0,0,this.width,this.height,0x373737)
        //draw the two main widgets. Quest are first so it is "under" the sidebar.
        questAreaWidget?.draw(matrices, mouseX, mouseY, delta)
        sidebarWidget?.draw(matrices, mouseX, mouseY, delta)
    }

    override fun close() {
        super.close()
        client?.setScreen(oldScreen)
    }

}