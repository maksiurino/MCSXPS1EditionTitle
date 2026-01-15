package net.maksiuhrino.mcsxps1editiontitle.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.LogoRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(LogoRenderer.class)
public class MixinLogoRenderer {
    @Unique
    private Minecraft minecraft = Minecraft.getInstance();

    @ModifyConstant(
            method = "renderLogo(Lnet/minecraft/client/gui/GuiGraphics;IFI)V",
            constant = @Constant(
                    intValue = 2
            )
    )
    private int modifyXValue(int original) {
        assert this.minecraft.screen != null;
        return this.minecraft.screen.width;
    }

    @ModifyConstant(
            method = "renderLogo(Lnet/minecraft/client/gui/GuiGraphics;IFI)V",
            constant = @Constant(
                    intValue = 128,
                    ordinal = 0
            )
    )
    private int modifyXValue1(int original) {
        return 0;
    }

    @ModifyConstant(
            method = "renderLogo(Lnet/minecraft/client/gui/GuiGraphics;IFI)V",
            constant = @Constant(
                    intValue = 64,
                    ordinal = 1
            )
    )
    private int modifyXValue2(int original) {
        return -64;
    }
}
