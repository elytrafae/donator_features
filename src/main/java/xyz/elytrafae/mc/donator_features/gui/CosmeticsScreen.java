package xyz.elytrafae.mc.donator_features.gui;

import java.util.HashMap;
import java.util.function.Function;

import eu.pb4.placeholders.api.PlaceholderContext;
import eu.pb4.placeholders.api.Placeholders;
import eu.pb4.placeholders.api.node.TextNode;
import eu.pb4.sgui.api.ClickType;
import eu.pb4.sgui.api.elements.AnimatedGuiElementBuilder;
import eu.pb4.sgui.api.elements.GuiElementInterface;
import eu.pb4.sgui.api.gui.SimpleGui;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.text.TextContent;
import net.minecraft.util.Formatting;
import xyz.elytrafae.mc.donator_features.Texts;

public class CosmeticsScreen extends SimpleGui {

    private static final int INTERVAL = 15;
    private static final HashMap<Integer, ClickEvent> clickEvents = new HashMap<>();

    private static final AnimatedGuiElementBuilder builder1 = new AnimatedGuiElementBuilder()
        .setInterval(INTERVAL)
        .setItem(Items.PURPLE_STAINED_GLASS_PANE)
        .setName(Text.of(""))
        .saveItemStack()
        .setItem(Items.MAGENTA_STAINED_GLASS_PANE)
        .setName(Text.of(""))
        .saveItemStack();

    private static final AnimatedGuiElementBuilder builder2 = new AnimatedGuiElementBuilder()
        .setInterval(INTERVAL)
        .setItem(Items.MAGENTA_STAINED_GLASS_PANE)
        .setName(Text.of(""))
        .saveItemStack()
        .setItem(Items.PURPLE_STAINED_GLASS_PANE)
        .setName(Text.of(""))
        .saveItemStack();


    // TODO: Consider making this dynamic
    private static final int decorationSlots[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 17, 26, 25, 24, 23, 22, 21, 20, 19, 18, 9};

    public CosmeticsScreen(ServerPlayerEntity player) {
        super(ScreenHandlerType.GENERIC_9X3, player, false);
        this.setTitle(Texts.MAIN_TITLE);
        this.setLockPlayerInventory(true);
        for (int i=0; i < decorationSlots.length; i++) {
            this.setSlot(decorationSlots[i], (i%2==0 ? builder1 : builder2).build());
        }

        this.setMenuOption(10, Texts.TEXT_COLOR_TITLE, Items.NAME_TAG, (type, action, element) -> {
            ChangeNameColorScreen screen = new ChangeNameColorScreen(player);
            this.close();
            screen.open();
            return false;
        });

        this.setMenuOption(11, Texts.CAPE_TITLE, Items.RED_BANNER, (type, action, element) -> {
            CapeScreen screen = new CapeScreen(player);
            this.close();
            screen.open();
            return false;
        });

        this.setMenuOption(12, Texts.PARTICLE_TITLE, Items.BLAZE_POWDER, (type, action, element) -> {
            ParticleScreen screen = new ParticleScreen(player);
            this.close();
            screen.open();
            return false;
        });
    }

    @Override
    public boolean onClick(int index, ClickType type, SlotActionType action, GuiElementInterface element) {
        ClickEvent event = clickEvents.get(index);
        if (event != null) {
            return event.runEvent(type, action, element);
        }
        return false;
    }

    private void setMenuOption(int index, Text title, Item item, ClickEvent event) {
        ItemStack stack = new ItemStack(item);
        stack.setCustomName(title);
        setSlot(index, stack);
        clickEvents.put(index, event);
    }

    @FunctionalInterface
    public interface ClickEvent {
        abstract boolean runEvent(ClickType type, SlotActionType action, GuiElementInterface element);
    }
    
}
