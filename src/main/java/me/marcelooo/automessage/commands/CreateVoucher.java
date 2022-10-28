package me.marcelooo.automessage.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CreateVoucher implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            {
                Inventory inv = player.getInventory();
                int firstEmpty = inv.firstEmpty();
                if (firstEmpty == -1) {
                    sender.sendMessage("Inventory full");
                } else {
                    ItemStack voucher = new ItemStack(Material.PAPER);
                    ItemMeta meta = voucher.getItemMeta();

                    meta.setDisplayName(ChatColor.RED + "Rank Voucher");
                    meta.setLore(Arrays.asList(ChatColor.DARK_GRAY + "Rank: " + ChatColor.GREEN + "VIP"));

                    voucher.setItemMeta(meta);

                    inv.setItem(firstEmpty, voucher);
                    player.sendMessage("Bank note received");
                }
            }
        }
        return true;
    }
}
