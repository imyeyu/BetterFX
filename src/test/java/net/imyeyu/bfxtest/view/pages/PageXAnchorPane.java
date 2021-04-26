package net.imyeyu.bfxtest.view.pages;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class PageXAnchorPane extends ScrollPane {

	public PageXAnchorPane() {
		Label explain0 = new Label("位置：net.imyeyu.betterfx.extend.XAnchorPane");
		Label explain1 = new Label("说明：简化锚点布局的操作");

		Label labelBefore = new Label("原来的：");
		TextArea before = new TextArea("""
			AnchorPane.setTopAnchor(node, 10d);
			AnchorPane.setLeftAnchor(node, 10d);
			AnchorPane.setRightAnchor(node, 10d);
			AnchorPane.setBottomAnchor(node, 10d);
			""");
		before.getStyleClass().add("code");
		before.setEditable(false);

		Label labelAfter = new Label("现在可以这样做：");
		TextArea after = new TextArea("""
			XAnchorPane.def(node, 10);
			XAnchorPane.def(node, 10, 5, 10, 5);
			XAnchorPane.def(node, 10, null, 10, null);
			""");
		after.getStyleClass().add("code");
		after.setEditable(false);

		setPadding(new Insets(14, 20, 0, 20));
		setContent(new VBox(6, explain0, explain1, labelBefore, before, labelAfter, after));
		setFitToWidth(true);
	}
}
