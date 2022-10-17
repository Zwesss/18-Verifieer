package dev.tim.verifytutorial.listeners;

import dev.tim.verifytutorial.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayListeners implements Listener {

    private Main main;

    public PlayListeners(Main main){
        this.main = main;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        FileConfiguration config = main.getConfig();
        Player player = e.getPlayer();
        String uuid = player.getUniqueId().toString();

        if(!config.getBoolean(uuid)){
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "Verifieer jezelf om te kunnen bewegen op deze server!" + ChatColor.YELLOW + "(/verify)");
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        FileConfiguration config = main.getConfig();
        Player player = e.getPlayer();
        String uuid = player.getUniqueId().toString();

        if(!config.getBoolean(uuid)){
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "Verifieer jezelf om te kunnen praten in deze server!" + ChatColor.YELLOW + "(/verify)");
        }
    }

}
