package net.imyeyu.bfxtest.view.pages;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

/**
 * 边框操作简化
 *
 * 夜雨 创建于 2021/5/16 23:42
 */
public class PageXBorder extends ScrollPane {

	public PageXBorder() {
		Label explain0 = new Label("位置：net.imyeyu.betterfx.extend.XBorder");
		Label explain1 = new Label("说明：简化边框构造");

		Label labelBefore = new Label("原来的：");
		TextArea before = new TextArea("""
			new Border(new BorderStroke(
			    Paint.valueOf("red"), Paint.valueOf("red"), Paint.valueOf("red"), Paint.valueOf("red"),
			    BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
			    new CornerRadii.EMPTY,
			    new BorderWidths(1),
			    new Insets.EMPTY
			));
			""");
		before.setEditable(false);

		Label labelAfter = new Label("现在可以这样做：");
		TextArea after = new TextArea("""
			new XBorder("red").build();
			// 不同宽度
			new XBorder("red").width(1, 2, 3, 4).build();
			// 圆角
			new XBorder("red").radius(.5, true).build();
			// 单边边框
			new XBorder("red").top().build();
			""");
		after.setEditable(false);

		setPadding(new Insets(14, 20, 0, 20));
		setContent(new VBox(6, explain0, explain1, labelBefore, before, labelAfter, after));
		setFitToWidth(true);
	}
}