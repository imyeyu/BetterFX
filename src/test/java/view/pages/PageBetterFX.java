package view.pages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PageBetterFX extends ScrollPane {

	public PageBetterFX() {
		ImageView logo = new ImageView("/logo.png");
		Label version = new Label("版本: 1.0.0");
		Label explain = new Label("\tBetterFX 是一个改善 JavaFX 开发过程的依赖库，简化一些繁琐的操作，微调部分 UI（如果你不喜欢，可以舍弃 UI 组件抽离其他功能再组依赖库）");
		explain.setWrapText(true);

		Label betterfx = new Label("\t同时 BetterFX.java 是本依赖的全局公共参数类，包含常用颜色、边框、背景和本依赖的引用 CSS 等");
		betterfx.setWrapText(true);

		Label labelSource = new Label("开源：");
		Hyperlink urlSource = new Hyperlink("https://www.imyeyu.net/article/public/aid136.html");
		TextFlow source = new TextFlow(labelSource, urlSource);
		source.setTextAlignment(TextAlignment.CENTER);

		Label labelBlog = new Label("个人博客：");
		Hyperlink urlBlog = new Hyperlink("https://www.imyeyu.net");
		TextFlow blog = new TextFlow(labelBlog, urlBlog);
		blog.setTextAlignment(TextAlignment.CENTER);

		Label copyright = new Label("Copyright © 夜雨 2021 - " + new SimpleDateFormat("yyyy").format(new Date()) + " All Rights Reserved 版权所有");

		final Insets padding = new Insets(32, 0, 0, 0);
		VBox root = new VBox(6, logo, version, explain, betterfx, source, blog, copyright);
		VBox.setMargin(source, padding);
		VBox.setMargin(explain, padding);
		root.setAlignment(Pos.CENTER);

		setPadding(new Insets(14, 4, 0, 4));
		setFitToWidth(true);
		setContent(root);
	}
}