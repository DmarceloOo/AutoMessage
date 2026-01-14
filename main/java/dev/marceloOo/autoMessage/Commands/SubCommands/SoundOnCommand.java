package dev.marceloOo.autoMessage.Commands.SubCommands;

import java.util.List;
import dev.marceloOo.autoMessage.AutoMessage;
import dev.marceloOo.autoMessage.Config.Config;
import dev.marceloOo.autoMessage.Utils.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class SoundOnCommand extends SubCommand {
	private final AutoMessage plugin;

	public SoundOnCommand(AutoMessage plugin) {
		this.plugin = plugin;
	}

	public String color(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}

	public String getName() {
		return "soundon";
	}

	public String getDescription() {
		return "Turn on the sound when a message is being broadcasted.";
	}

	public String getSyntax() {
		return "/automessage <soundon>";
	}

	public void perform(Player p, String[] args) {
		if (!p.hasPermission("automsg.admin"))
			p.sendMessage(color("&8[&r&lAM&8] &4Error! &cYou don't have the permission to use this command. &7(automsg.admin)"));
		this.plugin.getConfig().set("messageSound", Boolean.valueOf(true));
		this.plugin.saveConfig();
		Config.load();
		p.sendMessage(color("&8[&r&lAM&8] &8&aMessage sound has been turned &a&non"));
	}

	public List<String> getSubcommandArguments(Player player, String[] args) {
		return null;
	}
}