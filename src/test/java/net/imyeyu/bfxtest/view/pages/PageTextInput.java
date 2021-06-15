package net.imyeyu.bfxtest.view.pages;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import net.imyeyu.betterfx.component.TextAreaField;

/**
 * 文本输入
 *
 * 夜雨 创建于 2021-05-16 23:42
 */
public class PageTextInput extends ScrollPane {

	private static final String FULL = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA";

	public PageTextInput() {
		TextField t0 = new TextField();
		TextField t1 = new TextField("123");
		TextArea t2 = new TextArea(FULL);

		TextAreaField taf0 = new TextAreaField("文本域型文本框0");
		taf0.setPrefWidth(440);
		TextAreaField taf1 = new TextAreaField("文本域型文本框1");
		taf1.setPrefWidth(440);

		FlowPane nodes = new FlowPane(t0, t1, t2, taf0, taf1);
		nodes.setVgap(6);
		nodes.setHgap(8);

		setPadding(new Insets(14, 0, 0, 20));
		setContent(new VBox(12, nodes, new Label("组件没有做修改，只是 CSS 样式调整")));
	}
}