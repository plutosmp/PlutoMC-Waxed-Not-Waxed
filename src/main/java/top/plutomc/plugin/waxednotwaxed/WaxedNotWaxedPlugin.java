package top.plutomc.plugin.waxednotwaxed;

import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.ApiVersion;
import org.bukkit.plugin.java.annotation.plugin.Description;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.Website;
import org.bukkit.plugin.java.annotation.plugin.author.Author;
import org.bukkit.plugin.java.annotation.plugin.author.Authors;

@Plugin(name = "${name}", version = "${version}") // Don't modify this! Please modify the variables in gradle.properties file!
@ApiVersion(ApiVersion.Target.v1_19)
@Authors({
        @Author("PlutoMC"),
        @Author("DeeChael")
})
@Website("plutomc.top")
@Description("PlutoMC template plugin by DeeChael")
public final class WaxedNotWaxedPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().addPermission(new Permission("plutomc.waxednotwaxed.check", PermissionDefault.TRUE));
        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public void onDisable() {

    }

    public static WaxedNotWaxedPlugin getInstance() {
        return JavaPlugin.getPlugin(WaxedNotWaxedPlugin.class);
    }

}
