package net.imyeyu.betterfx.util;

import javafx.scene.Node;
import javafx.scene.text.Font;
import net.imyeyu.betterfx.BetterFX;

/**
 * Minecraft 字体
 * 
 * 夜雨 创建于 2021-04-14 00:11
 */
public class MinecraftFont implements BetterFX {
	
	public static int S = 16, M = 32, L = 64;

	private static Font s, m, l;
	private static final String NAME = "MinecraftAE.ttf";
	
	/**
	 * 通过 CSS 修改字号，请置于组件样式修改的最后
	 * 
	 * @param node 组件
	 * @param size 字号，单位：像素
	 */
	public static void css(Node node, int size) {
		node.setStyle(node.getStyle() + "; -fx-font-size: " + size);
	}

	public static Font getS() {
		return s == null ? buildS() : s;
	}
	
	public static Font getM() {
		return m == null ? buildM() : m;
	}
	
	public static Font getL() {
		return l == null ? buildL() : l;
	}
	
	private static Font buildS() {
		s = Font.loadFont(MinecraftFont.class.getResourceAsStream(STATIC_DIR + NAME), S);
		return s;
	}
	
	private static Font buildM() {
		m = Font.loadFont(MinecraftFont.class.getResourceAsStream(STATIC_DIR + NAME), M);
		return m;
	}
	
	private static Font buildL() {
		l = Font.loadFont(MinecraftFont.class.getResourceAsStream(STATIC_DIR + NAME), L);
		return l;
	}
}