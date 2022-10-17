package dev.tim.verifytutorial;

import dev.tim.verifytutorial.commands.VerifyCommand;
import dev.tim.verifytutorial.listeners.JoinListener;
import dev.tim.verifytutorial.listeners.PlayListeners;
import dev.tim.verifytutorial.listeners.VerifyMenuListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults(true);
        saveConfig();

        getServer().getPluginManager().registerEvents(new VerifyMenuListener(this), this);
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayListeners(this), this);

        getCommand("verify").setExecutor(new VerifyCommand(this));

    }
}
