package dev.marceloOo.autoMessage;

import dev.marceloOo.autoMessage.Commands.CommandManager;
import dev.marceloOo.autoMessage.Config.Config;
import dev.marceloOo.autoMessage.Tasks.BroadcastTask;
import dev.marceloOo.autoMessage.Utils.Metrics;
import org.bukkit.Bukkit;
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
		task = Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new BroadcastTask(), 20L, (Config.getDelay().intValue() * 20));
		getCommand("automessage").setExecutor(new CommandManager());
	}

	public static AutoMessage getInst() {
		return instance;
	}
}
