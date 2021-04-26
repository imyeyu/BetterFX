package net.imyeyu.bfxtest.view.pages;

import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class PageProgressBar extends ScrollPane {

	private long i = 0;

	public PageProgressBar() {
		ProgressBar pb0 = new ProgressBar();
		ProgressBar pb1 = new ProgressBar();
		pb1.setProgress(.5);
		ProgressBar pb2 = new ProgressBar();
		new AnimationTimer() {
			@Override
			public void handle(long now) {
				pb2.setProgress((i++ % 100d) / 100);
			}
		}.start();

		pb0.prefWidthProperty().bind(widthProperty());
		pb1.prefWidthProperty().bind(widthProperty());
		pb2.prefWidthProperty().bind(widthProperty());

		setPadding(new Insets(14, 20, 0, 20));
		setContent(new VBox(16, pb0, pb1, pb2, new Label("组件没有做修改，只是 CSS 样式调整")));
		setFitToWidth(true);
	}
}