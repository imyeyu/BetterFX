package net.imyeyu.betterfx.extend;

import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 背景图片封装。build() 作为导出作用，最后执行
 * 默认原图大小，不平铺，居原点
 * new BgImage("/cover.png").cover().build()
 *
 * 夜雨 创建于 2021-02-13 12:53
 */
public class BgImage {
	
	private BackgroundRepeat repeatX, repeatY;

	private Side sideH, sideV;
	private double posH, posV, sizeW, sizeH;
	private boolean posHAsPercent, posVAsPercent, sizeWAsPercent, sizeHAsPercent, isContain, isCover;

	private final Image img;

	/**
	 * 背景图构造器
	 *
	 * @param url 图片位置（程序内资源）
	 */
	public BgImage(String url) {
		this(new Image(url));
	}

	/**
	 * 背景图构造器
	 *
	 * @param file 图片文件（程序外资源）
	 */
	public BgImage(File file) throws FileNotFoundException {
		this(new Image(new FileInputStream(file)));
	}

	/**
	 * 背景图构造器
	 *
	 * @param img 图像
	 */
	public BgImage(Image img) {
		this.img = img;
		// 初始化数据
		repeatX = repeatY = BackgroundRepeat.REPEAT;
		sideH = Side.LEFT;
		sideV = Side.TOP;
		posH = posV = 0;
		sizeW = img.getWidth();
		sizeH = img.getHeight();
		posHAsPercent = posVAsPercent = sizeWAsPercent = sizeHAsPercent = isContain = isCover = false;
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
	 * 背景位置
	 *
	 * @param sideH      相对水平位置，左或右
	 * @param posH       相对水平距离
	 * @param hAsPercent true 为水平距离是百分比
	 * @param sideV      相对垂直位置，上或下
	 * @param posV       相对垂直距离
	 * @param vAsPercent true 为垂直距离是百分比
	 * @return 图像背景构造器
	 */
	public BgImage pos(Side sideH, double posH, boolean hAsPercent, Side sideV, double posV, boolean vAsPercent) {
		this.sideH = sideH;
		this.sideV = sideV;
		this.posH = posH;
		this.posV = posV;
		this.posHAsPercent = hAsPercent;
		this.posVAsPercent = vAsPercent;
		return this;
	}

	/**
	 * 水平对齐方式
	 *
	 * @param side      相对位置
	 * @param size      相对距离
	 * @param asPercent true 百分比数据
	 * @return 图像背景构造器
	 */
	public BgImage horizontal(Side side, double size, boolean asPercent) {
		sideH = side;
		posH = size;
		posHAsPercent = asPercent;
		return this;
	}

	/**
	 * 居左
	 *
	 * @param size 距离
	 * @return 图像背景构造器
	 */
	public BgImage left(double size) {
		return horizontal(Side.LEFT, size, false);
	}

	/**
	 * 居右
	 *
	 * @param size 距离
	 * @return 图像背景构造器
	 */
	public BgImage right(double size) {
		return horizontal(Side.RIGHT, size, false);
	}

	/**
	 * 垂直对齐方式
	 *
	 * @param side      相对位置
	 * @param size      相对距离
	 * @param asPercent true 百分比数据
	 * @return 图像背景构造器
	 */
	public BgImage vertical(Side side, double size, boolean asPercent) {
		sideV = side;
		posV = size;
		posVAsPercent = asPercent;
		return this;
	}

	/**
	 * 居上
	 *
	 * @param size 距离
	 * @return 图像背景构造器
	 */
	public BgImage top(double size) {
		return vertical(Side.TOP, size, false);
	}


	/**
	 * 居下
	 *
	 * @param size 距离
	 * @return 图像背景构造器
	 */
	public BgImage bottom(double size) {
		return vertical(Side.BOTTOM, size, false);
	}

	/**
	 * 坐标轴定位
	 *
	 * @param x 轴
	 * @param y 轴
	 * @return 图像背景构造器
	 */
	public BgImage xy(double x, double y) {
		sideH = Side.LEFT;
		sideV = Side.TOP;
		posH = x;
		posV = y;
		posHAsPercent = posVAsPercent = false;
		return this;
	}

	/**
	 * 图像大小
	 *
	 * @param width           宽度
	 * @param height          高度
	 * @param widthAsPercent  true 为参数是百分比
	 * @param heightAsPercent true 为参数是百分比
	 * @param isContain       true 为尽量最大化图像
	 * @param isCover         true 为保持比例
	 * @return 图像背景构造器
	 */
	public BgImage size(double width, double height, boolean widthAsPercent, boolean heightAsPercent, boolean isContain, boolean isCover) {
		sizeW = width;
		sizeH = height;
		sizeWAsPercent = widthAsPercent;
		sizeHAsPercent = heightAsPercent;
		this.isContain = isContain;
		this.isCover = isCover;
		return this;
	}

	/**
	 * 自适应保持比例时尽量最大化的背景
	 *
	 * @return 图像背景构造器
	 */
	public BgImage cover() {
		return size(-1, -1, true, true, true, true);
	}

	public BgImage center() {
		sideH = Side.LEFT;
		sideV = Side.TOP;
		posH = posV = 0;
		posHAsPercent = posVAsPercent = true;
		return this;
	}

	/** @return 最终构造背景 */
	public Background build() {
		return new Background(
			new BackgroundImage(
				img,
				repeatX, repeatY,
				new BackgroundPosition(
					sideH, posH, posHAsPercent,
					sideV, posV, posVAsPercent
				), new BackgroundSize(
					sizeW, sizeH,
					sizeWAsPercent,sizeHAsPercent,
					isContain,
					isCover
				)
			)
		);
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