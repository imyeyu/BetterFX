package view.pages;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import net.imyeyu.betterfx.BetterFX;
import net.imyeyu.betterfx.extend.XBorder;
import net.imyeyu.betterfx.util.Zpix;

public class PageButton extends ScrollPane {

	public PageButton() {
		Button btn0 = new Button("Button 按钮");
		Button btn1 = new Button("Button");
		btn1.setBorder(new XBorder(BetterFX.RED).build());
		Button btn2 = new Button("自定义边框");
		btn2.setBorder(new XBorder(BetterFX.RED, BetterFX.BLUE, BetterFX.ORANGE, BetterFX.GREEN).build());

		Button btn7 = new Button("M 号字体");
		Zpix.css(btn7, Zpix.M);
		Button btn8 = new Button("L 号字体");
		Zpix.css(btn8, Zpix.L);

		FlowPane btns = new FlowPane(btn0, btn1, btn2, btn7, btn8);
		btns.setVgap(6);
		btns.setHgap(8);

		setPadding(new Insets(14, 0, 0, 20));
		setContent(new VBox(12, btns, new Label("组件没有做修改，只是 CSS 样式调整")));
	}
}