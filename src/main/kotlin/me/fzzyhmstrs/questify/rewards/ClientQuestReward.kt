package me.fzzyhmstrs.questify.rewards

import me.fzzyhmstrs.questify.util.NetworkingUtils
import me.fzzyhmstrs.questify.util.icons.IconProvider
import me.fzzyhmstrs.questify.widgets.basic.AlertableWidget
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs
import net.minecraft.util.Identifier

class ClientQuestReward(val id: Identifier, val icon: IconProvider, var available: Boolean, var collected: Boolean) {

    val pressAction = ClientRewardPressAction(id)

    class ClientRewardPressAction(val id: Identifier): AlertableWidget.PressAction{
        override fun onPress(var1: AlertableWidget?) {
            val buf = PacketByteBufs.create()
            buf.writeIdentifier(id)
            ClientPlayNetworking.send(NetworkingUtils.REWARD_COLLECT,buf)
        }
    }

}