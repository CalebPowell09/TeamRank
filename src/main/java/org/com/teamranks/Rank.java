package org.com.teamranks;

import org.bukkit.ChatColor;

public enum Rank {

    OWNER(ChatColor.GOLD + "Owner"),
    FILLER(ChatColor.RED + "filler"),
    FILLER1(ChatColor.GREEN + "filler"),
    MEMBER(ChatColor.AQUA + "Member");

    private String display;

    Rank(String display){
        this.display = display;
    }

    public String getDisplay() {return display;}
}
