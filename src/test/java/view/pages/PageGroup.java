package view.pages;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import net.imyeyu.betterfx.component.BorderPaneGroup;
import net.imyeyu.betterfx.component.HBoxGroup;

public class PageGroup extends ScrollPane {

	public PageGroup() {
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

		setPadding(new Insets(14, 20, 0, 20));
		setContent(new VBox(6, bpg, bpg1, bpg2, bpg3));
		setFitToWidth(true);
	}
}
