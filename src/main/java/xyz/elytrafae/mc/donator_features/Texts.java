package xyz.elytrafae.mc.donator_features;

import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextContent;
import net.minecraft.util.Formatting;

public class Texts {
    
    public static final MutableText MAIN_TITLE = getMainTitle();
    public static final Text TEXT_COLOR_TITLE = Text.of("Change Text Colors").getWithStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE)).get(0);
    public static final Text CAPE_TITLE = Text.of("Change Cape").getWithStyle(Style.EMPTY.withColor(Formatting.RED)).get(0);
    public static final Text PARTICLE_TITLE = Text.of("Change Particles").getWithStyle(Style.EMPTY.withColor(Formatting.GOLD)).get(0);

    private static MutableText getMainTitle() {
        MutableText text = MutableText.of(TextContent.EMPTY);
        text.append(Text.of("Donators' ").getWithStyle(Style.EMPTY.withColor(Formatting.GOLD)).get(0));
        text.append(Text.of("Cosmetics Menu").getWithStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE)).get(0));
        return text;
    }

}
