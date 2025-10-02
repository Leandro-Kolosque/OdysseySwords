package com.odysseyswords.customswordmod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class MythicForgeScreen extends AbstractContainerScreen<MythicForgeMenu> {
    // USANDO A TEXTURA DA BIGORNA VANILLA
    private static final ResourceLocation TEXTURE =
            new ResourceLocation("textures/gui/container/anvil.png");

    public MythicForgeScreen(MythicForgeMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void init() {
        super.init();
        // Título centralizado como na bigorna
        this.titleLabelX = 60;
        this.titleLabelY = 18;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;

        // Desenha a GUI da bigorna
        guiGraphics.blit(TEXTURE, x, y, 0, 0, this.imageWidth, this.imageHeight);

        // BARRA DE PROGRESSO PERSONALIZADA
        if (menu.getProgress() > 0) {
            int progressWidth = (int)(24 * ((float)menu.getProgress() / menu.getMaxProgress()));
            // Posição entre os slots de entrada e saída
            guiGraphics.fill(x + 103, y + 48, x + 103 + progressWidth, y + 48 + 5, 0xFFFF4500);
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }
}