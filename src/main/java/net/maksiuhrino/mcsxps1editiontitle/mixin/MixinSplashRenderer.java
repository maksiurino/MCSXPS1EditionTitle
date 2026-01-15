package net.maksiuhrino.mcsxps1editiontitle.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.SplashRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(SplashRenderer.class)
public class MixinSplashRenderer {
    @Unique
    private Minecraft minecraft = Minecraft.getInstance();

    @ModifyConstant(
            method = "render",
            constant = @Constant(
                    floatValue = 2.0F
            )
    )
    private float changeXValue(float orig) {
        assert this.minecraft.screen != null;
        return (float) (this.minecraft.screen.width);
    }

    @ModifyConstant(
            method = "render",
            constant = @Constant(
                    floatValue = 123.0F
            )
    )
    private float changeXValue1(float orig) {
        return orig * 1.95F;
    }
}
