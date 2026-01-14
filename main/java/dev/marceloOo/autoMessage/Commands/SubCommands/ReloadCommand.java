package dev.marceloOo.autoMessage.Commands.SubCommands;

import java.util.List;
import dev.marceloOo.autoMessage.AutoMessage;
import dev.marceloOo.autoMessage.Config.Config;
import dev.marceloOo.autoMessage.Tasks.BroadcastTask;
import dev.marceloOo.autoMessage.Utils.SubCommand;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ReloadCommand extends SubCommand {
	public String color(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}

	public String getName() {
		return "reload";
	}

	public String getDescription() {
		return "Reload the plugin's config.";
	}

	public String getSyntax() {
		return "/automessage <reload>";
	}

	public void perform(Player p, String[] args) {
		if (!p.hasPermission("automsg.admin"))
			p.sendMessage(color("&8[&r&lAM&8] &4Error! &cYou don't have the permission to use this command. &7(automsg.admin)"));
		Bukkit.getScheduler().cancelTask(AutoMessage.task);
		Config.load();
		AutoMessage.task = Bukkit.getScheduler().scheduleAsyncRepeatingTask((Plugin)AutoMessage.getInst(), (Runnable)new BroadcastTask(), 20L, (Config.getDelay().intValue() * 20));
		p.sendMessage(color("&8[&r&lAM&8] &aConfig has been reloaded!"));
	}

	public List<String> getSubcommandArguments(Player player, String[] args) {
		return null;
	}
}
