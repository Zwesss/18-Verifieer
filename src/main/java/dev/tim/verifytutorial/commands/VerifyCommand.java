package dev.tim.verifytutorial.commands;

import dev.tim.verifytutorial.Main;
import dev.tim.verifytutorial.menus.VerifyMenu;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class VerifyCommand implements CommandExecutor {

    private Main main;

    public VerifyCommand(Main main){
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            String uuid = player.getUniqueId().toString();
            FileConfiguration config = main.getConfig();

            if(config.getBoolean(uuid)){
                player.sendMessage(ChatColor.RED + "Je bent al geverifieerd!");
            } else {
                new VerifyMenu(player);
            }

        }

        return true;
    }
}
