package dev.marceloOo.autoMessage.Tasks;

import java.util.concurrent.ThreadLocalRandom;
import dev.marceloOo.autoMessage.Config.Config;
import dev.marceloOo.autoMessage.Utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class BroadcastTask extends BukkitRunnable {
	private static final ThreadLocalRandom tlr = ThreadLocalRandom.current();

	private int currentMessageIndex = 0;

	public void run() {
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = (Player[])Bukkit.getOnlinePlayers().toArray((Object[])new Player[0])).length, j = 0; j < length; j++) {
			Player p = onlinePlayers[j];
			boolean sendMessagesInOrder = Config.isMessagesInOrder();
			if (sendMessagesInOrder) {
				String m = getNextMessage();
				p.sendMessage(ColorUtils.translateColorCodes(m));
			} else {
				Integer i = Integer.valueOf(tlr.nextInt(Config.getMessages().size()));
				String m = Config.getPrefix() + (String)Config.getMessages().get(i.intValue());
				p.sendMessage(ColorUtils.translateColorCodes(m));
			}
			boolean playSound = Boolean.parseBoolean(Config.getSoundBool());
			if (playSound)
				p.playSound(p.getLocation(), Sound.valueOf(Config.getSound()), 1.0F, 1.0F);
		}
	}

	private String getNextMessage() {
		String message = Config.getPrefix() + (String)Config.getMessages().get(this.currentMessageIndex);
		this.currentMessageIndex = (this.currentMessageIndex + 1) % Config.getMessages().size();
		return message;
	}
}
