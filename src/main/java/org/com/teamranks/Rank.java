package org.com.teamranks;

import org.bukkit.ChatColor;

public enum Rank {

    OWNER(ChatColor.RED + "Owner"),
    DEVELOPER(ChatColor.GOLD + "Developer"),
    GRINDER(ChatColor.GREEN + "Grinder"),
    MEMBER(ChatColor.AQUA + "Member");

    private String display;

    Rank(String display){
        this.display = display;
    }

    public String getDisplay() {return display;}
}
