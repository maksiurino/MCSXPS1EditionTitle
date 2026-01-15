package net.maksiuhrino.mcsxps1editiontitle.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.gui.screens.options.controls.ControlsScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ControlsScreen.class)
public abstract class MixinControlsScreen {
    @ModifyReturnValue(method = "options", at = @At("RETURN"))
    private static OptionInstance<?>[] removeOpBlocksSettingButton(OptionInstance<?>[] original) {
        OptionInstance<?>[] newOptions = new OptionInstance[original.length - 1];
        System.arraycopy(original, 0, newOptions, 0, newOptions.length);
        return newOptions;
    }
}
