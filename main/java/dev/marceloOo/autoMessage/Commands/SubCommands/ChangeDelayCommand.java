package dev.marceloOo.autoMessage.Commands.SubCommands;

import java.util.List;
import dev.marceloOo.autoMessage.AutoMessage;
import dev.marceloOo.autoMessage.Utils.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChangeDelayCommand extends SubCommand {
	private final AutoMessage plugin;

	public String color(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}

	public ChangeDelayCommand(AutoMessage plugin) {
		this.plugin = plugin;
	}

	public String getName() {
		return "changedelay";
	}

	public String getDescription() {
		return "Change the delay speed of the messages being sent.";
	}

	public String getSyntax() {
		return "/automessage <changedelay> <seconds>";
	}

	public void perform(Player player, String[] args) {
		if (!player.hasPermission("automsg.admin"))
			player.sendMessage(color("&8[&r&lAM&8] &4Error! &cYou don't have the permission to use this command. &7(automsg.admin)"));
		int integer = Integer.parseInt(args[1]);
		this.plugin.getConfig().set("settings.delay", Integer.valueOf(integer));
		this.plugin.saveConfig();
		player.sendMessage(color("&8[&r&lAM&8] &aChanged the delay to: &r" + integer));
		player.sendMessage(color("&8[&r&lAM&8] &7You will need to reload the config yourself."));
	}

	public List<String> getSubcommandArguments(Player player, String[] args) {
		return null;
	}
}
