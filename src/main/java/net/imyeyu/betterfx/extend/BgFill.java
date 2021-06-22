package net.imyeyu.betterfx.extend;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;

import java.util.Random;

/**
 * <br>背景填充封装，支持渐变背景。build() 作为导出作用，最后执行
 * <pre>
 * new BgFill("red").build()                                 // 创建简单的背景填充
 * new BgFill("red", "blue").toRight().build()               // 创建由红到蓝，从左往右的渐变填充背景
 * new BgFill("red").radii(bgRadii).insets(bgInsets).build() // 设置圆角率和边距
 * </pre>
 * 
 * 夜雨 创建于 2021-02-13 12:52
 */
public class BgFill {
	
	private Stop[] stops;
	private Background bg;
	private Paint linearGradient;

	// 自定义圆角和内边距
	private Insets insets;
	private CornerRadii radii;
	
	/**
	 * 构造背景
	 * 
	 * @param color 颜色
	 * @return 背景
	 */
	private Background createBgFill(Paint color) {
		radii = radii == null ? CornerRadii.EMPTY : radii;
		insets = insets == null ? Insets.EMPTY : insets;
		return new Background(new BackgroundFill(color, radii, insets));
	}

	public BgFill(Paint color) {
		bg = createBgFill(color);
	}

	public BgFill(String color) {
		bg = createBgFill(Paint.valueOf(color));
	}

	/**
	 * 渐变背景
	 * 
	 * @param start 起点颜色
	 * @param end   结束颜色
	 */
	public BgFill(String start, String end) {
		stops = new Stop[] { new Stop(0, Color.valueOf(start)), new Stop(1, Color.valueOf(end))};
		bg = createBgFill(linearGradient);
	}
	
	// 设置圆角
	public BgFill radii(CornerRadii radii) {
		this.radii = radii;
		return this;
	}
	// 设置内边距
	public BgFill insets(Insets insets) {
		this.insets = insets;
		return this;
	}
	public BgFill insets(double insets) {
		this.insets = new Insets(insets);
		return this;
	}
	public BgFill insets(double topBottom, double leftRight) {
		this.insets = new Insets(topBottom, leftRight, topBottom, leftRight);
		return this;
	}
	public BgFill insets(double top, double right, double bottom, double left) {
		this.insets = new Insets(top, right, bottom, left);
		return this;
	}
	
	/**
	 * 从左往右渐变
	 * 
	 * @return 填充背景构造器
	 */
	public BgFill toRight() {
		if (stops == null) throw new NullPointerException("请使用 BgFill(start, end) 构造方法设置起点颜色和终点颜色");
		linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
		bg = createBgFill(linearGradient);
		return this;
	}
	
	/**
	 * 从上往下渐变
	 * 
	 * @return 填充背景构造器
	 */
	public BgFill toBottom() {
		if (stops == null) throw new NullPointerException("请使用 BgFill(start, end) 构造方法设置起点颜色和终点颜色");
		linearGradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);
		bg = createBgFill(linearGradient);
		return this;
	}
	
	/**
	 * 导出背景
	 * 
	 * @return 背景
	 */
	public Background build() {
		return bg;
	}
	
	/**
	 * 快速构造测试背景
	 * 
	 * @return 背景
	 */
	public static Background test() {
		Random r = new Random();
		StringBuilder sb = new StringBuilder("#");
		for (int i = 0; i < 6; i++) {
			sb.append(r.nextInt(8));
		}
		return new BgFill(sb.toString()).build();
	}
}