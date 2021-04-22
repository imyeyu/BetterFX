package bean;

import javafx.scene.Node;

/**
 * 列表页面
 *
 * 夜雨 创建于 2021/4/13 09:54
 */
public class Page {

	private String title;
	private Node node;

	public Page(String title, Node node) {
		this.title = title;
		this.node = node;
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
}