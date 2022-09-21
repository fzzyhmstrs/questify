package me.fzzyhmstrs.questify.widgets

import me.fzzyhmstrs.questify.quests.ClientQuest
import me.fzzyhmstrs.questify.util.AlertUtils
import me.fzzyhmstrs.questify.util.TextureUtils
import me.fzzyhmstrs.questify.widgets.basic.AlertableWidget
import me.fzzyhmstrs.questify.widgets.basic.CustomToggleButtonWidget
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.item.Item
import net.minecraft.item.Items

class QuestButtonWidget(x: Int, y: Int, u: Int, v: Int, height: Int, width: Int, private val quest: ClientQuest, private val icon: Item = Items.WRITABLE_BOOK, pressAction: PressAction):
CustomToggleButtonWidget(x, y, u, v, width, height,AlertUtils.ALERT_W - 1,0, 22, 22, quest.tooltip, object : PressAction {
    override fun onPress(var1: AlertableWidget?) {
        TextureUtils.openMenuWidget(quest.getQuestMenu())
    }
}) {
    
    fun hasArrows(): Boolean{
        return quest.hasArrows
    }
    
    fun setQuestAlert(){
        if (quest.isCompleted && !quest.rewardsTaken){
            setAlerted(AlertUtils.IconAlert.GOLD_EXCLAIM)
        } else if (quest.isCompleted && quest.rewardsTaken){
            setAlerted(AlertUtils.IconAlert.GOLD_CHECK)
        }
    }

    override fun onRightClick(mouseX: Double, mouseY: Double) {
        //TextureUtils.openMenuWidget()
    }
    
    override fun renderButtonIcon(matrices: MatrixStack, mouseX: Int, mouseY: Int, delta: Float){
        //renderItem here
    }

}
