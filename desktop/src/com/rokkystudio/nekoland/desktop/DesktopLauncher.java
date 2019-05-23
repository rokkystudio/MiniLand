package com.rokkystudio.nekoland.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.rokkystudio.nekoland.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		System.setProperty("user.name", "user");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Main(), config);
	}
}
