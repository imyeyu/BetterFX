package net.imyeyu.betterfx.util;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * 让无系统边框窗体支持下、右下、右缩放
 *
 * 夜雨 创建于 2021/4/9 21:58
 */
public class Resizable {

	private static boolean isRight, isBottom, isBottomRight;
	private final static int RESIZE_WIDTH = 4;

	/**
	 * 无边框窗体的可缩放监听
	 *
	 * @param stage     窗体
	 * @param root      监听节点
	 * @param minWidth  最小宽度
	 * @param minHeight 最小高度
	 */
	private static void initResizeStageEvent(Stage stage, Node root, double minWidth, double minHeight, boolean debug) {
		root.setOnMouseMoved((MouseEvent event) -> {
			event.consume();
			double x = event.getSceneX();
			double y = event.getSceneY();
			double width = stage.getWidth();
			double height = stage.getHeight();
			Cursor cursorType = Cursor.DEFAULT;
			// 重置
			isRight = isBottomRight = isBottom = false;
			if (height - RESIZE_WIDTH <= y) {
				if (width - RESIZE_WIDTH <= x) {
					// 右下角调整
					isBottomRight = true;
					cursorType = Cursor.SE_RESIZE;
				} else {
					// 下边调整
					isBottom = true;
					cursorType = Cursor.S_RESIZE;
				}
			} else if (width - RESIZE_WIDTH <= x) {
				// 右边调整
				isRight = true;
				cursorType = Cursor.E_RESIZE;
			}
			// 最后改变鼠标光标
			root.setCursor(cursorType);
		});

		root.setOnMouseDragged((MouseEvent event) -> {
			double x = event.getSceneX();
			double y = event.getSceneY();
			// 保存窗口改变后的 x, y 坐标和宽度/高度, 预判是否会小于最小尺寸
			double nextX = stage.getX();
			double nextY = stage.getY();
			double nextWidth = stage.getWidth();
			double nextHeight = stage.getHeight();
			if (isRight || isBottomRight) {
				// 右边调整窗口
				nextWidth = x;
			}
			if (isBottomRight || isBottom) {
				// 下边调整窗口
				nextHeight = y;
			}
			if (nextWidth <= minWidth) {
				// 限宽
				nextWidth = minWidth;
			}
			if (nextHeight <= minHeight) {
				// 限高
				nextHeight = minHeight;
			}
			// 修改窗口 x、y 坐标和宽度, 高度
			stage.setX(nextX);
			stage.setY(nextY);
			stage.setWidth(nextWidth);
			stage.setHeight(nextHeight);
		});
	}

	public static void add(Stage stage, Node root, double minWidth, double minHeight) {
		initResizeStageEvent(stage, root, minWidth, minHeight, false);
	}

	public static void add(Stage stage, Node root, double minWidth, double minHeight, boolean debug) {
		initResizeStageEvent(stage, root, minWidth, minHeight, debug);
	}

	public static void remove(Node root) {
		root.setOnMouseMoved(null);
		root.setOnMouseDragged(null);
	}
}
