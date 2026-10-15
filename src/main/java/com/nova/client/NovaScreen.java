
package com.nova.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class NovaScreen extends Screen {
    public NovaScreen() {
        super(Text.literal("NOVA Client"));
    }

    @Override
    protected void init() {
        int centerX = this.width / 2;
        int centerY = this.height / 2;

        addDrawableChild(ButtonWidget.builder(
            Text.literal("Coordinates HUD"),
            button -> {
                if (this.client != null && this.client.player != null) {
                    this.client.player.sendMessage(
                        Text.literal("NOVA: Coordinates HUD dipilih"),
                        false
                    );
                }
            }
        ).dimensions(centerX - 95, centerY - 30, 190, 20).build());

        addDrawableChild(ButtonWidget.builder(
            Text.literal("Waypoint Manager"),
            button -> {
                if (this.client != null && this.client.player != null) {
                    this.client.player.sendMessage(
                        Text.literal("NOVA: Waypoint Manager dipilih"),
                        false
                    );
                }
            }
        ).dimensions(centerX - 95, centerY, 190, 20).build());

        addDrawableChild(ButtonWidget.builder(
            Text.literal("Close"),
            button -> close()
        ).dimensions(centerX - 95, centerY + 35, 190, 20).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY,
                       float delta) {
        renderBackground(context, mouseX, mouseY, delta);

        int left = this.width / 2 - 115;
        int top = this.height / 2 - 80;

        context.fill(left, top, left + 230, top + 175, 0xF0141414);
        context.drawBorder(left, top, 230, 175, 0xFF666666);
        context.drawText(
            this.textRenderer,
            "N O V A  CLIENT",
            left + 12,
            top + 12,
            0xFFFFFFFF,
            false
        );

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
