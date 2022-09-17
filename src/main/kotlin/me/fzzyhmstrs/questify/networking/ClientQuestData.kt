package me.fzzyhmstrs.questify.networking

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
import net.minecraft.network.PacketByteBuf

object ClientQuestData {

    private fun handlePlayerSync(buf: PacketByteBuf){

    }

    private fun handleQuestSync(buf: PacketByteBuf){

    }

    fun registerClient(){
        ClientPlayNetworking.registerGlobalReceiver(NetworkingInfo.PLAYER_QUEST_SYNC) {_,_,buf,_ ->
            handlePlayerSync(buf)
        }
    }

}