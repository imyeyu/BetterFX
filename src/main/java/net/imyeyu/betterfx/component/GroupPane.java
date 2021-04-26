package net.imyeyu.betterfx.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import net.imyeyu.betterfx.BetterFX;
import net.imyeyu.betterfx.extend.BgFill;
import net.imyeyu.betterfx.extend.XBorder;

/**
 * 分组面板
 * 特性：
 *     有标题（在边框上）
 *     有边框
 *
 * 夜雨 创建于 2021/4/10 10:15
 */
public class GroupPane extends StackPane {

	private final Label title;
	private Background bg;

	public GroupPane(String title, Node node) {
		bg = new BgFill(BetterFX.GRAY_WHITE).build();
		this.title = new Label(title);
		this.title.setTranslateY(-16);
		this.title.setPadding(new Insets(0, 6, 0, 6));
		this.title.setBackground(bg);

		setBorder(new XBorder(BetterFX.LIGHT_GRAY).build());
		setPadding(new Insets(8));
		setAlignment(Pos.TOP_LEFT);
		setBackground(bg);
		getChildren().addAll(this.title, node);
	}

	public void setBackground(Paint paint) {
		bg = new BgFill(paint).build();
		setBackground(bg);
		title.setBackground(bg);
	}

	public Label getLabel() {
		return title;
	}

	public void setTitle(String title) {
		this.title.setText(title);
	}

	public String getTitle() {
		return  title.getText();
	}
}