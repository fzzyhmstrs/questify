package me.fzzyhmstrs.questify.registry

import me.fzzyhmstrs.questify.screen.QuestScreen
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.minecraft.client.MinecraftClient
import net.minecraft.client.option.KeyBinding
import net.minecraft.client.util.InputUtil
import org.lwjgl.glfw.GLFW

object RegisterKeybind {

    private val OPEN_BOOK: KeyBinding = KeyBindingHelper.registerKeyBinding(
        KeyBinding(
            "key.amethyst_imbuement.vein_mine_key",  // The translation key of the keybinding's name
            InputUtil.Type.KEYSYM,  // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
            GLFW.GLFW_KEY_BACKSLASH,  // The keycode of the key
            KeyBinding.UI_CATEGORY // The translation key of the keybinding's category.
        )
    )

    fun registerAll(){
        ClientTickEvents.END_CLIENT_TICK.register(ClientTickEvents.EndTick { client: MinecraftClient ->
            var pressed = 0
            while (OPEN_BOOK.wasPressed()){
                pressed++
            }
            if (pressed > 0){
                val clientPlayer = client.player
                if (clientPlayer != null) {
                    val oldScreen = client.currentScreen
                    if (oldScreen !is QuestScreen) {
                        QuestScreen.openQuestScreen(clientPlayer, oldScreen)
                    }
                }
            }
        })
    }
}