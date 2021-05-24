package net.imyeyu.betterfx.extend;

import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

/**
 * 背景图片封装。build() 作为导出作用，最后执行
 * 默认原图大小，不平铺，居原点
 * new BgImage("/cover.png").cover().build()
 * 
 * 夜雨 创建于 2021-02-13 12:53
 */
public class BgImage {
	
	private BackgroundRepeat repeatX, repeatY;
	private BackgroundPosition pos;
	private BackgroundSize size;
	
	private Side sideH, sideV;
	private double posH, posV;
	private boolean posHAsPercent = false, posVAsPercent = false;
	
	private final Image img;
	
	/**
	 * 重置位置对象
	 * 
	 */
	private void resetPos() {
		sideH = sideH == null ? Side.LEFT : sideH;
		sideV = sideV == null ? Side.TOP : sideV;
		pos = new BackgroundPosition(sideH, posH, posHAsPercent, sideV, posV, posVAsPercent);
	}

	/**
	 * 构造背景图
	 *
	 * @param url 图片位置
	 */
	public BgImage(String url) {
		this(new Image(url));
	}
	public BgImage(Image img) {
		this.img = img;
		repeatX = repeatY = BackgroundRepeat.NO_REPEAT;
		pos = BackgroundPosition.DEFAULT;
		size = BackgroundSize.DEFAULT;
		posH = posV = 0;
	}
	
	/**
	 * 双轴平铺方式
	 * 
	 * @param repeat 填充方式
	 * @return 图像背景构造器
	 */
	public BgImage repeat(BackgroundRepeat repeat) {
		repeatX = repeatY = repeat;
		return this;
	}
	/**
	 * X 轴平铺方式
	 * 
	 * @param repeat 填充方式
	 * @return 图像背景构造器
	 */
	public BgImage repeatX(BackgroundRepeat repeat) {
		repeatX = repeat;
		return this;
	}
	/**
	 * Y 轴平铺方式
	 * 
	 * @param repeat 填充方式
	 * @return 图像背景构造器
	 */
	public BgImage repeatY(BackgroundRepeat repeat) {
		repeatY = repeat;
		return this;
	}

	/**
	 * 水平对齐方式
	 * 
	 * @param side      相对位置
	 * @param size      相对距离
	 * @param asPercent 是否为百分比
	 * @return 图像背景构造器
	 */
	public BgImage horizontal(Side side, double size, boolean asPercent) {
		sideH = side;
		posH = size;
		posHAsPercent = asPercent;
		resetPos();
		return this;
	}
	public BgImage left(double size) {
		return horizontal(Side.LEFT, size, false);
	}
	public BgImage right(double size) {
		return horizontal(Side.RIGHT, size, false);
	}

	/**
	 * 垂直对齐方式
	 * 
	 * @param side      相对位置
	 * @param size      相对距离
	 * @param asPercent 是否为百分比
	 * @return 图像背景构造器
	 */
	public BgImage vertical(Side side, double size, boolean asPercent) {
		sideV = side;
		posV = size;
		posVAsPercent = asPercent;
		resetPos();
		return this;
	}
	public BgImage top(double size) {
		return vertical(Side.TOP, size, false);
	}
	public BgImage bottom(double size) {
		return vertical(Side.BOTTOM, size, false);
	}
	
	/**
	 * 图像大小
	 * 
	 * @param width           宽度
	 * @param height          高度
	 * @param widthAsPercent  宽度是否为百分比
	 * @param heightAsPercent 高度是否为百分比
	 * @param isContain       尽量最大化图像
	 * @param isCover         保持比例
	 * @return 图像背景构造器
	 */
	public BgImage size(double width, double height, boolean widthAsPercent, boolean heightAsPercent, boolean isContain, boolean isCover) {
		size = new BackgroundSize(width, height, widthAsPercent, heightAsPercent, isContain, isCover);
		return this;
	}
	public BgImage cover() {
		return size(-1, -1, true, true, true, true);
	}
	public BgImage coverCenter() {
		return size(1, -1, true, false, false, false).vertical(Side.TOP, .5, true);
	}
	
	/**
	 * 居中图像
	 * 
	 * @return 图像背景构造器
	 */
	public BgImage center() {
		pos = BackgroundPosition.CENTER;
		return this;
	}
	
	/**
	 * 构造背景图
	 * 
	 * @return 背景
	 */
	public Background build() {
		return new Background(new BackgroundImage(img, repeatX, repeatY, pos, size));
	}


	/**
	 * JavaFX 设置组件背景，底色为默认
	 *
	 * @param node  节点
	 * @param url   背景路径
	 * @param width 宽度
	 * @param x     X 轴偏移
	 * @param y     Y 轴偏移
	 */
	public static void setBg(Node node, String url, int width, int x, int y) {
		node.setStyle(
			"-fx-background-size: " + width + ";" +
			"-fx-background-image: url('" + url + "');" +
			"-fx-background-insets: 0;" +
			"-fx-background-repeat: no-repeat;" +
			"-fx-background-position: " + x + " " + y
		);
	}

	/**
	 * JavaFX 设置组件背景，底色为透明
	 *
	 * @param node  节点
	 * @param url   背景路径
	 * @param width 宽度
	 * @param x     X 轴偏移
	 * @param y     Y 轴偏移
	 */
	public static void setBgTp(Node node, String url, int width, int x, int y) {
		node.setStyle(
			"-fx-background-size: " + width + ";" +
			"-fx-background-image: url('" + url + "');" +
			"-fx-background-color: transparent;" +
			"-fx-background-insets: 0;" +
			"-fx-background-repeat: no-repeat;" +
			"-fx-background-position: " + x + " " + y
		);
	}
}