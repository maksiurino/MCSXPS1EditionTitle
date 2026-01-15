package net.maksiuhrino.mcsxps1editiontitle.mixin.modmenu;

import com.terraformersmc.modmenu.gui.widget.ModMenuButtonWidget;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ModMenuButtonWidget.class)
public class MixinModMenuButtonWidget {
    @Inject(method = "<init>", at = @At("TAIL"))
    private void changeWidth(int x, int y, int width, int height, Component text, Screen screen, CallbackInfo ci) {
        ModMenuButtonWidget widget = ((ModMenuButtonWidget) (Object) this);
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.screen != null) {
            if (minecraft.screen instanceof TitleScreen) {
                widget.setX(26);
            }
        }
    }
}
