package net.imyeyu.bfxtest;

import javafx.application.Application;
import net.imyeyu.bfxtest.ctrl.Main;

/**
 * 启动器
 *
 * 夜雨 创建于 2021-04-13 09:56
 */
public class TestLauncher {

	public static void main(String[] args) {
		{
			// 禁止 DPI 缩放
			System.setProperty("prism.allowhidpi", "false");
			System.setProperty("glass.win.minHiDPI", "1");
		}
		Application.launch(Main.class, args);
	}
}