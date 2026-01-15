package net.maksiuhrino.mcsxps1editiontitle.registry.block.types.enums;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum SpinType implements StringRepresentable {
    CLOCKWISE("clockwise"),
    COUNTER_CLOCKWISE("counter_clockwise");

    private final String name;

    private SpinType(final String string2) {
        this.name = string2;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public @NotNull String getSerializedName() {
        return this.name;
    }
}
