package view.pages;

import javafx.scene.control.TextArea;
import net.imyeyu.betterfx.BetterFX;
import net.imyeyu.betterfx.service.RunAsync;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class PageCSS extends TextArea {

	public PageCSS() {
		new RunAsync<String>() {
			@Override
			public String call() throws Exception {
				String result = "";
				InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(BetterFX.CSS);
				if (is != null) {
					StringBuilder sb = new StringBuilder();
					BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
					String input;
					while ((input = br.readLine()) != null) {
						sb.append(input).append("\r\n");
					}
					br.close();
					is.close();
					if (0 < sb.length()) {
						result = sb.substring(0, sb.length() - 1);
					}
					is.close();
				}
				return result;
			}
			@Override
			public void onFinish(String s) {
				setText(s);
			}
			@Override
			public void onException(Throwable e) {
				setText("无法读取 CSS 文件");
				appendText(e.toString());
			}
		}.start();
		getStyleClass().add("code");
		setEditable(false);
	}
}