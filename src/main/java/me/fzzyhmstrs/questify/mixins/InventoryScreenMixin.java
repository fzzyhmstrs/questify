package me.fzzyhmstrs.questify.mixins;

import me.fzzyhmstrs.questify.config.QuestifyConfig;
import me.fzzyhmstrs.questify.screen.QuestScreen;
import me.fzzyhmstrs.questify.util.TextureUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryScreen.class)
public abstract class InventoryScreenMixin extends HandledScreen<PlayerScreenHandler> {

    private TexturedButtonWidget questBookWidget;

    public InventoryScreenMixin(PlayerScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Inject(method = "init", at = @At(value = "TAIL"))
    private void addQuestBook(CallbackInfo ci){
        MinecraftClient bookClient = this.client;
        if (bookClient != null) {
            ClientPlayerEntity bookPlayer = bookClient.player;
            if (bookPlayer != null) {
                questBookWidget = new TexturedButtonWidget(
                        this.x + QuestifyConfig.INSTANCE.getLayout().getPlayerInventoryQuestBookXOffset(),
                        this.height / 2 + QuestifyConfig.INSTANCE.getLayout().getPlayerInventoryQuestBookYOffset(),
                        20,
                        18,
                        172,
                        0,
                        TextureUtils.INSTANCE.getSCREEN_TEX$questify_main(), (button) -> QuestScreen.Companion.openQuestScreen(bookPlayer, (InventoryScreen) (Object) this)
                );
                this.addDrawableChild(questBookWidget);
            }
        }
    }

    @Inject(method = "method_19891", at = @At(value = "INVOKE", target = "net/minecraft/client/gui/widget/TexturedButtonWidget.setPos (II)V"))
    private void moveButton(ButtonWidget button, CallbackInfo ci){
        questBookWidget.setPos(
                this.x + QuestifyConfig.INSTANCE.getLayout().getPlayerInventoryQuestBookXOffset(),
                this.height / 2 + QuestifyConfig.INSTANCE.getLayout().getPlayerInventoryQuestBookYOffset()
        );
    }

}
