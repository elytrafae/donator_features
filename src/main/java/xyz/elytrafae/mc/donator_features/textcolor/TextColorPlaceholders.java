package xyz.elytrafae.mc.donator_features.textcolor;

import eu.pb4.placeholders.api.PlaceholderResult;
import eu.pb4.placeholders.api.Placeholders;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.util.Formatting;
import xyz.elytrafae.mc.donator_features.DonatorFeatures;

public class TextColorPlaceholders {
    
    public static void register() {
        Placeholders.register(DonatorFeatures.id("colored_name"), (ctx, arg) -> {
			if (!ctx.hasPlayer()) {
				return PlaceholderResult.invalid("No player!");
			}
			ServerPlayerEntity player = ctx.player();
			if (player == null) {
				return PlaceholderResult.invalid("No player!");
			}
            Style style = Style.EMPTY.withColor(Formatting.RED);
			return PlaceholderResult.value(player.getDisplayName().getWithStyle(style).get(0));
		});
    }

}
