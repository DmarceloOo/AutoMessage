package me.marcelooo.automessage.commands;

import me.marcelooo.automessage.AutoMessage;
import me.marcelooo.automessage.config.Config;
import me.marcelooo.automessage.tasks.BroadcastTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class MessageCommand implements CommandExecutor {

    public String color(String string) {
            return ChatColor.translateAlternateColorCodes('&', string);
        }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            Bukkit.getScheduler().cancelTask(AutoMessage.task);
            Config.load();
            AutoMessage.task = Bukkit.getScheduler().scheduleAsyncRepeatingTask((Plugin)AutoMessage.getInst(), (Runnable)new BroadcastTask(), 20L, (Config.getDelay().intValue() * 20));
            sender.sendMessage("# Config has been reloaded.");
            return false;
        }
        Player p = (Player)sender;
        if (!p.hasPermission("automsg.admin")) {
            p.sendMessage(color("&8[&r&lAM&8] » &4Error! &cYou don't have the permission to use this command. &7(automsg.admin)"));
            return false;
        }
        Bukkit.getScheduler().cancelTask(AutoMessage.task);
        Config.load();
        AutoMessage.task = Bukkit.getScheduler().scheduleAsyncRepeatingTask((Plugin)AutoMessage.getInst(), (Runnable)new BroadcastTask(), 20L, (Config.getDelay().intValue() * 20));
        p.sendMessage(color("&8[&r&lAM&8] » &aConfig has been reloaded!"));
        return true;
    }
}
