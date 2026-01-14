package dev.marceloOo.autoMessage.Config;

import java.util.List;
import dev.marceloOo.autoMessage.AutoMessage;

public class Config {
	private static List<String> msgs;

	private static boolean clickableMessage;

	private static boolean messagesInOrder;

	private static String clickableMessageTextOnChat1;

	private static String clickableMessageHoverText1;

	private static String clickableMessagesUrl1;

	private static Integer clickableMessagesDelay;

	private static String clickableMessageTextOnChat2;

	private static String clickableMessageHoverText2;

	private static String clickableMessagesUrl2;

	private static Integer delay;

	private static String prefix;

	private static String messageSound;

	private static String sound;

	private static String clickableMessagesSound;

	private static String clickableMessageSoundBool;

	public static void load() {
		AutoMessage.getInst().saveDefaultConfig();
		AutoMessage.getInst().reloadConfig();
		messageSound = AutoMessage.getInst().getConfig().getString("messageSound");
		msgs = AutoMessage.getInst().getConfig().getStringList("messages");
		prefix = AutoMessage.getInst().getConfig().getString("prefix");
		delay = Integer.valueOf(AutoMessage.getInst().getConfig().getInt("settings.delay"));
		sound = AutoMessage.getInst().getConfig().getString("sound");
		messagesInOrder = AutoMessage.getInst().getConfig().getBoolean("sendMessagesInOrder");
		clickableMessageSoundBool = AutoMessage.getInst().getConfig().getString("clickableMessageSoundBool");
		clickableMessage = AutoMessage.getInst().getConfig().getBoolean("clickableMessage");
		clickableMessagesDelay = Integer.valueOf(AutoMessage.getInst().getConfig().getInt("clickableMessagesDelay"));
		clickableMessagesSound = AutoMessage.getInst().getConfig().getString("clickableMessagesSound");
		clickableMessageTextOnChat1 = AutoMessage.getInst().getConfig().getString("clickableMessageTextOnChat1");
		clickableMessageHoverText1 = AutoMessage.getInst().getConfig().getString("clickableMessageHoverText1");
		clickableMessagesUrl1 = AutoMessage.getInst().getConfig().getString("clickableMessageUrl1");
		clickableMessageTextOnChat2 = AutoMessage.getInst().getConfig().getString("clickableMessageTextOnChat2");
		clickableMessageHoverText2 = AutoMessage.getInst().getConfig().getString("clickableMessageHoverText2");
		clickableMessagesUrl2 = AutoMessage.getInst().getConfig().getString("clickableMessageUrl2");
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

	public static String getSoundBool() {
		return messageSound;
	}

	public static Boolean getClickableMessage() {
		return Boolean.valueOf(clickableMessage);
	}

	public static String getClickableMessageTextOnChat1() {
		return clickableMessageTextOnChat1;
	}

	public static String getClickableMessageHoverText1() {
		return clickableMessageHoverText1;
	}

	public static String getClickableMessagesUrl1() {
		return clickableMessagesUrl1;
	}

	public static Integer getClickableMessagesDelay() {
		return clickableMessagesDelay;
	}

	public static String getClickableMessagesUrl2() {
		return clickableMessagesUrl2;
	}

	public static String getClickableMessageHoverText2() {
		return clickableMessageHoverText2;
	}

	public static String getClickableMessageTextOnChat2() {
		return clickableMessageTextOnChat2;
	}

	public static String getClickableMessagesSound() {
		return clickableMessagesSound;
	}

	public static String getClickableMessageSoundBool() {
		return clickableMessageSoundBool;
	}

	public static void setClickableMessageSoundBool(String clickableMessageSoundBool) {
		Config.clickableMessageSoundBool = clickableMessageSoundBool;
	}

	public static boolean isMessagesInOrder() {
		return messagesInOrder;
	}
}
