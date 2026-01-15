package net.maksiuhrino.mcsxps1editiontitle.registry.block.types;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlaceableFluidBlock extends Block {
    public static final MapCodec<PlaceableFluidBlock> CODEC = simpleCodec(properties -> new PlaceableFluidBlock(null, properties));
    private final BlockState fluid;

    public PlaceableFluidBlock(BlockState fluid, Properties properties) {
        super(properties);
        this.fluid = fluid;
    }

    @NotNull
    @Override
    public MapCodec<PlaceableFluidBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.fluid;
    }
}
