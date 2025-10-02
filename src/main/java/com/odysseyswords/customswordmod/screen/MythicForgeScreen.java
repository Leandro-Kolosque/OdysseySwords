package com.odysseyswords.customswordmod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class MythicForgeScreen extends AbstractContainerScreen<MythicForgeMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation("textures/gui/container/smithing.png");

    public MythicForgeScreen(MythicForgeMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void init() {
        super.init();
        // Posição do título igual à Smithing Table vanilla
        this.titleLabelX = 60;
        this.titleLabelY = 6;
        // Posição do inventário do jogador
        this.inventoryLabelX = 8;
        this.inventoryLabelY = 75;
    }

 @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;

        // Renderiza a textura de fundo
        guiGraphics.blit(TEXTURE, x, y, 0, 0, this.imageWidth, this.imageHeight);

        // ANIMAÇÃO DA SETA CORRIGIDA - Posição exata da vanilla
        if (menu.getProgress() > 0) {
            int progress = this.menu.getProgress();
            int maxProgress = this.menu.getMaxProgress();
            
            if (maxProgress > 0) {
                // A seta na Smithing Table vanilla tem 22 pixels de largura máxima
                int progressWidth = (int)(22.0F * ((float)progress / (float)maxProgress));
                
                // COORDENADAS EXATAS DA SETA NA SMITHING TABLE VANILLA:
                // x: 62 (entre o slot 2 em 44 e slot 3 em 98)
                // y: 49 (ligeiramente abaixo dos slots que estão em y: 48)
                guiGraphics.blit(TEXTURE, 
                    x + 62,              // Posição X corrigida
                    y + 49,              // Posição Y corrigida (1 pixel abaixo dos slots)
                    176,                 // Texture X - início da seta na texture sheet
                    0,                   // Texture Y
                    progressWidth,       // Largura baseada no progresso
                    16                   // Altura
                );
            }
        }
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 0x404040, false);
        guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 0x404040, false);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }
}