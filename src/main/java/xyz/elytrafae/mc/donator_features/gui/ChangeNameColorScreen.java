package xyz.elytrafae.mc.donator_features.gui;

import eu.pb4.sgui.api.gui.SimpleGui;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.server.network.ServerPlayerEntity;
import xyz.elytrafae.mc.donator_features.Texts;

public class ChangeNameColorScreen extends SimpleGui {

    // Add options to change name, chat message and pronoun colors
    public ChangeNameColorScreen(ServerPlayerEntity player) {
        super(ScreenHandlerType.GENERIC_9X6, player, false);
        this.setTitle(Texts.TEXT_COLOR_TITLE);
        this.setLockPlayerInventory(true);
    }
    
}
