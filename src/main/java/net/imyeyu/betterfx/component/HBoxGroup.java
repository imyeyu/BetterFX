package net.imyeyu.betterfx.component;

import javafx.geometry.Bounds;
import javafx.scene.control.Control;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import net.imyeyu.betterfx.BetterFX;
import net.imyeyu.betterfx.extend.BgFill;
import net.imyeyu.betterfx.extend.BorderX;

/**
 * 按钮组
 *
 * 夜雨 创建于 2021/4/13 14:56
 */
public class HBoxGroup extends AnchorPane {

	private static final Border BORDER = new BorderX(BetterFX.LIGHT_GRAY).right().build();

	public HBoxGroup(Control... controls) {
		HBox root = new HBox();
		// 补偿线
		Region line = new Region();
		line.setBackground(new BgFill(BetterFX.FOCUSED_COLOR).build());
		line.setPrefWidth(1);
		line.setVisible(false);
		line.prefHeightProperty().bind(controls[0].heightProperty());

		for (int i = 0; i < controls.length; i++) {
			final int j = i;
			if (0 < i) {
				// 偏移
				controls[i].setTranslateX(-i);
			}
			// 补偿线偏移
			controls[i].focusedProperty().addListener((obs, o, isFocused) -> {
				if (isFocused) {
					Bounds bounds = controls[j].localToParent(controls[j].getBoundsInLocal());
					line.setTranslateX(-(root.getWidth() - bounds.getMaxX()));
				}
				line.setVisible(isFocused);
			});
		}
		root.getChildren().addAll(controls);
		root.getChildren().add(line);
		root.setFillHeight(false);
		getChildren().add(root);
		setRightAnchor(root, (double) -controls.length); // 溢出偏移部分
	}
}