package view;

import bean.Page;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Callback;
import net.imyeyu.betterfx.BetterFX;
import net.imyeyu.betterfx.extend.XTreeView;

/**
 * 主界面
 *
 * 夜雨 创建于 2021/4/13 09:54
 */
public abstract class ViewMain extends Application {

	protected XTreeView<Page> nav;
	protected SplitPane root;

	@Override
	public void start(Stage stage) {
		nav = new XTreeView<>();
		nav.setCellFactory(new Callback<>() {
			@Override
			public TreeCell<Page> call(TreeView<Page> pageTreeView) {
				return new TreeCell<>() {
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
		root.getItems().add(nav);

		Scene scene = new Scene(root);
		scene.getStylesheets().add(BetterFX.CSS);
		stage.getIcons().add(new Image("icon.png"));
		stage.setTitle("BetterFX 测试程序");
		stage.setScene(scene);
		stage.setWidth(820);
		stage.setHeight(520);
		stage.show();
	}
}
