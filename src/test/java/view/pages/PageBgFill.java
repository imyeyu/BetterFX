package view.pages;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class PageBgFill extends ScrollPane {

	public PageBgFill() {
		Label explain0 = new Label("位置：net.imyeyu.betterfx.extend.BgFill");
		Label explain1 = new Label("说明：简化设置填充背景的操作");

		Label labelBefore = new Label("原来的：");
		TextArea before = new TextArea("""
			// 纯色背景
			new Background(new BackgroundFill(Paint.valueOf("red"), CornerRadii.EMPTY, new Insets(10)));
			// 渐变背景
			Stop[] stops = new Stop[] { new Stop(0, Color.valueOf("red")), new Stop(1, Color.valueOf("blue"))};
			new Background(new BackgroundFill(
			    new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops),
			    CornerRadii.EMPTY,
			    new Insets(10)
			));""");
		before.getStyleClass().add("code");
		before.setEditable(false);

		Label labelAfter = new Label("现在可以这样做：");
		TextArea after = new TextArea("""
			// 纯色背景
			new BgFill("red").insets(new Insets(10)).build();
			// 渐变背景
			new BgFill("red", "blue").toRight().build();
			// 随机测试背景
			BgFill.test();
			""");
		after.getStyleClass().add("code");
		after.setEditable(false);

		setPadding(new Insets(14, 20, 0, 20));
		setContent(new VBox(6, explain0, explain1, labelBefore, before, labelAfter, after));
		setFitToWidth(true);
	}
}