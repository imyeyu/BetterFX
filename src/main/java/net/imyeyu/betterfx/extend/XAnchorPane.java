package net.imyeyu.betterfx.extend;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class XAnchorPane extends AnchorPane {
	
	/**
	 * 设置 AnchorPane 四边间距，传值 null 为不设定
	 * 
	 * @param node   组件
	 * @param top    上
	 * @param right  右
	 * @param bottom 下
	 * @param left   左
	 */
	public static void def(Node node, Number top, Number right, Number bottom, Number left) {
		if (top != null) setTopAnchor(node, top.doubleValue());
		if (left != null) setLeftAnchor(node, left.doubleValue());
		if (right != null) setRightAnchor(node, right.doubleValue());
		if (bottom != null) setBottomAnchor(node, bottom.doubleValue());
	}
	
	/**
	 * 四边完全贴紧父级组件
	 * 
	 * @param node 组件
	 */
	public static void def(Node node) {
		def(node, 0, 0, 0, 0);
	}
	
	/**
	 * 设置 AnchorPane 四边边距
	 * 
	 * @param node 组件
	 * @param size 大小
	 */
	public static void def(Node node, Number size) {
		def(node, size, size, size, size);
	}
	
	/**
	 * 设置 AnchorPane 上下和左右边距
	 * 
	 * @param node      组件
	 * @param topBottom 上下
	 * @param leftRight 左右
	 */
	public static void def(Node node, Number topBottom, Number leftRight) {
		def(node, topBottom, leftRight, topBottom, leftRight);
	}

	/**
	 * 除了上边，其他贴紧父级组件
	 * 
	 * @param node 组件
	 */
	public static void exTop(Node node) {
		def(node, null, 0, 0, 0);
	}

	/**
	 * 除了左边，其他贴紧父级组件
	 * 
	 * @param node 组件
	 */
	public static void exLeft(Node node) {
		def(node, 0, 0, 0, null);
	}

	/**
	 * 除了右边，其他贴紧父级组件
	 * 
	 * @param node 组件
	 */
	public static void exRight(Node node) {
		def(node, 0, null, 0, 0);
	}

	/**
	 * 除了下边，其他贴紧父级组件
	 * 
	 * @param node 组件
	 */
	public static void exBottom(Node node) {
		def(node, 0, 0, null, 0);
	}
}