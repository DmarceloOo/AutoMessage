package dev.marceloOo.autoMessage.Commands;

import java.util.ArrayList;
import java.util.List;
import dev.marceloOo.autoMessage.AutoMessage;
import dev.marceloOo.autoMessage.Commands.SubCommands.*;
import dev.marceloOo.autoMessage.Utils.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

public class CommandManager implements TabExecutor {
	public String color(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}

	private ArrayList<SubCommand> subcommands = new ArrayList<>();

	public CommandManager() {
		this.subcommands.add(new OnCommand());
		this.subcommands.add(new OffCommand());
		this.subcommands.add(new SoundOffCommand(AutoMessage.getInst()));
		this.subcommands.add(new SoundOnCommand(AutoMessage.getInst()));
		this.subcommands.add(new ChangeDelayCommand(AutoMessage.getInst()));
		this.subcommands.add(new ReloadCommand());
		this.subcommands.add(new GetDelayCommand());
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!sender.hasPermission("automsg.admin")) {
			sender.sendMessage(color("&8[&r&lAM&8] &4Error! &cYou don't have the permission to use this command. &7(automsg.admin)"));
			return false;
		}
		if (sender instanceof Player) {
			Player p = (Player)sender;
			if (args.length > 0) {
				for (int i = 0; i < getSubCommands().size(); i++) {
					if (args[0].equalsIgnoreCase(((SubCommand)getSubCommands().get(i)).getName()))
						((SubCommand)getSubCommands().get(i)).perform(p, args);
				}
			} else if (args.length == 0) {
				sender.sendMessage(color("&8[&r&lAM&8]&7--------------------------------&8[&r&lAM&8]"));
				for (int i = 0; i < getSubCommands().size(); i++)
					sender.sendMessage(color("&a" + ((SubCommand)getSubCommands().get(i)).getSyntax() + " &r- &a" + ((SubCommand)getSubCommands().get(i)).getDescription()));
				sender.sendMessage(color("&8[&r&lAM&8]&7--------------------------------&8[&r&lAM&8]"));
			}
		}
		return true;
	}

	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1) {
			ArrayList<String> subcommandsArguments = new ArrayList<>();
			for (int i = 0; i < getSubCommands().size(); i++)
				subcommandsArguments.add(((SubCommand)getSubCommands().get(i)).getName());
			return subcommandsArguments;
		}
		if (args.length >= 2)
			for (int i = 0; i < getSubCommands().size(); i++) {
				if (args[0].equalsIgnoreCase(((SubCommand)getSubCommands().get(i)).getName()))
					return ((SubCommand)getSubCommands().get(i)).getSubcommandArguments((Player)sender, args);
			}
		return null;
	}

	public ArrayList<SubCommand> getSubCommands() {
		return this.subcommands;
	}
}
