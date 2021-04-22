package view.pages;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import net.imyeyu.betterfx.BetterFX;
import net.imyeyu.betterfx.component.HBoxGroup;
import net.imyeyu.betterfx.extend.BorderX;
import net.imyeyu.betterfx.util.Zpix;

public class PageButton extends ScrollPane {

	public PageButton() {
		Button btn0 = new Button("Button 按钮");
		Button btn1 = new Button("Button 可以高度自定义");
		btn1.setBorder(new BorderX(BetterFX.RED).build());
		Button btn2 = new Button("自定义边框");
		btn2.setBorder(new BorderX(BetterFX.RED, BetterFX.BLUE, BetterFX.ORANGE, BetterFX.GREEN).build());

		Button btn3 = new Button("按钮在控件组");
		Button btn4 = new Button("ControlGroup");
		Button btn5 = new Button("横向");
		Button btn6 = new Button("+2");
		HBoxGroup bg = new HBoxGroup(btn3, btn4, btn5, btn6);

		Button btn7 = new Button("M 号字体");
		Zpix.css(btn7, Zpix.M);
		Button btn8 = new Button("L 号字体");
		Zpix.css(btn8, Zpix.L);

		FlowPane btns = new FlowPane(btn0, btn1, btn2, btn7, bg, btn8);
		btns.setVgap(6);
		btns.setHgap(8);

		setPadding(new Insets(14, 0, 0, 20));
		setContent(btns);
	}
}
