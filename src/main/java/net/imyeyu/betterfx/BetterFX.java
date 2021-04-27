package net.imyeyu.betterfx;

import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Paint;
import net.imyeyu.betterfx.extend.BgFill;
import net.imyeyu.betterfx.extend.XBorder;

/**
 * 更好的 FX，由 PixelFX 脱离
 * @see <a href="https://github.com/imyeyu/PixelFX">PixelFX in Github</a>
 * <br>
 *
 * 夜雨 创建于 2021/2/14 10:51
 */
public class BetterFX {

	public static final String VERSION = "1.2.0";

	/** 样式文件 */
	public static final String CSS = "betterfx/betterfx.css";

	/** 白色 */
	public static final Paint WHITE       = Paint.valueOf("#FFF");
	/** 品红 */
	public static final Paint RED         = Paint.valueOf("#F30");
	/** 褐色 */
	public static final Paint BROWN       = Paint.valueOf("#A67D7B");
	/** 黑色 */
	public static final Paint BLACK       = Paint.valueOf("#000");
	/** 橙色 */
	public static final Paint ORANGE      = Paint.valueOf("#F60");
	/** 绿色 */
	public static final Paint GREEN       = Paint.valueOf("#393");
	/** 灰色 */
	public static final Paint GRAY        = Paint.valueOf("#666");
	/** 天蓝 */
	public static final Paint BLUE        = Paint.valueOf("#008DCB");
	/** 灰白（程序默认底色 F4F4F4） */
	public static final Paint GRAY_WHITE  = Paint.valueOf("#F4F4F4");
	/** 亮灰 */
	public static final Paint LIGHT_GRAY  = Paint.valueOf("#CCC");
	/** 深灰 */
	public static final Paint DARK_GRAY   = Paint.valueOf("#333");
	/** 少女粉 */
	public static final Paint PINK        = Paint.valueOf("#FF7A9B");
	/** 透明 */
	public static final Paint TRANSPARENT = Paint.valueOf("#FFFFFF00");

	/** 聚焦颜色（靛青） */
	public static final Paint FOCUSED_COLOR = Paint.valueOf("#177CB0");

	// 边框
	public static final Border BORDER_DEFAULT = new XBorder(LIGHT_GRAY).build();
	public static final Border BORDER_FOCUSED = new XBorder(FOCUSED_COLOR).build();

	// 单四边
	public static final Border BORDER_TOP = new XBorder(LIGHT_GRAY).top().build();
	public static final Border BORDER_LEFT = new XBorder(LIGHT_GRAY).left().build();
	public static final Border BORDER_RIGHT = new XBorder(LIGHT_GRAY).right().build();
	public static final Border BORDER_BOTTOM = new XBorder(LIGHT_GRAY).bottom().build();
	// 除了某边
	public static final Border BORDER_EXTOP = new XBorder(LIGHT_GRAY).exTop().build();
	public static final Border BORDER_EXLEFT = new XBorder(LIGHT_GRAY).exLeft().build();
	public static final Border BORDER_EXRIGHT = new XBorder(LIGHT_GRAY).exRight().build();
	public static final Border BORDER_EXBOTTOM = new XBorder(LIGHT_GRAY).exBottom().build();
	// 垂直和水平边（边的方向而非位置）
	public static final Border BORDER_H = new XBorder(LIGHT_GRAY).width(1, 0).build();
	public static final Border BORDER_V = new XBorder(LIGHT_GRAY).width(0, 1).build();

	// 背景颜色
	public static final Background BG_DEFAULT = new BgFill(GRAY_WHITE).build();
	public static final Background BG_WHITE = new BgFill(WHITE).build();
	public static final Background BG_TP = new BgFill(TRANSPARENT).build();
}