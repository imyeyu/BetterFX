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

/**
 * 分组面板
 * 特性：
 *     有标题（在边框左上）
 *     有边框
 *
 * 夜雨 创建于 2021-04-10 10:15
 */
public class TitlePane extends StackPane implements BetterFX {

	private final Label title;
	private Background bg;

	public TitlePane(String title, Node node) {
		bg = new BgFill(GRAY_WHITE).build();
		this.title = new Label(title);
		this.title.setTranslateY(-24);
		this.title.setPadding(new Insets(0, 6, 0, 6));
		this.title.setBackground(bg);

		setBorder(BORDER_DEFAULT);
		setPadding(new Insets(16, 12, 12, 12));
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