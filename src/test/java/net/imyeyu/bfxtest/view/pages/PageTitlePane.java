package net.imyeyu.bfxtest.view.pages;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import net.imyeyu.betterfx.component.TitlePane;

/**
 * 标题布局
 *
 * 夜雨 创建于 2021-05-16 23:37
 */
public class PageTitlePane extends ScrollPane {

	public PageTitlePane() {
		TextArea code = new TextArea("""
			GroupPane gp = new GroupPane("标题", new Label("内容"));
			BorderPane.setMargin(gp, new Insets(12, 0, 0, 0)); // 可能需要外边距
			""");
		code.setEditable(false);

		TitlePane tp = new TitlePane("标题", new VBox(12, new Label("带标题的布局组件"), code));

		BorderPane root = new BorderPane(tp);
		BorderPane.setMargin(tp, new Insets(12, 0, 0, 0));

		setPadding(new Insets(10));
		setFitToWidth(true);
		setFitToHeight(true);
		setContent(root);
	}
}