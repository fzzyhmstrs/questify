package me.fzzyhmstrs.questify.widgets

import me.fzzyhmstrs.questify.arrow.AbstractArrow
import me.fzzyhmstrs.questify.util.Vertex
import net.minecraft.client.gui.widget.ToggleButtonWidget
import net.minecraft.item.Item
import net.minecraft.item.Items

class QuestButtonWidget(x: Int, y: Int, u: Int, v: Int, height: Int, width: Int, quest: ClientQuest, icon: Item = Items.WRITABLE_BOOK, pressAction: PressAction): 
CustomToggleButtonWidget(x, y, u, v, width, height, 22, 22, quest.tooltip, openQuestWindowAction) {

    private val openQuestWindowAction = PressAction {alertable -> TextureUtils.openMenuWidget(quest.questMenu)}
    
    fun hasArrows(): Boolean{
        return quest.hasArrows()
    }
    
    fun setQuestAlert(){
        if (quest.isCompleted && !quest.rewardsTaken){
            setAlerted(AlertUtils.IconAlert.GOLD_EXCLAIM)
        } else if (quest.isCompleted && quest.rewardsTaken){
            setAlerted(AlertUtils.IconAlert.GOLD_CHECK)
        }
    }
    
    //need to check for a right click method...
    
    override fun renderButtonIcon(matrices: MatrixStack, mouseX: Int, mouseY: Int, delta: Float){
        //renderItem here
    }

}
