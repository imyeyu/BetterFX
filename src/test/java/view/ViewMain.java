package view;

import bean.Page;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import net.imyeyu.betterfx.BetterFX;

/**
 * 主界面
 *
 * 夜雨 创建于 2021/4/13 09:54
 */
public abstract class ViewMain extends Application {

	protected ListView<Page> list;
	protected SplitPane root;

	@Override
	public void start(Stage stage) {
		list = new ListView<>();
		list.setCellFactory(new Callback<>() {
			@Override
			public ListCell<Page> call(ListView<Page> pageListView) {
				return new ListCell<>() {
					@Override
					protected void updateItem(Page item, boolean empty) {
						super.updateItem(item, empty);
						if (empty || item == null) {
							setGraphic(null);
						} else {
							setGraphic(new Label(item.getTitle()));
						}
					}
				};
			}
		});

		root = new SplitPane();
		root.setBorder(BetterFX.BORDER_TOP);
		root.getItems().add(list);

		Scene scene = new Scene(root);
		scene.getStylesheets().add(BetterFX.CSS);
		stage.setTitle("BetterFX 测试程序");
		stage.setScene(scene);
		stage.setWidth(750);
		stage.setHeight(420);
		stage.show();
	}
}