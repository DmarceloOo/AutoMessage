package me.marcelooo.automessage.commands.subcommands;

import me.marcelooo.automessage.AutoMessage;
import me.marcelooo.automessage.config.Config;
import me.marcelooo.automessage.tasks.BroadcastTask;
import me.marcelooo.automessage.utils.SubCommand;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class ReloadCommand extends SubCommand {

    public String color(String string) {
            return ChatColor.translateAlternateColorCodes('&', string);
        }

    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public String getDescription() {
        return "Reload the plugin's config.";
    }

    @Override
    public String getSyntax() {
        return "/automessage <reload>";
    }

    @Override
    public void perform(Player p, String[] args) {
        if (!p.hasPermission("automsg.admin")) {
            p.sendMessage(color("&8[&r&lAM&8] » &4Error! &cYou don't have the permission to use this command. &7(automsg.admin)"));
        }
        Bukkit.getScheduler().cancelTask(AutoMessage.task);
        Config.load();
        AutoMessage.task = Bukkit.getScheduler().scheduleAsyncRepeatingTask((Plugin)AutoMessage.getInst(), (Runnable)new BroadcastTask(), 20L, (Config.getDelay().intValue() * 20));
        p.sendMessage(color("&8[&r&lAM&8] » &aConfig has been reloaded!"));
    }

    @Override
    public List<String> getSubcommandArguments(Player player, String[] args) {
        return null;
    }
}
