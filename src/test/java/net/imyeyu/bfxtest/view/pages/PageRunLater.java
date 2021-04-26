package net.imyeyu.bfxtest.view.pages;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class PageRunLater extends ScrollPane {

	public PageRunLater() {

		Label explain0 = new Label("位置：net.imyeyu.betterfx.service.RunLater");
		Label explain1 = new Label("说明：快速构造稍后执行任务（注意这是异步的）");

		TextArea code = new TextArea("""
			RunLater.time(1000).event(() -> {
			    // 延时 1 秒后执行（属于 FX 线程）
			})
			""");
		code.getStyleClass().add("code");
		code.setEditable(false);

		setPadding(new Insets(14, 20, 0, 20));
		setContent(new VBox(6, explain0, explain1, code));
		setFitToWidth(true);
	}
}