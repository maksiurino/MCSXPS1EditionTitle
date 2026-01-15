package net.maksiuhrino.mcsxps1editiontitle.registry.block.types;

import com.mojang.serialization.MapCodec;
import net.maksiuhrino.mcsxps1editiontitle.registry.block.types.enums.SpinType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class GearBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<GearBlock> CODEC = simpleCodec(GearBlock::new);
    public static final EnumProperty<SpinType> SPIN_TYPE = EnumProperty.create("spin_type", SpinType.class);
    private static final Map<Direction, VoxelShape> SHAPE = Shapes.rotateHorizontal(
            Shapes.box(0, 0, 0.9375, 1, 1, 1)
    );

    public GearBlock(Properties properties) {
        super(properties);
        registerDefaultState(
                defaultBlockState()
                        .setValue(FACING, Direction.NORTH)
                        .setValue(SPIN_TYPE, SpinType.CLOCKWISE)
        );
    }

    @Override
    @NotNull
    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE.get(blockState.getValue(FACING));
    }

    @Override
    @NotNull
    public MapCodec<GearBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, SPIN_TYPE);
    }

    private boolean hasSupport(Level level, BlockPos pos, Direction facing) {
        BlockPos supportPos = pos.relative(facing.getOpposite());
        BlockState support = level.getBlockState(supportPos);

        return support.isFaceSturdy(
                level,
                supportPos,
                facing
        );
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, @Nullable Orientation orientation, boolean isMoving) {

        Direction facing = state.getValue(FACING);

        if (!hasSupport(level, pos, facing)) {
            level.destroyBlock(pos, true);
        }
    }

    private SpinType invert(SpinType type) {
        return type == SpinType.CLOCKWISE
                ? SpinType.COUNTER_CLOCKWISE
                : SpinType.CLOCKWISE;
    }

    private SpinType getSpinType(Level level, BlockPos pos, BlockState state) {
        Direction facing = state.getValue(FACING);

        Direction[] checkDirs = switch (facing) {
            case NORTH, SOUTH -> new Direction[]{Direction.EAST, Direction.WEST};
            case EAST, WEST -> new Direction[]{Direction.NORTH, Direction.SOUTH};
            default -> new Direction[0];
        };

        for (Direction dir : checkDirs) {
            BlockPos neighborPos = pos.relative(dir);
            BlockState neighbor = level.getBlockState(neighborPos);

            if (neighbor.is(this)) {
                return invert(neighbor.getValue(SPIN_TYPE));
            }
        }

        return SpinType.CLOCKWISE;
    }


    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Level level = blockPlaceContext.getLevel();
        BlockPos pos = blockPlaceContext.getClickedPos();
        Direction facing = blockPlaceContext.getHorizontalDirection().getOpposite();

        if (!hasSupport(level, pos, facing)) {
            return null;
        }

        BlockState blockState = defaultBlockState()
                .setValue(FACING, facing);

        return blockState
                .setValue(SPIN_TYPE, getSpinType(blockPlaceContext.getLevel(), pos, blockState));
    }
}
