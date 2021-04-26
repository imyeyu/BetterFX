package net.imyeyu.bfxtest.view.pages;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class PageRunAsync extends ScrollPane {

	public PageRunAsync() {

		Label explain0 = new Label("位置：net.imyeyu.betterfx.service.RunAsync");
		Label explain1 = new Label("说明：快速构造异步执行任务");

		TextArea code = new TextArea("""
			new RunAsync<String> {
			
				public String call() throws Exception {
					// 这里不是 FX 线程，可以执行一些长时间的事情
				}
			
				public void onFinish(String t) {
					// 参数是 call() 执行的返回结果，这里是 FX 线程，可以操作 UI
				}
			    
				public void onException(Throwable e) {
					// 线程异常。这里是 FX 线程
				}
			}.start();
			""");
		code.setPrefHeight(320);
		code.getStyleClass().add("code");
		code.setEditable(false);

		setPadding(new Insets(14, 20, 0, 20));
		setContent(new VBox(6, explain0, explain1, code));
		setFitToWidth(true);
	}
}