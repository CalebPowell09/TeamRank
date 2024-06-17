package org.com.teamranks.messagingsystem;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.com.teamranks.Main;

public class MessageCommand implements CommandExecutor {

    private Main main;

    public MessageCommand(Main main){
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;

            if (args.length >= 2){
                if (Bukkit.getPlayerExact(args[0]) != null){
                    Player target = Bukkit.getPlayerExact(args[0]);

                    StringBuilder builder = new StringBuilder();

                    for (int i = 1; i < args.length; i++){
                        builder.append(args[i]).append(" ");

                    }

                    player.sendMessage(ChatColor.GREEN + target.getName() + ": " + builder);
                    target.sendMessage( ChatColor.GREEN + player.getName() + "-> You: " + builder);

                    main.getRecentMessages().put(player.getUniqueId(), target.getUniqueId());
                } else {
                    player.sendMessage(ChatColor.RED + "This player was not found!");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid usage! Use /msg <player> <message>");
            }

        }
        return false;
    }
}
