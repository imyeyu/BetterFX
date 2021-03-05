package net.imyeyu.betterfx.extend;

import javafx.geometry.Side;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

/**
 * 背景图片封装。build() 作为导出作用，最后执行
 * 默认原图大小，不平铺，居原点
 * 
 * 夜雨 创建于 2021/2/13 12:53
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
	 * @param img 图片位置
	 */
	public BgImage(Image img) {
		this.img = img;
		repeatX = repeatY = BackgroundRepeat.NO_REPEAT;
		pos = BackgroundPosition.DEFAULT;
		size = BackgroundSize.DEFAULT;
		posH = posV = 0;
	}
	public BgImage(String url) {
		this(new Image(url));
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
}