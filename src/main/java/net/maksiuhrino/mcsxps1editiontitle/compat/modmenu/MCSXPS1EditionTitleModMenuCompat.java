package net.maksiuhrino.mcsxps1editiontitle.compat.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.maksiuhrino.mcsxps1editiontitle.compat.modmenu.config.MCSXPS1EditionTitleConfig;

@Environment(EnvType.CLIENT)
public class MCSXPS1EditionTitleModMenuCompat implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> AutoConfig.getConfigScreen(MCSXPS1EditionTitleConfig.class, parent).get();
    }
}
