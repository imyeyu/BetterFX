package view.pages;

import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;

public class PageComboBox extends ScrollPane {

	private static final String[] datas = {"数据0", "数据1", "数据2"};

	public PageComboBox() {
		ComboBox<String> cb0 = new ComboBox<>();
		cb0.getItems().addAll(datas);

		ComboBox<String> cb1 = new ComboBox<>();
		cb1.setEditable(true);
		cb1.getItems().addAll(datas);

		FlowPane btns = new FlowPane(cb0, cb1);
		btns.setVgap(6);
		btns.setHgap(8);

		setPadding(new Insets(14, 0, 0, 20));
		setContent(btns);
	}
}
