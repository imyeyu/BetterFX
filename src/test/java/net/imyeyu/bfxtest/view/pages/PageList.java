package net.imyeyu.bfxtest.view.pages;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class PageList extends ScrollPane {

	public PageList() {
		ListView<String> l = new ListView<>();
		for (int i = 0; i < 10; i++) {
			l.getItems().add(String.valueOf(i));
		}
		l.setPrefSize(100, 200);

		setPadding(new Insets(14, 0, 0, 20));
		setContent(new VBox(12, l, new Label("组件没有做修改，只是 CSS 样式调整")));
	}
}