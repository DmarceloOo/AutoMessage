package me.marcelooo.automessage;

import me.marcelooo.automessage.commands.CreateVoucher;
import me.marcelooo.automessage.commands.MessageCommand;
import me.marcelooo.automessage.config.Config;
import me.marcelooo.automessage.events.VouchersListener;
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

        getServer().getPluginManager().registerEvents(new VouchersListener(), this);

        this.getCommand("createvoucher").setExecutor(new CreateVoucher());
        this.getCommand("automessage").setExecutor((CommandExecutor)new MessageCommand());
    }

    public static AutoMessage getInst() {
        return instance;
    }
}
