package org.com.teamranks;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println(ChatColor.AQUA + "Ranks Enabled");
        getCommand("rank").setExecutor(new RankCommand());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(ChatColor.DARK_RED + "Ranks Disabled");
    }
}
