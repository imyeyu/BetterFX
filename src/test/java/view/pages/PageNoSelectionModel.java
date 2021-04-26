package view.pages;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import net.imyeyu.betterfx.extend.NoSelectionModel;

public class PageNoSelectionModel extends ScrollPane {

	public PageNoSelectionModel() {
		Label explain0 = new Label("位置：net.imyeyu.betterfx.extend.NoSelectionModel");
		Label explain1 = new Label("说明：关闭 ListView 选择操作，第二个为关闭");

		ListView<String> l0 = new ListView<>();
		l0.setPrefSize(100, 200);

		ListView<String> l1 = new ListView<>();
		l1.setPrefSize(100, 200);
		l1.setSelectionModel(new NoSelectionModel<>());

		for (int i = 0; i < 10; i++) {
			l0.getItems().add(String.valueOf(i));
			l1.getItems().add(String.valueOf(i));
		}

		TextArea code = new TextArea("""
			ListView<String> l1 = new ListView<>();
			l1.setPrefSize(100, 200);
			l1.setSelectionModel(new NoSelectionModel<>());		                             
			""");
		code.getStyleClass().add("code");
		code.setEditable(false);

		VBox root = new VBox(6, explain0, explain1, new HBox(16, l0, l1), code);

		setPadding(new Insets(14, 20, 0, 20));
		setFitToWidth(true);
		setContent(root);
	}
}
