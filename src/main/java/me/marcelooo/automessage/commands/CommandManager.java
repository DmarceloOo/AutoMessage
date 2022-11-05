package me.marcelooo.automessage.commands;

import me.marcelooo.automessage.commands.subcommands.OffCommand;
import me.marcelooo.automessage.commands.subcommands.OnCommand;
import me.marcelooo.automessage.commands.subcommands.ReloadCommand;
import me.marcelooo.automessage.utils.SubCommand;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandManager implements TabExecutor {

    public String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    private ArrayList<SubCommand> subcommands = new ArrayList<>();

    public CommandManager() {
        //Get the subcommands so we can access them in the command manager class(here)
        subcommands.add(new OnCommand());
        subcommands.add(new OffCommand());
        subcommands.add(new ReloadCommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player)sender;
        if (!p.hasPermission("automsg.admin")) {
            p.sendMessage(color("&8[&r&lAM&8] &4Error! &cYou don't have the permission to use this command. &7(automsg.admin)"));
            return false;
        }

        if (sender instanceof Player) {
                if (args.length > 0) {
                    for (int i = 0; i < getSubCommands().size(); i++) {
                        if (args[0].equalsIgnoreCase(getSubCommands().get(i).getName())) {
                            getSubCommands().get(i).perform(p, args);
                        }
                    }
                } else if (args.length == 0) {
                    p.sendMessage(color("&8[&r&lAM&8]&7--------------------------------&8[&r&lAM&8]"));
                    for (int i = 0; i < getSubCommands().size(); i++) {
                        p.sendMessage(color("&a" + getSubCommands().get(i).getSyntax() + " &r- " + "&a" + getSubCommands().get(i).getDescription()));
                    }
                    p.sendMessage(color("&8[&r&lAM&8]&7--------------------------------&8[&r&lAM&8]"));
                }


            }
        return true;
    }

        @Override
        public List<String> onTabComplete (CommandSender sender, Command command, String alias, String[]args){

            if (args.length == 1) { //prank <subcommand> <args>
                ArrayList<String> subcommandsArguments = new ArrayList<>();

                for (int i = 0; i < getSubCommands().size(); i++) {
                    subcommandsArguments.add(getSubCommands().get(i).getName());
                }

                return subcommandsArguments;
            } else if (args.length >= 2) {
                for (int i = 0; i < getSubCommands().size(); i++) {
                    if (args[0].equalsIgnoreCase(getSubCommands().get(i).getName())) {
                        return getSubCommands().get(i).getSubcommandArguments((Player) sender, args);
                    }
                }
            }

            return null;
        }

        public ArrayList<SubCommand> getSubCommands () {
            return subcommands;
        }
    }


