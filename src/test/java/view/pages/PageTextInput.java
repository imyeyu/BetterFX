package view.pages;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class PageTextInput extends ScrollPane {

	private static final String FULL = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA";

	public PageTextInput() {
		TextField t0 = new TextField();
		TextField t1 = new TextField("123");
		TextArea t2 = new TextArea(FULL);

		FlowPane btns = new FlowPane(t0, t1, t2);
		btns.setVgap(6);
		btns.setHgap(8);

		setPadding(new Insets(14, 0, 0, 20));
		setContent(btns);
	}
}