package view.pages;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class PageByteSpeed extends ScrollPane {

	public PageByteSpeed() {
		Label explain0 = new Label("位置：net.imyeyu.betterfx.service.ByteSpeed");
		Label explain1 = new Label("说明：FX 多任务的字节流速度计算");

		TextArea code = new TextArea("""
			{
				ByteSpeed byteSpeed = new ByteSpeed();
				byteSpeed.valueProperty().addListener((obs, o, b) -> {
					if (b != null && b != 0) {
						System.out.println(byteFormat(b, 2));
					}
				});
			}
			public static String byteFormat(double size, int decimal) {
			    String[] unit = new String[]{" B", " KB", " MB", " GB", " TB"};
			    if (0.0D < size) {
			        for (int i = 0; i < unit.length; size /= 1024.0D) {
			            String format = String.format("%." + decimal + "f" + unit[i], size);
			            if (size <= 1000.0D) {
			                return format;
			            }
			            if (i == unit.length - 1) {
			                return format;
			            }
			            ++i;
			        }
			    }
			    return "N/A";
			}
            """);
		code.setPrefHeight(420);
		code.getStyleClass().add("code");
		code.setEditable(false);

		setPadding(new Insets(14, 20, 0, 20));
		setContent(new VBox(6, explain0, explain1, code));
		setFitToWidth(true);
	}
}