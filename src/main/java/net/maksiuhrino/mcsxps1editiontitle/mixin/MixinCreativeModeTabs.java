package net.maksiuhrino.mcsxps1editiontitle.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.maksiuhrino.mcsxps1editiontitle.registry.tabs.MCSXPS1EditionTitleTabs;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;

@Mixin(CreativeModeTabs.class)
public class MixinCreativeModeTabs {
    @ModifyExpressionValue(
            method = "getDefaultTab",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/world/item/CreativeModeTabs;BUILDING_BLOCKS:Lnet/minecraft/resources/ResourceKey;",
                    opcode = Opcodes.GETSTATIC
            )
    )
    private static ResourceKey<CreativeModeTab> changeDefaultTab(ResourceKey<CreativeModeTab> original) {
        return MCSXPS1EditionTitleTabs.MAIN_GROUP;
    }

    @WrapOperation(
            method = "bootstrap",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/core/Registry;register(Lnet/minecraft/core/Registry;Lnet/minecraft/resources/ResourceKey;Ljava/lang/Object;)Ljava/lang/Object;"
            )
    )
    private static Object removeOtherTabs(Registry<?> registry, ResourceKey<?> resourceKey, Object object, Operation<?> original) {
        List<ResourceKey<CreativeModeTab>> SAFE_TABS = List.of(
                CreativeModeTabs.HOTBAR,
                CreativeModeTabs.INVENTORY,
                CreativeModeTabs.SEARCH,
                CreativeModeTabs.OP_BLOCKS
        );
        return !SAFE_TABS.contains(resourceKey) ? null : original.call(registry, resourceKey, object);
    }
}
