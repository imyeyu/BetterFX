package net.imyeyu.betterfx.component;

import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import net.imyeyu.betterfx.BetterFX;
import net.imyeyu.betterfx.extend.BgFill;

/**
 * 文本域型文本框？
 *
 * 夜雨 创建于 2021-06-04 01:30
 */
public class TextAreaField extends HBox implements BetterFX {

	private final double height = 160; // 文本域高度
	private final TextAreaPopup popup;
	private final TextField textField;

	public TextAreaField() {
		this("");
	}

	public TextAreaField(String text) {
		super();
		// 文本框
		textField = new TextField(text);
		textField.setStyle("-fx-background-color: -fx-control-inner-background;");
		textField.prefWidthProperty().bind(widthProperty());
		textField.focusedProperty().addListener((obs, o, isFocused) -> setBorder(isFocused ? BORDER_FOCUSED : BORDER_DEFAULT));
		// 图标  M300,396h2v4h4v2h-6Z M306,392h4v4h2v-6h-6Z
		SVGButton zoomIn = new SVGButton("M299,397h2v4h4v2h-6Z M307,391h4v4h2v-6h-6Z", FOCUSED_LIGHT);
		zoomIn.hoverProperty().addListener((obs, o, isHover) -> zoomIn.setFill(isHover ? FOCUSED_DEFAULT : FOCUSED_LIGHT));
		zoomIn.setOnAction(event -> {
			showPopup();
			getTextArea().positionCaret(getText().length());
		});
		// 弹窗
		popup = new TextAreaPopup();
		popup.getTextArea().textProperty().bindBidirectional(textField.textProperty());
		// 容器
		setMargin(zoomIn, new Insets(0, 6, 0, 0));
		setBorder(BORDER_DEFAULT);
		setAlignment(Pos.CENTER_LEFT);
		setBackground(new BgFill(WHITE).build());
		getChildren().addAll(textField, zoomIn);
	}

	public TextField getTextField() {
		return textField;
	}

	public TextArea getTextArea() {
		return popup.getTextArea();
	}

	public void setText(String text) {
		textField.setText(text);
	}

	public String getText() {
		return textField.getText();
	}

	/** 显示弹窗 */
	public void showPopup() {
		Bounds bounds = localToScreen(getBoundsInLocal());
		popup.getRoot().setPrefWidth(getWidth());
		popup.show(getScene().getWindow(), bounds.getMinX() - 5, bounds.getMinY() - 5);
	}

	/** 隐藏弹窗 */
	public void hidePopup() {
		popup.hide();
	}

	/**
	 * 文本域弹窗
	 *
	 * 夜雨 创建于 2021-06-04 22:18
	 */
	private static class TextAreaPopup extends Popup {

		private final TextArea textArea;
		private final StackPane root;

		public TextAreaPopup() {
			// 文本域
			textArea = new TextArea();
			// 阴影
			DropShadow shadow = new DropShadow();
			shadow.setRadius(6);
			shadow.setOffsetX(0);
			shadow.setOffsetY(0);
			shadow.setSpread(.05);
			shadow.setColor(Color.valueOf("#3333"));
			// 根节点
			root = new StackPane(textArea);
			root.setEffect(shadow);
			// 根容器
			StackPane shadowPane = new StackPane();
			shadowPane.setPadding(new Insets(3));
			shadowPane.getChildren().add(root);
			// 弹窗容器
			getContent().add(shadowPane);
			setAutoHide(true);
		}

		public StackPane getRoot() {
			return root;
		}

		public TextArea getTextArea() {
			return textArea;
		}

		public String getText() {
			return textArea.getText();
		}

		public void setText(String text) {
			textArea.setText(text);
		}
	}
}