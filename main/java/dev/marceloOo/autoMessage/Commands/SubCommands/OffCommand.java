package dev.marceloOo.autoMessage.Commands.SubCommands;

import java.util.List;
import dev.marceloOo.autoMessage.AutoMessage;
import dev.marceloOo.autoMessage.Utils.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class OffCommand extends SubCommand {
	public String color(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}

	public String getName() {
		return "off";
	}

	public String getDescription() {
		return "Turn off broadcasting.";
	}

	public String getSyntax() {
		return "/automessage <off>";
	}

	public void perform(Player p, String[] args) {
		if (!p.hasPermission("automsg.admin"))
			p.sendMessage(color("&8[&r&lAM&8] &4Error! &cYou don't have the permission to use this command. &7(automsg.admin)"));
		Bukkit.getScheduler().cancelTask(AutoMessage.task);
		p.sendMessage(color("&8[&r&lAM&8] &aAutoMessage broadcasting has been turned &c&noff."));
	}

	public List<String> getSubcommandArguments(Player player, String[] args) {
		return null;
	}
}

