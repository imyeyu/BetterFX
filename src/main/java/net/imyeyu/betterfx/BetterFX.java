package net.imyeyu.betterfx;

import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Paint;
import net.imyeyu.betterfx.extend.BgFill;
import net.imyeyu.betterfx.extend.XBorder;

/**
 * 更好的 FX
 * @see <a href="https://github.com/imyeyu/PixelFX">PixelFX in Github</a>
 * <br>
 *
 * 夜雨 创建于 2021-02-14 10:51
 */
public interface BetterFX {

	/** 版本号 */
	String VERSION = "1.3.4";
	/** 静态资源路径 */
	String STATIC_DIR = "/betterfx/";
	/** 样式文件 */
	String CSS = STATIC_DIR + "style.css";

	/** 白色 */
	Paint WHITE       = Paint.valueOf("#FFF");
	/** 品红 */
	Paint RED         = Paint.valueOf("#F30");
	/** 褐色 */
	Paint BROWN       = Paint.valueOf("#A67D7B");
	/** 黑色 */
	Paint BLACK       = Paint.valueOf("#000");
	/** 橙色 */
	Paint ORANGE      = Paint.valueOf("#F60");
	/** 黄色 */
	Paint YELLOW      = Paint.valueOf("#FF0");
	/** 绿色 */
	Paint GREEN       = Paint.valueOf("#393");
	/** 灰色 */
	Paint GRAY        = Paint.valueOf("#666");
	/** 天蓝 */
	Paint BLUE        = Paint.valueOf("#008DCB");
	/** 灰白（程序默认底色 F4F4F4） */
	Paint GRAY_WHITE  = Paint.valueOf("#F4F4F4");
	/** 亮灰 */
	Paint LIGHT_GRAY  = Paint.valueOf("#CCC");
	/** 深灰 */
	Paint DARK_GRAY   = Paint.valueOf("#333");
	/** 少女粉 */
	Paint PINK        = Paint.valueOf("#FF7A9B");
	/** 透明 */
	Paint TRANSPARENT = Paint.valueOf("#FFFFFF00");

	/** 聚焦颜色（靛青） */
	Paint FOCUSED_DEFAULT = Paint.valueOf("#177CB0");
	Paint FOCUSED_LIGHT = Paint.valueOf("#55B0DF");
	Paint FOCUSED_BLACK = Paint.valueOf("#0B6C9E");

	// 边框
	Border BORDER_DEFAULT = new XBorder(LIGHT_GRAY).build();
	Border BORDER_FOCUSED = new XBorder(FOCUSED_DEFAULT).build();
	// 单四边
	Border BORDER_TOP = new XBorder(LIGHT_GRAY).top().build();
	Border BORDER_LEFT = new XBorder(LIGHT_GRAY).left().build();
	Border BORDER_RIGHT = new XBorder(LIGHT_GRAY).right().build();
	Border BORDER_BOTTOM = new XBorder(LIGHT_GRAY).bottom().build();
	// 除了某边
	Border BORDER_EXTOP = new XBorder(LIGHT_GRAY).exTop().build();
	Border BORDER_EXLEFT = new XBorder(LIGHT_GRAY).exLeft().build();
	Border BORDER_EXRIGHT = new XBorder(LIGHT_GRAY).exRight().build();
	Border BORDER_EXBOTTOM = new XBorder(LIGHT_GRAY).exBottom().build();
	// 垂直和水平边（边的方向而非位置）
	Border BORDER_H = new XBorder(LIGHT_GRAY).width(1, 0).build();
	Border BORDER_V = new XBorder(LIGHT_GRAY).width(0, 1).build();

	// 背景颜色
	Background BG_DEFAULT = new BgFill(GRAY_WHITE).build();
	Background BG_WHITE = new BgFill(WHITE).build();
	Background BG_TP = new BgFill(TRANSPARENT).build();
}