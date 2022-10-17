package dev.tim.verifytutorial.listeners;

import dev.tim.verifytutorial.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class VerifyMenuListener implements Listener {

    private Main main;

    public VerifyMenuListener(Main main){
        this.main = main;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        FileConfiguration config = main.getConfig();
        Player player = (Player) e.getWhoClicked();
        String uuid = player.getUniqueId().toString();

        if(e.getView().getTitle().equals("Klik op de rode knoppen") && e.getCurrentItem() != null){
            e.setCancelled(true);

            ItemStack item = e.getCurrentItem();
            ItemMeta itemMeta = item.getItemMeta();

            if(item.getType().equals(Material.RED_STAINED_GLASS_PANE)){
                item.setType(Material.LIME_STAINED_GLASS_PANE);
                itemMeta.setDisplayName(ChatColor.GREEN  + "Nice!");
                item.setItemMeta(itemMeta);

                if(!e.getInventory().contains(Material.RED_STAINED_GLASS_PANE)){
                    config.set(uuid, true);
                    main.saveConfig();
                    player.closeInventory();
                    player.sendMessage(ChatColor.GREEN + "Geverifieerd!");
                }
            }

        }
    }
}
