package dev.marceloOo.autoMessage.Commands.SubCommands;

import java.util.List;
import dev.marceloOo.autoMessage.AutoMessage;
import dev.marceloOo.autoMessage.Config.Config;
import dev.marceloOo.autoMessage.Tasks.BroadcastTask;
import dev.marceloOo.autoMessage.Utils.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class OnCommand extends SubCommand {
	public String color(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}

	public String getName() {
		return "on";
	}

	public String getDescription() {
		return "Turn on broadcasting.";
	}

	public String getSyntax() {
		return "/automessage <on>";
	}

	public void perform(Player p, String[] args) {
		if (!p.hasPermission("automsg.admin"))
			p.sendMessage(color("&8[&r&lAM&8] &4Error! &cYou don't have the permission to use this command. &7(automsg.admin)"));
		AutoMessage.task = Bukkit.getScheduler().scheduleAsyncRepeatingTask((Plugin)AutoMessage.getInst(), (Runnable)new BroadcastTask(), 20L, (Config.getDelay().intValue() * 20));
		p.sendMessage(color("&8[&r&lAM&8] &aAutoMessage broadcasting has been turned &non."));
	}

	public List<String> getSubcommandArguments(Player player, String[] args) {
		return null;
	}
}
