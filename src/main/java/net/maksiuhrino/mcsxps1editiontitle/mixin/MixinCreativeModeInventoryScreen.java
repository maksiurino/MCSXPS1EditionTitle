package net.maksiuhrino.mcsxps1editiontitle.mixin;

import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CreativeModeInventoryScreen.class)
public class MixinCreativeModeInventoryScreen {
    @Inject(method = "hasPermissions", at = @At("HEAD"), cancellable = true)
    private void alwaysHideOpBlocksTab(Player player, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
