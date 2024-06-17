package org.com.teamranks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.com.teamranks.manager.NametagManager;
import org.com.teamranks.manager.RankManager;
import org.com.teamranks.messagingsystem.MessageCommand;
import org.com.teamranks.messagingsystem.ReplyCommand;

import java.util.HashMap;
import java.util.UUID;

public final class Main extends JavaPlugin implements Listener {

    private RankManager rankManager;

    private NametagManager nametagManager;

    private HashMap<UUID, UUID> recentMessages;

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println(ChatColor.AQUA + "Ranks Enabled");

        getCommand("rank").setExecutor(new RankCommand(this));

        getCommand("msg").setExecutor(new MessageCommand(this));

        getCommand("reply").setExecutor(new ReplyCommand(this));

        recentMessages = new HashMap<>();

        rankManager = new RankManager(this);

        nametagManager = new NametagManager(this);

        Bukkit.getPluginManager().registerEvents(new RankListener(this), this);

        Bukkit.getPluginManager().registerEvents(this,this);

    }

    public RankManager getRankManager() {return rankManager;}
    public NametagManager getNametagManager() {return nametagManager;}
    public HashMap<UUID, UUID> getRecentMessages(){return recentMessages;}

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        recentMessages.remove(e.getPlayer().getUniqueId());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(ChatColor.DARK_RED + "Ranks Disabled");
    }
}
