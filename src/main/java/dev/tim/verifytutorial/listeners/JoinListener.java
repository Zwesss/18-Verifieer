package dev.tim.verifytutorial.listeners;

import dev.tim.verifytutorial.Main;
import dev.tim.verifytutorial.menus.VerifyMenu;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private Main main;

    public JoinListener(Main main){
        this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        String uuid = player.getUniqueId().toString();
        FileConfiguration config = main.getConfig();

        if(!config.contains(uuid)){
            config.set(uuid, false);
            main.saveConfig();
            new VerifyMenu(player);
            return;
        }

        if(!config.getBoolean(uuid)){
            new VerifyMenu(player);
        }

    }
}
