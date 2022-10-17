package dev.tim.verifytutorial.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class VerifyMenu {

    public VerifyMenu(Player player){

        Inventory inv = Bukkit.createInventory(player, 54, "Klik op de rode knoppen");
        int buttonsAmount = 5;

        for(int i = 0; i <= buttonsAmount; i++){
            Random random = new Random();
            int randomSlot = random.nextInt(54);

            ItemStack button = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
            ItemMeta buttonMeta = button.getItemMeta();
            buttonMeta.setDisplayName(ChatColor.RED + "Klik op mij!");
            button.setItemMeta(buttonMeta);

            inv.setItem(randomSlot, button);
        }

        player.openInventory(inv);
    }
}
