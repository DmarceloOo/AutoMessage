package me.marcelooo.automessage.tasks;

import me.marcelooo.automessage.config.Config;
import me.marcelooo.automessage.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.ThreadLocalRandom;

public class BroadcastTask extends BukkitRunnable {

    public void run() {
        Integer i = Integer.valueOf(tlr.nextInt(Config.getMessages().size()));
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = (Player[]) Bukkit.getOnlinePlayers().toArray((Object[])new Player[0])).length, j = 0; j < length; j++) {
            Player p = onlinePlayers[j];
            String m = Config.getPrefix() + Config.getMessages().get(i.intValue());
            // send the message(s) from the config
            p.sendMessage(ColorUtils.translateColorCodes(m));
            // play the sound chosen from the config
            p.playSound(p.getLocation(), Sound.valueOf(Config.getSound()), 1, 1);
        }
    }

//componentText:
    public static final ThreadLocalRandom tlr = ThreadLocalRandom.current();
}
