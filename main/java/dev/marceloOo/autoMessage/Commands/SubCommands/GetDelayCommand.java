package dev.marceloOo.autoMessage.Commands.SubCommands;

import java.util.List;
import dev.marceloOo.autoMessage.Config.Config;
import dev.marceloOo.autoMessage.Utils.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class GetDelayCommand extends SubCommand {
	public String color(String string) {
		return ChatColor.translateAlternateColorCodes('&', string).replace(">>", "»");
	}

	public String getName() {
		return "getdelay";
	}

	public String getDescription() {
		return "Find out the current delay set for the messages.";
	}

	public String getSyntax() {
		return "/automessage <getdelay>";
	}

	public void perform(Player player, String[] args) {
		if (!player.hasPermission("automsg.admin"))
			player.sendMessage("&8[&r&lAM&8] &4Error! &cYou don't have the permission to use this command. &7(automsg.admin)");
		player.sendMessage(color("&8[&r&lAM&8] &aThe current delay set is: &r" + Config.getDelay()));
	}

	public List<String> getSubcommandArguments(Player player, String[] args) {
		return null;
	}
}
