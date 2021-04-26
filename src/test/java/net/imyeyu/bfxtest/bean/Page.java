package net.imyeyu.bfxtest.bean;

import javafx.scene.Node;

/**
 * 列表页面
 *
 * 夜雨 创建于 2021/4/13 09:54
 */
public class Page {

	private String title;
	private Node node;
	private OnSelected onSelected;

	public Page(String title) {
		this.title = title;
	}

	public Page(String title, OnSelected onSelected) {
		this.title = title;
		this.onSelected = onSelected;
	}

	public Page(String title, Node node) {
		this.title = title;
		this.node = node;
	}

	public Page(String title, Node node, OnSelected onSelected) {
		this.title = title;
		this.node = node;
		this.onSelected = onSelected;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public OnSelected getOnSelected() {
		return onSelected;
	}

	public void setOnSelected(OnSelected onSelected) {
		this.onSelected = onSelected;
	}

	/**
	 * 选择事件（返回 false 阻止切换）
	 *
	 * 夜雨 创建于 2021/4/26 15:15
	 */
	public interface OnSelected {
		boolean handler(Page page);
	}
}