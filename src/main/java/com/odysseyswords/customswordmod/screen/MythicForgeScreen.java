package com.odysseyswords.customswordmod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class MythicForgeScreen extends AbstractContainerScreen<MythicForgeMenu> {
    // TEXTURA VANILLA DA SMITHING TABLE - JÁ EXISTE NO MINECRAFT
    private static final ResourceLocation TEXTURE =
            new ResourceLocation("textures/gui/container/anvil.png");

    public MythicForgeScreen(MythicForgeMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void init() {
        super.init();
        this.titleLabelX = 44;
        this.titleLabelY = 14;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;

        // Desenha a GUI completa da Smithing Table
        guiGraphics.blit(TEXTURE, x, y, 0, 0, this.imageWidth, this.imageHeight);

        // Barra de progresso personalizada
        if (menu.getProgress() > 0) {
            int progressWidth = (int)(22 * ((float)menu.getProgress() / menu.getMaxProgress()));
            guiGraphics.blit(TEXTURE, x + 102, y + 48, 176, 0, progressWidth, 16);
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }
}