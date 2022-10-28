package me.marcelooo.automessage.config;

import me.marcelooo.automessage.AutoMessage;
import org.bukkit.Sound;

import java.util.List;

public class Config     {
    private static List<String> msgs;

    private static Integer delay;

    private static String prefix;
    private static String sound;

    public static void load() {

        AutoMessage.getInst().saveDefaultConfig();
        AutoMessage.getInst().reloadConfig();


        msgs = AutoMessage.getInst().getConfig().getStringList("messages");
        prefix = AutoMessage.getInst().getConfig().getString("prefix");
        delay = Integer.valueOf(AutoMessage.getInst().getConfig().getInt("settings.delay"));
        sound = AutoMessage.getInst().getConfig().getString("sound");

    }

    public static List<String> getMessages() {
        return msgs;
    }

    public static Integer getDelay() {
        return delay;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static String getSound() {
        return sound;
    }
}
