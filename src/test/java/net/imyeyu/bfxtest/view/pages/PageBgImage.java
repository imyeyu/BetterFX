package net.imyeyu.bfxtest.view.pages;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class PageBgImage extends ScrollPane {

	public PageBgImage() {
		Label explain0 = new Label("位置：net.imyeyu.betterfx.extend.BgImage");
		Label explain1 = new Label("说明：简化设置图像背景的操作");

		Label labelBefore = new Label("原来的：");
		TextArea before = new TextArea("""
			new Background(
			    new BackgroundImage(
			        new Image("/img.png"),
			        BackgroundRepeat.NOT_REPEAT,
			        BackgroundRepeat.NOT_REPEAT,
			        BackgroundPosition.DEFAULT,
			        BackgroundSize.DEFAULT
			    )
			);""");
		before.getStyleClass().add("code");
		before.setEditable(false);

		Label labelAfter = new Label("现在可以这样做：");
		TextArea after = new TextArea("""
			new BgImage("/img.png").build();
			// 自适应背景
			new BgImage("/bg.png").cover().build();
			""");
		after.getStyleClass().add("code");
		after.setEditable(false);

		setPadding(new Insets(14, 20, 0, 20));
		setContent(new VBox(6, explain0, explain1, labelBefore, before, labelAfter, after));
		setFitToWidth(true);
	}
}
