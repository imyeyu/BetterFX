package view.pages;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import net.imyeyu.betterfx.component.BorderPaneGroup;
import net.imyeyu.betterfx.component.HBoxGroup;
import net.imyeyu.betterfx.util.Zpix;

public class PageGroup extends ScrollPane {

	public PageGroup() {
		Label labelBP = new Label("BorderPaneGroup 组件组：");
		labelBP.setFont(Zpix.getM());
		TextField t0 = new TextField();
		Button btn0 = new Button("左按钮");
		BorderPaneGroup bpg = new BorderPaneGroup();
		bpg.setLeft(btn0);
		bpg.setCenter(t0);

		TextField t1 = new TextField();
		Button btn1 = new Button("右按钮");
		BorderPaneGroup bpg1 = new BorderPaneGroup();
		bpg1.setCenter(t1);
		bpg1.setRight(btn1);

		TextField t2 = new TextField();
		Button btn2 = new Button("左按钮");
		Button btn3 = new Button("右按钮");
		BorderPaneGroup bpg2 = new BorderPaneGroup();
		bpg2.setLeft(btn2);
		bpg2.setCenter(t2);
		bpg2.setRight(btn3);

		TextField t3 = new TextField();
		Button btn4 = new Button("左按钮1");
		Button btn5 = new Button("左按钮2");
		HBoxGroup hg0 = new HBoxGroup(btn4, btn5);
		Button btn6 = new Button("右按钮1");
		Button btn7 = new Button("右按钮2");
		HBoxGroup hg1 = new HBoxGroup(btn6, btn7);
		BorderPaneGroup bpg3 = new BorderPaneGroup();
		bpg3.setLeft(hg0);
		bpg3.setCenter(t3);
		bpg3.setRight(hg1);

		Label labelHBox = new Label("HBoxGroup 组件组：");
		labelHBox.setFont(Zpix.getM());
		Button btn8 = new Button("按钮在组件组");
		Button btn9 = new Button("ControlGroup");
		Button btn10 = new Button("横向");
		Button btn11 = new Button("+2");
		HBoxGroup hboxg = new HBoxGroup(btn8, btn9, btn10, btn11);


		TextArea code = new TextArea("""
			// BorderPaneGroup 组件组
			TextField t3 = new TextField();
			Button btn4 = new Button("左按钮1");
			Button btn5 = new Button("左按钮2");
			HBoxGroup hg0 = new HBoxGroup(btn4, btn5);
			Button btn6 = new Button("右按钮1");
			Button btn7 = new Button("右按钮2");
			HBoxGroup hg1 = new HBoxGroup(btn6, btn7);
			BorderPaneGroup bpg3 = new BorderPaneGroup();
			bpg3.setLeft(hg0);
			bpg3.setCenter(t3);
			bpg3.setRight(hg1);
			
			// HBoxGroup 组件组
			Button btn8 = new Button("按钮在组件组");
			Button btn9 = new Button("ControlGroup");
			Button btn10 = new Button("横向");
			Button btn11 = new Button("+2");
			HBoxGroup hboxg = new HBoxGroup(btn8, btn9, btn10, btn11);
            """);
		code.setPrefHeight(420);
		code.getStyleClass().add("code");
		code.setEditable(false);

		VBox root = new VBox(6, labelBP, bpg, bpg1, bpg2, bpg3, labelHBox, new HBox(hboxg), code);
		root.setPadding(new Insets(10));

		setContent(root);
		setFitToWidth(true);
	}
}