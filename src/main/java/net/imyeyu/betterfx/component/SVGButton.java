package net.imyeyu.betterfx.component;

import javafx.scene.control.Button;
import javafx.scene.paint.Paint;

/**
 * SVG 按钮
 *
 * 夜雨 创建于 2021-06-04 22:42
 */
public class SVGButton extends Button {

	private final SVGIcon svg;

	public SVGButton() {
		this("");
	}

	public SVGButton(String path) {
		this("", null);
	}

	public SVGButton(String path, Paint fill) {
		svg = new SVGIcon(path);
		svg.setFill(fill);
		getStyleClass().clear();
		setGraphic(svg);
	}

	public SVGIcon getSvg() {
		return svg;
	}

	public void setContent(String path) {
		svg.setContent(path);
	}

	public void setFill(Paint fill) {
		svg.setFill(fill);
	}
}