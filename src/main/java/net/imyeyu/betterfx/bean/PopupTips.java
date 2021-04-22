package net.imyeyu.betterfx.bean;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * 弹窗提示，由 PopupTipsService 安装
 *
 * 夜雨 创建于 2021/4/23 00:46
 */
public class PopupTips {

	private static final Insets PADDING_TEXT = new Insets(4, 8, 4, 8);

	private Node node;     // 该弹窗面板
	private OnShow onShow; // 显示后事件
	private OnHide onHide; // 隐藏后事件
	private ChangeListener<Boolean> hoverListener; // 悬停事件（不建议修改它）

	public PopupTips() {}

	public PopupTips(String text) {
		Label label = new Label(text);
		label.setPadding(PADDING_TEXT);
		label.setWrapText(true);

		node = label;
	}

	public PopupTips(Image image) {
		node = new ImageView(image);
	}

	public PopupTips(Node node) {
		this.node = node;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PopupTips popupTips = (PopupTips) o;
		return Objects.equals(node, popupTips.node) && Objects.equals(onShow,
		                                                              popupTips.onShow
		) && Objects.equals(onHide, popupTips.onHide) && Objects.equals(hoverListener, popupTips.hoverListener);
	}

	@Override
	public int hashCode() {
		return Objects.hash(node, onShow, onHide, hoverListener);
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
		void handler();
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