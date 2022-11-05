package me.marcelooo.automessage.commands.subcommands;

import me.marcelooo.automessage.AutoMessage;
import me.marcelooo.automessage.utils.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class OffCommand extends SubCommand {

    public String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    @Override
    public String getName() {
        return "off";
    }

    @Override
    public String getDescription() {
        return "Turn off broadcasting.";
    }

    @Override
    public String getSyntax() {
        return "/automessage <off>";
    }

    @Override
    public void perform(Player p, String[] args) {

        if (!p.hasPermission("automsg.admin")) {
            p.sendMessage(color("&8[&r&lAM&8] » &4Error! &cYou don't have the permission to use this command. &7(automsg.admin)"));
        }
        Bukkit.getScheduler().cancelTask(AutoMessage.task);
        p.sendMessage(color("&8[&r&lAM&8] » &aAutoMessage broadcasting has been turned &c&noff."));
    }


    @Override
    public List<String> getSubcommandArguments(Player player, String[] args) {
        return null;
    }
}