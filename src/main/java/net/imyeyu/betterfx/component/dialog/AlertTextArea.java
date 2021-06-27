package net.imyeyu.betterfx.component.dialog;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 带文本域的弹窗
 *
 * 夜雨 创建于 2021-06-12 00:39
 */
public class AlertTextArea extends Alert {

	private final Label label;
	private final TextArea textArea;

	public AlertTextArea(AlertType alertType) {
		this(alertType, "");
	}

	public AlertTextArea(AlertType alertType, String contentTextArea, ButtonType... buttons) {
		this(alertType, "", contentTextArea, buttons);
	}

	public AlertTextArea(AlertType alertType, String contentText, Throwable throwable, ButtonType... buttons) {
		this(alertType, contentText, "", ButtonType.OK);
		try {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw, true);
			throwable.printStackTrace(pw);
			textArea.setText(sw.toString());
			pw.flush();
			pw.close();
			sw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public AlertTextArea(AlertType alertType, String contentText, String contentTextArea, ButtonType... buttons) {
		super(alertType, contentText, buttons);

		label = new Label(contentText);
		textArea = new TextArea(contentTextArea);
		textArea.setEditable(false);
		textArea.setPrefWidth(460);

		BorderPane root = new BorderPane();
		BorderPane.setMargin(textArea, new Insets(8, 0, 0, 0));
		root.setTop(label);
		root.setCenter(textArea);

		getDialogPane().setContent(root);
		getStage().setResizable(true);
	}

	public void setLabelContent(String content) {
		label.setText(content);
	}

	public void setTextAreaContent(String content) {
		textArea.setText(content);
	}
}