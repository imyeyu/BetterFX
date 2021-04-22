package ctrl;

import bean.Page;
import javafx.stage.Stage;
import view.ViewMain;
import view.pages.PageButton;
import view.pages.PageComboBox;
import view.pages.PageGroup;
import view.pages.PageList;
import view.pages.PagePopup;
import view.pages.PageTextInput;

/**
 * 主界面控制器
 *
 * 夜雨 创建于 2021/4/13 09:56
 */
public class Main extends ViewMain {

	@Override
	public void start(Stage stage) {
		super.start(stage);

		list.getItems().add(new Page("按钮", new PageButton()));
		list.getItems().add(new Page("组件组", new PageGroup()));
		list.getItems().add(new Page("输入", new PageTextInput()));
		list.getItems().add(new Page("下拉选择", new PageComboBox()));
		list.getItems().add(new Page("列表", new PageList()));
		list.getItems().add(new Page("弹窗提示", new PagePopup()));

		list.setOnMouseClicked(event -> {
			if (event.getClickCount() == 2) {
				final Page item = list.getSelectionModel().getSelectedItem();
				if (item != null) {
					root.getItems().remove(1, 2);
					root.getItems().add(item.getNode());
					root.setDividerPositions(.3, .7);
				}
			}
		});
		root.getItems().add(list.getItems().get(0).getNode());
		root.setDividerPositions(.3, .7);
	}
}