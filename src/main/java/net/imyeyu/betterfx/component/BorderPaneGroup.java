package net.imyeyu.betterfx.component;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import net.imyeyu.betterfx.BetterFX;
import net.imyeyu.betterfx.extend.BgFill;
import net.imyeyu.betterfx.extend.XBorder;

/**
 * 按钮组
 *
 * 夜雨 创建于 2021-04-13 14:56
 */
public class BorderPaneGroup extends AnchorPane {

	private static final Border BORDER = new XBorder(BetterFX.LIGHT_GRAY).right().build();

	private final Region line; // 补偿线
	private final BorderPane root;

	public BorderPaneGroup() {
		root = new BorderPane();

		line = new Region();
		line.setBackground(new BgFill(BetterFX.FOCUSED_COLOR).build());
		line.setPrefWidth(1);
		line.setVisible(false);
		line.prefHeightProperty().bind(heightProperty());

		getChildren().addAll(root, line);
		widthProperty().addListener((obs, o, n) -> requestFocus());
	}

	public void setLeft(Node node) {
		node.setTranslateX(1);
		addFocusedLine(node, -2);
		root.setLeft(node);
		AnchorPane.setLeftAnchor(root, -1d);
	}

	public void setCenter(Node node) {
		root.setCenter(node);
		if (root.getLeft() == null) {
			addFocusedLine(node, -1);
			AnchorPane.setLeftAnchor(root, 0d);
		} else {
			addFocusedLine(node, -2);
		}
		if (root.getRight() == null) {
			AnchorPane.setRightAnchor(root, 0d);
		}
	}

	public void setRight(Node node) {
		node.setTranslateX(-1);
		addFocusedLine(node, -1);
		root.setRight(node);
		AnchorPane.setRightAnchor(root, -1d);
	}

	private void addFocusedLine(Node node, double offset) {
		node.focusedProperty().addListener((obs, o, isFocused) -> {
			if (isFocused) {
				Bounds bounds = node.localToParent(node.getBoundsInLocal());
				line.setTranslateX(bounds.getMaxX() + offset);
			}
			line.setVisible(isFocused);
		});
	}
}
