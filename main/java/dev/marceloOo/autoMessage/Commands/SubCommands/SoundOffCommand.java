package dev.marceloOo.autoMessage.Commands.SubCommands;

import java.util.List;
import dev.marceloOo.autoMessage.AutoMessage;
import dev.marceloOo.autoMessage.Config.Config;
import dev.marceloOo.autoMessage.Utils.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class SoundOffCommand extends SubCommand {
	private final AutoMessage plugin;

	public SoundOffCommand(AutoMessage plugin) {
		this.plugin = plugin;
	}

	public String color(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}

	public String getName() {
		return "soundoff";
	}

	public String getDescription() {
		return "Turn off the sound when a message is being broadcasted.";
	}

	public String getSyntax() {
		return "/automessage <soundoff>";
	}

	public void perform(Player p, String[] args) {
		if (!p.hasPermission("automsg.admin"))
			p.sendMessage(color("&8[&r&lAM&8] &4Error! &cYou don't have the permission to use this command. &7(automsg.admin)"));
		this.plugin.getConfig().set("messageSound", Boolean.valueOf(false));
		this.plugin.saveConfig();
		Config.load();
		p.sendMessage(color("&8[&r&lAM&8] &8&aMessage sound has been turned &c&noff"));
	}

	public List<String> getSubcommandArguments(Player player, String[] args) {
		return null;
	}
}
