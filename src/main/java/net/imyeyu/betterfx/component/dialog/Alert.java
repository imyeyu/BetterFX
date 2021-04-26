package net.imyeyu.betterfx.component.dialog;

import javafx.beans.InvalidationListener;
import javafx.beans.NamedArg;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import net.imyeyu.betterfx.BetterFX;

import java.lang.ref.WeakReference;

/**
 * <p>原 {@link javafx.scene.control.Alert} 源码，稍作修改</p>
 *
 * 夜雨 创建于 2021/4/25 17:14
 */
public class Alert extends Dialog<ButtonType> {

	/**
	 * 弹窗类型
	 *
	 * 夜雨 创建于 2021/4/25 18:17
	 */
	public enum AlertType {
		NONE,
		INFORMATION,
		WARNING,
		CONFIRMATION,
		ERROR
	}
	// 按钮类型
	public static final ButtonType APPLY    = new ButtonType("应用",   ButtonData.APPLY);
	public static final ButtonType OK       = new ButtonType("好",     ButtonData.OK_DONE);
	public static final ButtonType CANCEL   = new ButtonType("取消",   ButtonData.CANCEL_CLOSE);
	public static final ButtonType CLOSE    = new ButtonType("关闭",   ButtonData.CANCEL_CLOSE);
	public static final ButtonType YES      = new ButtonType("是",     ButtonData.YES);
	public static final ButtonType NO       = new ButtonType("否",     ButtonData.NO);
	public static final ButtonType FINISH   = new ButtonType("完成",   ButtonData.FINISH);
	public static final ButtonType NEXT     = new ButtonType("下一步", ButtonData.NEXT_FORWARD);
	public static final ButtonType PREVIOUS = new ButtonType("上一步", ButtonData.BACK_PREVIOUS);
	// 图标
	private static final Image ICON_INFO    = new Image("dialog-information16x.png");
	private static final Image ICON_WARNING = new Image("dialog-warning16x.png");
	private static final Image ICON_ERROR   = new Image("dialog-error16x.png");
	private static final Image ICON_CONFIRM = new Image("dialog-confirmation16x.png");

	private WeakReference<DialogPane> dialogPaneRef;

	private boolean installingDefaults = false;
	private boolean hasCustomButtons;
	private boolean hasCustomTitle = false;

	private final ListChangeListener<ButtonType> buttonsListener = change -> {
		if (!installingDefaults) hasCustomButtons = true;
	};

	public Alert(@NamedArg("alertType") AlertType alertType) {
		this(alertType, "");
	}

	public Alert(@NamedArg("alertType") AlertType alertType, @NamedArg("buttonTypes") ButtonType... buttons) {
		this(alertType, "", buttons);
	}

	public Alert(@NamedArg("alertType") AlertType alertType, @NamedArg("contentText") String contentText, @NamedArg("buttonTypes") ButtonType... buttons) {
		super();

		final DialogPane dialogPane = getDialogPane();
		dialogPane.setContentText(contentText);
		dialogPane.setBorder(BetterFX.BORDER_TOP);
		dialogPane.getStyleClass().add("alert");
		dialogPane.getScene().getStylesheets().add(BetterFX.CSS);
		((Stage) dialogPane.getScene().getWindow()).getIcons().add(getIcon(alertType));

		dialogPaneRef = new WeakReference<>(dialogPane);

		hasCustomButtons = buttons != null && buttons.length > 0;
		if (hasCustomButtons) {
			for (ButtonType btnType : buttons) {
				dialogPane.getButtonTypes().addAll(btnType);
			}
		}

		setAlertType(alertType);

		dialogPaneProperty().addListener(o -> updateListeners());
		InvalidationListener titleListener = o -> {
			if (!installingDefaults) hasCustomTitle = true;
		};
		titleProperty().addListener(titleListener);
		updateListeners();
	}

	private final ObjectProperty<AlertType> alertType = new SimpleObjectProperty<>(null) {

		@Override
		protected void invalidated() {
			String newTitle = "";
			ButtonType[] newButtons = new ButtonType[]{OK};
			switch (getAlertType()) {
				case NONE         -> newButtons = new ButtonType[]{};
				case INFORMATION  -> newTitle = "信息";
				case WARNING      -> newTitle = "警告";
				case ERROR        -> newTitle = "错误";
				case CONFIRMATION -> {
					newTitle = "询问";
					newButtons = new ButtonType[]{OK, CANCEL};
				}
			}
			installingDefaults = true;
			if (!hasCustomTitle) {
				setTitle(newTitle);
			}
			if (!hasCustomButtons) {
				getButtonTypes().setAll(newButtons);
			}
			installingDefaults = false;
		}
	};

	private void updateListeners() {
		DialogPane oldPane = dialogPaneRef.get();
		if (oldPane != null) {
			oldPane.getButtonTypes().removeListener(buttonsListener);
		}
		DialogPane newPane = getDialogPane();
		if (newPane != null) {
			newPane.getButtonTypes().addListener(buttonsListener);
		}
		dialogPaneRef = new WeakReference<>(newPane);
	}

	public final Image getIcon(AlertType type) {
		return switch (type) {
			case NONE, INFORMATION -> ICON_INFO;
			case WARNING           -> ICON_WARNING;
			case ERROR             -> ICON_ERROR;
			case CONFIRMATION      -> ICON_CONFIRM;
		};
	}

	public final AlertType getAlertType() {
		return alertType.get();
	}

	public final void setAlertType(AlertType alertType) {
		this.alertType.setValue(alertType);
	}

	public final ObjectProperty<AlertType> alertTypeProperty() {
		return alertType;
	}

	public final ObservableList<ButtonType> getButtonTypes() {
		return getDialogPane().getButtonTypes();
	}
}