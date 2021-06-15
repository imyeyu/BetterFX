package net.imyeyu.betterfx.service;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;
import net.imyeyu.betterfx.BetterFX;
import net.imyeyu.betterfx.bean.PopupTips;

import java.awt.MouseInfo;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 * 弹窗提示
 * <p>示例：
 * <pre>
 *     PopupTipsService.install(node, "文本提示");
 *     PopupTipsService.install(node, new Image("/tips.png")); // 图片提示
 *     PopupTipsService.install(node, new PopupTips(new Button("自定义组件提示")));
 * </pre>
 *
 * 夜雨 创建于 2021-04-22 19:48
 */
public class PopupTipsService extends Popup implements BetterFX {

	private static PopupTipsService service;                     // 单例对象
	private final Map<Node, PopupTips> popups = new HashMap<>(); // 注册数据
	private final StackPane root;                                // 根布局

	private PopupTipsService() {
		root = new StackPane();
		DropShadow shadow = new DropShadow();
		shadow.setRadius(6);
		shadow.setOffsetX(0);
		shadow.setOffsetY(0);
		shadow.setSpread(.05);
		shadow.setColor(Color.valueOf("#3333"));

		root.setEffect(shadow);
		root.setMaxWidth(960);
		root.setBackground(BG_DEFAULT);
		root.setBorder(BORDER_DEFAULT);

		StackPane shadowPane = new StackPane();
		shadowPane.setPadding(new Insets(3));
		shadowPane.setBackground(Background.EMPTY);
		shadowPane.getChildren().add(root);

		getScene().setFill(null);
		getContent().add(shadowPane);
	}

	/**
	 * 显示弹窗提示
	 *
	 * @param node 安装提示的组件
	 */
	public void show(Node node) {
		root.setBorder(BORDER_DEFAULT);
		root.setBackground(BG_DEFAULT);
		root.getChildren().setAll(popups.get(node).getNode());
		Point location = MouseInfo.getPointerInfo().getLocation();
		show(node.getScene().getWindow(), location.x, location.y);
	}

	/**
	 * 跟随鼠标移动
	 *
	 * @param event 鼠标事件
	 */
	public void move(MouseEvent event) {
		if (isShowing()) {
			setX(event.getScreenX() + 8);
			setY(event.getScreenY() + 6);
		}
	}

	/**
	 * 为组件安装文本弹窗提示
	 *
	 * @param node 组件
	 * @param text  图片
	 */
	public static void install(Node node, String text) {
		install(node, new PopupTips(text));
	}

	/**
	 * 为组件安装图片弹窗提示
	 *
	 * @param node 组件
	 * @param img  图片
	 */
	public static void install(Node node, Image img) {
		install(node, new PopupTips(img));
	}

	/**
	 * <p>为组件安装弹窗提示。</p>
	 * <p>如果要为 node 设置 setOnMouseMoved 事件，务必让该事件执行 PopupTipsService.getInstance().move(event)</p>
	 * <p>这样才能保持弹窗提示跟随鼠标</p>
	 *
	 * @param node      组件
	 * @param popupTips 弹窗数据
	 */
	public static void install(Node node, PopupTips popupTips) {
		if (service == null) {
			PopupTipsService.getInstance();
		}
		// 悬停事件
		popupTips.setHoverListener((obs, o, isHovered) -> {
			if (isHovered) {
				if (popupTips.isEnable()) {
					// 显示
					if (popupTips.getOnShow() != null) {
						popupTips.getOnShow().handler(service.root, popupTips.getNode());
					}
					service.show(node);
				}
			} else {
				// 隐藏
				service.hide();
				if (popupTips.getOnHide() != null) {
					popupTips.getOnHide().handler();
				}
			}
		});
		// 添加悬停事件
		node.hoverProperty().addListener(popupTips.getHoverListener());
		// 移动事件
		node.setOnMouseMoved(event -> service.move(event));
		// 注册
		service.getPopups().putIfAbsent(node, popupTips);
	}

	/**
	 * 卸载弹窗提示
	 *
	 * @param node 组件
	 */
	public static void uninstall(Node node) {
		PopupTips popupTips = service.getPopups().get(node);
		node.hoverProperty().removeListener(popupTips.getHoverListener());
		service.getPopups().remove(node);
	}

	/** @return 构造器 */
	public static PopupTipsService getInstance() {
		if (service == null) {
			service = new PopupTipsService();
		}
		return service;
	}

	/** @return 已注册提示列表 */
	public Map<Node, PopupTips> getPopups() {
		return popups;
	}
}