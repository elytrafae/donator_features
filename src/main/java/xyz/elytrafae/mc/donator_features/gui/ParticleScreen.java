package xyz.elytrafae.mc.donator_features.gui;

import eu.pb4.sgui.api.gui.SimpleGui;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.server.network.ServerPlayerEntity;
import xyz.elytrafae.mc.donator_features.Texts;

public class ParticleScreen extends SimpleGui {

    // Add options to change name, chat message and pronoun colors
    public ParticleScreen(ServerPlayerEntity player) {
        super(ScreenHandlerType.GENERIC_9X6, player, false);
        this.setTitle(Texts.PARTICLE_TITLE);
        this.setLockPlayerInventory(true);
    }
    
}
