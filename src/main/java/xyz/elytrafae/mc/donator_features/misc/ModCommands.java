package xyz.elytrafae.mc.donator_features.misc;

import eu.pb4.placeholders.api.PlaceholderContext;
import eu.pb4.placeholders.api.Placeholders;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.argument.TextArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import xyz.elytrafae.mc.donator_features.gui.CosmeticsScreen;

import static net.minecraft.server.command.CommandManager.*;

public class ModCommands {
    
    public static void registerAll() {
        
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal("cosmetics")
			.executes(context -> {
				ServerPlayerEntity player = context.getSource().getPlayer();
				if (player == null) {
					context.getSource().sendError(Text.literal("This command MUST be called by a player!"));
					return 0;
				}
				CosmeticsScreen screen = new CosmeticsScreen(player);
				screen.open();
				return 1;
			}
		)));

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(
        literal("testplaceholder").then(CommandManager.argument("message", TextArgumentType.text())
        .executes(context -> {
            ServerCommandSource source = context.getSource();
            Text stringMessage = TextArgumentType.getTextArgument(context, "message");
            source.sendFeedback(Placeholders.parseText(stringMessage, PlaceholderContext.of(source)), false);
            return 0;
            }
        ))));
    }

}
