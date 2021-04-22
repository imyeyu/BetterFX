package net.imyeyu.betterfx.component;

import javafx.scene.shape.SVGPath;

/**
 * SVG 图标，主要简化 SVGPath 构造函数
 * 
 * 夜雨 创建于 2021/2/13 13:35
 */
public class SVGIcon extends SVGPath {

	public SVGIcon(String path) {
		setContent(path);
	}
}