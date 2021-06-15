package net.imyeyu.betterfx.bean;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * 弹窗提示，由 PopupTipsService 安装
 *
 * 夜雨 创建于 2021/4/23 00:46
 */
public class PopupTips {

	private static final Insets PADDING_TEXT = new Insets(4, 8, 4, 8);

	private Node node;               // 该弹窗面板
	private OnShow onShow;           // 显示后事件
	private OnHide onHide;           // 隐藏后事件
	private boolean isEnable = true; // 是否启用
	private ChangeListener<Boolean> hoverListener; // 悬停事件（不建议修改它）

	public PopupTips() {}

	public PopupTips(String text) {
		setText(text);
	}

	public PopupTips(Image image) {
		setImage(image);
	}

	public PopupTips(Node node) {
		this.node = node;
	}

	/**
	 * 设置为文本提示
	 *
	 * @param text 文本内容
	 */
	public void setText(String text) {
		if (node instanceof Label label) {
			label.setText(text);
		} else {
			Label label = new Label(text);
			label.setPadding(PADDING_TEXT);
			label.setWrapText(true);
			node = label;
		}
	}

	/**
	 * 设置为图像提示
	 *
	 * @param image 图片
	 */
	public void setImage(Image image) {
		if (node instanceof ImageView imageView) {
			imageView.setImage(image);
		} else {
			node = new ImageView(image);
		}
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public OnShow getOnShow() {
		return onShow;
	}

	public void setOnShow(OnShow onShow) {
		this.onShow = onShow;
	}

	public OnHide getOnHide() {
		return onHide;
	}

	public void setOnHide(OnHide onHide) {
		this.onHide = onHide;
	}

	public void setEnable(boolean enable) {
		isEnable = enable;
	}

	public boolean isEnable() {
		return isEnable;
	}

	public ChangeListener<Boolean> getHoverListener() {
		return hoverListener;
	}

	public void setHoverListener(ChangeListener<Boolean> hoverListener) {
		this.hoverListener = hoverListener;
	}

	/**
	 * 显示弹窗后事件
	 *
	 * 夜雨 创建于 2021/4/23 00:44
	 */
	public interface OnShow {
		void handler(StackPane root, Node node);
	}

	/**
	 * 隐藏弹窗后事件
	 *
	 * 夜雨 创建于 2021/4/23 00:45
	 */
	public interface OnHide {
		void handler();
	}
}