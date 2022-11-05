package me.marcelooo.automessage;

import me.marcelooo.automessage.commands.CommandManager;
import me.marcelooo.automessage.config.Config;
import me.marcelooo.automessage.tasks.BroadcastTask;
import me.marcelooo.automessage.utils.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class AutoMessage extends JavaPlugin {

    public static int task;

    private static AutoMessage instance;

    @Override
    public void onEnable() {

        instance = this;

        Config.load();

        int pluginId = 16543;
        Metrics metrics = new Metrics(this, pluginId);

        task = Bukkit.getScheduler().scheduleAsyncRepeatingTask((Plugin)this, (Runnable)new BroadcastTask(), 20L, (Config.getDelay().intValue() * 20));

        this.getCommand("automessage").setExecutor((CommandExecutor) new CommandManager());
    }

    public static AutoMessage getInst() {
        return instance;
    }
}
