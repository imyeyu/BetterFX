package net.imyeyu.betterfx.component;

import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.text.TextFlow;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * 动态超链标签，默认点击会调用默认浏览器打开链接，如果超链为空，显示为不可点击的普通标签
 *
 * 夜雨 创建于 2021-06-10 21:54
 */
public class XHyperlink extends TextFlow {

	private String url;
	private final Label label;
	private final Hyperlink link;

	BeforeOpen beforeOpen;

	public XHyperlink() {
		this("");
	}

	public XHyperlink(String url) {
		this(url, null);
	}

	public XHyperlink(String url, String text) {
		this.url = url;

		if (text == null || "".equals(text.trim())) {
			link = new Hyperlink(url);
		} else {
			link = new Hyperlink(text);
		}
		label = new Label(text);

		link.setOnAction(event -> {
			if (beforeOpen != null) {
				this.url = beforeOpen.handler(this.url);
			}
			try {
				Desktop dp = Desktop.getDesktop();
				if (dp.isSupported(Desktop.Action.BROWSE)) {
					dp.browse(new URL(this.url).toURI());
				}
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
			}
		});
		setURL(url);
	}

	/**
	 * 设置超链
	 *
	 * @param url 超链
	 */
	public void setURL(String url) {
		this.url = url;
		if (url == null || "".equals(url.trim())) {
			getChildren().setAll(label);
		} else {
			getChildren().setAll(link);
		}
	}

	/**
	 * 设置文本
	 *
	 * @param text 内容
	 */
	public void setText(String text) {
		label.setText(text);
		link.setText(text);
	}

	public void setBeforeOpen(BeforeOpen beforeOpen) {
		this.beforeOpen = beforeOpen;
	}

	public Label getLabel() {
		return label;
	}

	public Hyperlink getLink() {
		return link;
	}

	/**
	 * 打开超链前事件（参数 URL，回调 URL）
	 *
	 * 夜雨 创建于 2021-06-10 22:26
	 */
	public interface BeforeOpen {

		String handler(String url);
	}
}