package view.pages;

import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;

public class PageList extends ScrollPane {

	public PageList() {
		ListView<String> l = new ListView<>();
		for (int i = 0; i < 10; i++) {
			l.getItems().add(String.valueOf(i));
		}
		l.setPrefSize(100, 200);

		setPadding(new Insets(14, 0, 0, 20));
		setContent(l);
	}
}