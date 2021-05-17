package net.imyeyu.betterfx.component;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import net.imyeyu.betterfx.BetterFX;
import net.imyeyu.betterfx.extend.BgFill;

/**
 * 滑动开关
 * 
 * 夜雨 创建于 2021-02-13 13:35
 */
public class Switch extends HBox {

	private final BooleanProperty selectedProperty = new SimpleBooleanProperty(false);
	private final Background bg = new BgFill("#9B9B9B").build();
	private final Background bgSelected = new BgFill("#393").build();

	private final HBox box;
	private final Label label;
	private final Region region;

	public Switch() {
		this("", HPos.LEFT);
	}

	public Switch(String text) {
		this(text, HPos.RIGHT, false);
	}

	public Switch(String text, boolean isSelected) {
		this(text, HPos.RIGHT, isSelected);
	}

	public Switch(String text, HPos pos) {
		this(text, pos, false);
	}
	
	public Switch(String text, HPos pos, boolean isSelected) {
		// 滑块
		region = new Region();
		region.setPrefWidth(11);
		region.setBackground(bg);
		// 盒子
		box = new HBox(region);
		box.setPadding(new Insets(1));
		box.setPrefSize(28, 15);
		box.setBorder(BetterFX.BORDER_DEFAULT);
		box.setBackground(new BgFill("#EEE", "#DADADA").toBottom().build());
		// 标签
		label = new Label(text);
		label.setPadding(new Insets(0, 0, 1, 0));
		// 根容器
		setMaxHeight(15);
		setAlignment(Pos.CENTER_LEFT);
		setFillHeight(false);
		setSpacing(6);
		if (pos == HPos.LEFT) {
			getChildren().addAll(box, label);
		} else {
			getChildren().addAll(label, box);
		}
		// 事件
		setOnMouseClicked(e -> {
			selectedProperty.set(!selectedProperty.get());
			requestFocus();
		});
		selectedProperty().addListener((obs, o, _isSelected) -> {
			box.setAlignment(_isSelected ? Pos.CENTER_RIGHT : Pos.CENTER_LEFT);
			region.setBackground(_isSelected ? bgSelected : bg);
		});
		focusedProperty().addListener((obs, o, isFocused) -> {
			box.setBorder(isFocused ? BetterFX.BORDER_FOCUSED : BetterFX.BORDER_DEFAULT);
		});

		this.selectedProperty.set(isSelected);
	}

	public boolean isSelected() {
		return selectedProperty.get();
	}

	public void setSelected(boolean isSelected) {
		this.selectedProperty.set(isSelected);
	}

	public BooleanProperty selectedProperty() {
		return selectedProperty;
	}

	public void setFont(Font font) {
		label.setFont(font);
		final double size = font.getSize();
		box.setPrefWidth(16 + size);
		if (20 < size) {
			box.setPadding(new Insets(2));
			box.setPrefHeight(size - 4);
			region.setPrefWidth(size - 10);
		} else {
			box.setPadding(new Insets(1));
			box.setPrefHeight(size + 4);
			region.setPrefWidth(size - 1);
		}
	}

	public void setText(String text) {
		label.setText(text);
	}

	public String getText() {
		return label.getText();
	}
}