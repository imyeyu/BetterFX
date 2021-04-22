package net.imyeyu.betterfx.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import net.imyeyu.betterfx.BetterFX;

/**
 * <br>表单组，简化标签和字段组合的组件
 * 
 * @param <T> 字段
 *
 * 夜雨 创建于 2021/2/13 13:31
 */
public class InputGroup<T extends Control> extends HBox {
	
	private Label before, after;
	private final T control;
	
	public InputGroup(T control) {
		this(null, control, null);
	}
	
	public InputGroup(String before, T control) {
		this(before, control, null);
	}
	
	public InputGroup(T control, String after) {
		this(null, control, after);
	}

	public InputGroup(String before, T control, String after) {
		if (before != null) {
			this.before = new Label(before);
			this.before.setTextFill(BetterFX.GRAY);
			this.before.setOnMouseClicked(e -> control.requestFocus());
			getChildren().add(this.before);
		}

		this.control = control;
		getChildren().add(control);

		if (after != null) {
			this.after = new Label(after);
			this.after.setTextFill(BetterFX.GRAY);
			this.after.setOnMouseClicked(e -> control.requestFocus());
			getChildren().add(this.after);
		}

		setAlignment(Pos.CENTER_LEFT);
		HBox.setMargin(control, new Insets(0, 4, 0, 4));
	}
	
	public Label getBefore() {
		return before;
	}
	
	public T getInput() {
		return control;
	}
	
	public Label getAfter() {
		return after;
	}
}