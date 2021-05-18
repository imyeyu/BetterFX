package net.imyeyu.betterfx.extend;

import javafx.geometry.Insets;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;

import java.util.Random;

/**
 * JavaFX 图形界面边框封装。build() 作为导出作用，最后执行
 * <br>示例
 * <pre>
 * new XBorder("red").build();                  // 红色边框，默认样式（1 像素宽度直线，无圆角无内边距）
 * new XBorder("red").width(0, 1, 0, 1).build() // 红色直线左右边框
 * new XBorder("red").top().build()             // 红色直线上边框
 * new XBorder("red").radius(.5, true).build()  // 红色完全圆角边框
 * </pre>
 * top(), right(), bottom(), left() 不可重复使用，因为这是针对性边框宽度设置，重复使用只有最后一个有效
 *
 * 夜雨 创建于 2021-02-14 10:42
 */
public class XBorder {

	public static final Border EMPTY = Border.EMPTY;
	public static final BorderStrokeStyle NONE = BorderStrokeStyle.NONE;
	public static final BorderStrokeStyle SOLID = BorderStrokeStyle.SOLID;
	public static final BorderStrokeStyle DASHED = BorderStrokeStyle.DASHED;
	public static final BorderStrokeStyle DOTTED = BorderStrokeStyle.DOTTED;

	// 简写说明: TRBL 代表上右下左

	// 颜色
	private final Paint cT, cR, cB, cL;
	// 宽度
	private double wT, wR, wB, wL;
	// 圆角
	private double crTL, crTR, crBR, crBL;
	// 内边距
	private double pT, pR, pB, pL;
	// 圆角是否百分比
	private boolean crPercent = false;
	// 样式
	private BorderStrokeStyle bssT, bssR, bssB, bssL;

	/**
	 * 构造器初始化（参数为边框颜色）
	 *
	 * @param top    上
	 * @param right  右
	 * @param bottom 下
	 * @param left   左
	 */
	public XBorder(Paint top, Paint right, Paint bottom, Paint left) {
		cT = top;
		cR = right;
		cB = bottom;
		cL = left;
		// 默认参数
		wT = wR = wB = wL = 1;
		crTL = crTR = crBR = crBL = 0;
		pT = pR = pB = pL = 0;
		bssT = bssR = bssB = bssL = SOLID;
	}

	public XBorder(Paint color) {
		this(color, color, color, color);
	}

	public XBorder(String top, String right, String bottom, String left) {
		this(Paint.valueOf(top), Paint.valueOf(right), Paint.valueOf(bottom), Paint.valueOf(left));
	}

	public XBorder(String color) {
		this(color, color, color, color);
	}

	/**
	 * 设置宽度
	 *
	 * @param top    上
	 * @param right  右
	 * @param bottom 下
	 * @param left   左
	 *
	 * @return 边框构造器
	 */
	public XBorder width(double top, double right, double bottom, double left) {
		wT = top;
		wR = right;
		wB = bottom;
		wL = left;
		return this;
	}

	public XBorder width(double topBottom, double leftRight) {
		wT = wB = topBottom;
		wR = wL = leftRight;
		return this;
	}

	public XBorder width(double all) {
		wT = wB = wR = wL = all;
		return this;
	}

	// 指定边框
	public XBorder top() {
		wT = 1;
		wR = wB = wL = 0;
		return this;
	}

	public XBorder right() {
		wR = 1;
		wT = wB = wL = 0;
		return this;
	}

	public XBorder bottom() {
		wB = 1;
		wT = wR = wL = 0;
		return this;
	}

	public XBorder left() {
		wL = 1;
		wT = wR = wB = 0;
		return this;
	}

	public XBorder top(double width) {
		wT = width;
		wR = wB = wL = 0;
		return this;
	}

	public XBorder right(double width) {
		wR = width;
		wT = wB = wL = 0;
		return this;
	}

	public XBorder bottom(double width) {
		wB = width;
		wT = wR = wL = 0;
		return this;
	}

	public XBorder left(double width) {
		wL = width;
		wT = wR = wB = 0;
		return this;
	}

	// 除了指定边框
	public XBorder exTop() {
		wT = 0;
		wR = wB = wL = 1;
		return this;
	}

	public XBorder exRight() {
		wR = 0;
		wT = wB = wL = 1;
		return this;
	}

	public XBorder exBottom() {
		wB = 0;
		wT = wR = wL = 1;
		return this;
	}

	public XBorder exLeft() {
		wL = 0;
		wT = wR = wB = 1;
		return this;
	}

	public XBorder exTop(double width) {
		wT = 0;
		wR = wB = wL = width;
		return this;
	}

	public XBorder exRight(double width) {
		wR = 0;
		wT = wB = wL = width;
		return this;
	}

	public XBorder exBottom(double width) {
		wB = 0;
		wT = wR = wL = width;
		return this;
	}

	public XBorder exLeft(double width) {
		wL = 0;
		wT = wR = wB = width;
		return this;
	}

	/**
	 * 设置圆角
	 *
	 * @param topLeft     左上角
	 * @param topRight    右上角
	 * @param bottomRight 右下角
	 * @param bottomLeft  左下角
	 * @param asPercent   是否为百分比值（默认否）
	 *
	 * @return 边框构造器
	 */
	public XBorder radius(double topLeft, double topRight, double bottomRight, double bottomLeft, boolean asPercent) {
		crTL = topLeft;
		crTR = topRight;
		crBR = bottomRight;
		crBL = bottomLeft;
		crPercent = asPercent;
		return this;
	}

	public XBorder radius(double all, boolean asPercent) {
		crTL = crTR = crBR = crBL = all;
		crPercent = asPercent;
		return this;
	}

	public XBorder radius(double all) {
		crTL = crTR = crBR = crBL = all;
		return this;
	}

	/**
	 * 设置样式
	 *
	 * @param top    上
	 * @param right  右
	 * @param bottom 下
	 * @param left   左
	 *
	 * @return 边框构造器
	 */
	public XBorder style(BorderStrokeStyle top, BorderStrokeStyle right, BorderStrokeStyle bottom, BorderStrokeStyle left) {
		bssT = top;
		bssR = right;
		bssB = bottom;
		bssL = left;
		return this;
	}

	public XBorder style(BorderStrokeStyle all) {
		bssT = bssR = bssB = bssL = all;
		return this;
	}

	public XBorder dashed() {
		bssT = bssR = bssB = bssL = DASHED;
		return this;
	}

	public XBorder dotted() {
		bssT = bssR = bssB = bssL = DOTTED;
		return this;
	}

	/**
	 * 设置内边距
	 *
	 * @param top    上
	 * @param right  右
	 * @param bottom 下
	 * @param left   左
	 *
	 * @return 边框构造器
	 */
	public XBorder padding(double top, double right, double bottom, double left) {
		pT = top;
		pR = right;
		pB = bottom;
		pL = left;
		return this;
	}

	public XBorder padding(double topBottom, double leftRight) {
		pT = pB = topBottom;
		pL = pR = leftRight;
		return this;
	}

	public XBorder padding(double all) {
		pT = pB = pL = pR = all;
		return this;
	}

	/**
	 * 构造边框
	 *
	 * @return 边框
	 */
	public Border build() {
		return new Border(new BorderStroke(
			cT, cR, cB, cL,
			bssT, bssR, bssB, bssL,
			new CornerRadii(crTL, crTR, crBR, crBL, crPercent),
			new BorderWidths(wT, wR, wB, wL),
			new Insets(pT, pR, pB, pL)
		));
	}

	/**
	 * 快速构造测试边框
	 *
	 * @param color 颜色
	 *
	 * @return 边框
	 */
	public static Border test(String color) {
		return new XBorder(color).build();
	}

	/**
	 * 快速构造测试边框
	 *
	 * @return 边框
	 */
	public static Border test() {
		Random r = new Random();
		StringBuilder sb = new StringBuilder("#");
		for (int i = 0; i < 6; i++) {
			sb.append(r.nextInt(8));
		}
		return test(sb.toString());
	}
}