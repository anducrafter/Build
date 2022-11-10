package ch.andu.build;

import ch.andu.build.Lisstener.BuildLisstener;
import ch.andu.build.commands.BuildCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Build extends JavaPlugin {

    public static HashMap onbuild = new HashMap();
    public static String prefix  ="§8[§eTeam§8]";
    @Override
    public void onEnable() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new BuildLisstener(),this);
        getCommand("build").setExecutor(new BuildCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
