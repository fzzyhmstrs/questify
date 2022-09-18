package me.fzzyhmstrs.questify.config

import net.minecraft.network.PacketByteBuf

object QuestifyConfig: SyncedConfigHelper.SyncedConfig {

    var layout: Layout

    init{
        layout = SyncedConfigHelper.readOrCreate("layout_v0.json") { Layout() }
    }

    class Layout(){
        var playerInventoryQuestBookXOffset: Int = 128
        var playerInventoryQuestBookYOffset: Int = -22
    }

    override fun readFromServer(buf: PacketByteBuf) {
        TODO("Not yet implemented")
    }

    override fun writeToClient(buf: PacketByteBuf) {
        TODO("Not yet implemented")
    }

    override fun initConfig() {
    }


}