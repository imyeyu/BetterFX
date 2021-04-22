package view.pages;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import net.imyeyu.betterfx.bean.PopupTips;
import net.imyeyu.betterfx.service.PopupTipsService;

public class PagePopup extends ScrollPane {

	public PagePopup() {
		TextArea t0 = new TextArea();
		t0.setPrefHeight(50);
		t0.setPromptText("文本提示");
		PopupTipsService.install(t0, new PopupTips("朝朝频顾惜，夜夜不相忘"));

		TextArea t1 = new TextArea();
		t1.setPrefHeight(50);
		t1.setPromptText("支持换行");
		PopupTipsService.install(t1, new PopupTips("在看得到的地方站得直\n是因为在看不到的地方站得稳"));

		TextArea t2 = new TextArea();
		t2.setPrefHeight(50);
		t2.setPromptText("支持图片");
		PopupTipsService.install(t2, new PopupTips(new Image("/logo.png")));

		TextArea t3 = new TextArea();
		t3.setPrefHeight(50);
		t3.setPromptText("支持任何组件");
		StackPane pane = new StackPane(new Button("但你点不到我"));
		pane.setPadding(new Insets(6, 8, 6, 8));
		PopupTipsService.install(t3, new PopupTips(pane));

		setPadding(new Insets(14, 20, 0, 20));
		setContent(new VBox(6, t0, t1, t2, t3));
		setFitToWidth(true);
	}
}
