package net.maksiuhrino.mcsxps1editiontitle.mixin;

import com.terraformersmc.modmenu.ModMenu;
import me.shedaniel.autoconfig.AutoConfig;
import net.maksiuhrino.mcsxps1editiontitle.compat.modmenu.config.MCSXPS1EditionTitleConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class MixinTitleScreen {
    @Unique
    private Minecraft minecraft = Minecraft.getInstance();

    @Inject(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/screens/TitleScreen;renderPanorama(Lnet/minecraft/client/gui/GuiGraphics;F)V",
                    shift = At.Shift.AFTER
            )
    )
    private void mcsxps1editiontitle$blurPanorama(
            GuiGraphics guiGraphics,
            int mouseX,
            int mouseY,
            float delta,
            CallbackInfo ci
    ) {
        MCSXPS1EditionTitleConfig config = AutoConfig.getConfigHolder(MCSXPS1EditionTitleConfig.class).getConfig();
        if (config.blurBackground) {
            Minecraft.getInstance().gameRenderer.processBlurEffect();
        }
    }

    @ModifyConstant(
            method = "init",
            constant = @Constant(
                    intValue = 2,
                    ordinal = 1
            )
    )
    private int mcsxps1editiontitle$modifyButtonXPosition(int original) {
        assert this.minecraft.screen != null;
        return this.minecraft.screen.width;
    }

    @ModifyConstant(
            method = "init",
            constant = @Constant(
                    intValue = 124
            )
    )
    private int mcsxps1editiontitle$modifyButtonXPosition2(int original) {
        return -2;
    }

    @ModifyConstant(
            method = "init",
            constant = @Constant(
                    intValue = 2,
                    ordinal = 2
            )
    )
    private int mcsxps1editiontitle$modifyButtonXPosition3(int original) {
        assert this.minecraft.screen != null;
        return this.minecraft.screen.width;
    }

    @ModifyConstant(
            method = "init",
            constant = @Constant(
                    intValue = 100
            )
    )
    private int mcsxps1editiontitle$modifyButtonXPosition4(int original) {
        return -26;
    }

    @ModifyConstant(
            method = "init",
            constant = @Constant(
                    intValue = 2,
                    ordinal = 3
            )
    )
    private int mcsxps1editiontitle$modifyButtonXPosition5(int original) {
        assert this.minecraft.screen != null;
        return this.minecraft.screen.width;
    }

    @ModifyConstant(
            method = "init",
            constant = @Constant(
                    intValue = 2,
                    ordinal = 4
            )
    )
    private int mcsxps1editiontitle$modifyButtonXPosition6(int original) {
        return 128;
    }

    @ModifyConstant(
            method = "init",
            constant = @Constant(
                    intValue = 2,
                    ordinal = 5
            )
    )
    private int mcsxps1editiontitle$modifyButtonXPosition7(int original) {
        assert this.minecraft.screen != null;
        return this.minecraft.screen.width;
    }

    @ModifyConstant(
            method = "init",
            constant = @Constant(
                    intValue = 104,
                    ordinal = 0
            )
    )
    private int mcsxps1editiontitle$modifyButtonXPosition8(int original) {
        return 230;
    }

    @ModifyConstant(
            method = "createNormalMenuOptions",
            constant = @Constant(
                    intValue = 2
            )
    )
    private int mcsxps1editiontitle$modifyButtonXPosition9(int original) {
        assert this.minecraft.screen != null;
        return this.minecraft.screen.width;
    }

    @ModifyConstant(
            method = "createNormalMenuOptions",
            constant = @Constant(
                    intValue = 100
            )
    )
    private int mcsxps1editiontitle$modifyButtonXPosition10(int original) {
        return -26;
    }
}
