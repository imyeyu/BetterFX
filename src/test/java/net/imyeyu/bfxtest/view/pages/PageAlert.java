package net.imyeyu.bfxtest.view.pages;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import net.imyeyu.betterfx.component.HBoxGroup;
import net.imyeyu.betterfx.component.dialog.Alert;
import net.imyeyu.betterfx.component.dialog.AlertTextArea;

import java.util.Optional;

import static net.imyeyu.betterfx.component.dialog.Alert.NO;
import static net.imyeyu.betterfx.component.dialog.Alert.YES;

/**
 * 弹窗
 *
 * 夜雨 创建于 2021-05-16 23:34
 */
public class PageAlert extends ScrollPane {

	public PageAlert() {
		Button btn0 = new Button("信息");
		btn0.setOnAction(event -> {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText("就算天空再深，看不出裂痕，眉头，仍骤满密云。");
			alert.showAndWait();
		});
		Button btn1 = new Button("警告");
		btn1.setOnAction(event -> {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setContentText("不想再见面，从阅心酸，\n为怕这份情，仍然拖欠，\n到最后，\n未能尽退后，\n心更酸。");
			alert.showAndWait();
		});
		Button btn2 = new Button("错误");
		btn2.setOnAction(event -> {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("也许，\n天涯重逢难料是否早已有变化，\n深情何须又聚又散欺骗你与我，\n记不起从何时人便学懂不再说永远，\n害怕只得一些遗憾。");
			alert.showAndWait();
		});
		Button btn3 = new Button("询问");
		btn3.setOnAction(event -> {
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION, YES, NO, Alert.CANCEL);
			alert.setContentText("是什么淋湿了我的眼睛，\n看不清你远去的背影。\n是什么冰冷了我的心情，\n握不住你从前的温馨。\n是雨声喧哗了我的安宁，\n听不清自己哭泣的声音。\n是雨伞美丽了城市的风景，\n留不住身边匆忙的爱情。");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.isPresent()) {
				ButtonType buttonType = result.get();
				if (YES.equals(buttonType)) {
					Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
					alert1.setContentText("是");
					alert1.showAndWait();
					return;
				}
				if (NO.equals(buttonType)) {
					Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
					alert1.setContentText("否");
					alert1.showAndWait();
				}
			}
		});
		HBox topBtns = new HBox(new HBoxGroup(btn0, btn1, btn2, btn3));
		TextArea code = new TextArea("""
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText("就算天空再深，看不出裂痕，眉头，仍骤满密云。");
			alert.showAndWait();
			""");
		code.setEditable(false);
		Label tips = new Label("注意 Alert 引用的是 net.imyeyu.betterfx.component.dialog.Alert，其参数也是这个包内参数");

		// 其他弹窗
		Button btn4 = new Button("文本域弹窗");
		btn4.setOnAction(event -> new AlertTextArea(Alert.AlertType.INFORMATION, "标签内容", "文本域内容").show());

		setPadding(new Insets(14, 0, 0, 20));
		setContent(new VBox(12, topBtns, code, tips, btn4));
	}
}