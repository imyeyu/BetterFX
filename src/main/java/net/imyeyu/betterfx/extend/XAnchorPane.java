package net.imyeyu.betterfx.extend;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 * 锚点布局简化操作
 *
 * 夜雨 创建于 2021-05-16 23:31
 */
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
	 * 根据左上角定位
	 *
	 * @param node 组件
	 * @param left 距离左边
	 * @param top  距离上边
	 */
	public static void leftTop(Node node, Number left, Number top) {
		def(node, top, null, null, left);
	}

	/**
	 * 根据右上角定位
	 *
	 * @param node  组件
	 * @param right 距离右边
	 * @param top   距离上边
	 */
	public static void rightTop(Node node, Number right, Number top) {
		def(node, top, right, null, null);
	}

	/**
	 * 根据左下角定位
	 *
	 * @param node   组件
	 * @param left   距离左边
	 * @param bottom 距离下边
	 */
	public static void leftBottom(Node node, Number left, Number bottom) {
		def(node, null, null, bottom, left);
	}

	/**
	 * 根据右下角定位
	 *
	 * @param node   组件
	 * @param right  距离右边
	 * @param bottom 距离下边
	 */
	public static void rightBottom(Node node, Number right, Number bottom) {
		def(node, null, right, bottom, null);
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