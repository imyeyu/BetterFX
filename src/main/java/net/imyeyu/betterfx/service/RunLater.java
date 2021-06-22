package net.imyeyu.betterfx.service;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 * 快速构造稍后执行
 * <br>示例:
 * <pre>
 * RunLater.event(() -> {
 *     // 延时 1 秒后执行（属于 FX 线程）
 * }, 1000);
 * </pre>
 * 
 * 夜雨 创建于 2021-02-13 13:14
 */
public class RunLater extends Service<Void> {
	
	private final long delay;

	public RunLater(Event event, long delay) {
		this.delay = delay;
		setOnSucceeded(e -> event.handle());
	}

	protected Task<Void> createTask() {
		return new Task<>() {
			protected Void call() throws Exception {
				Thread.sleep(delay);
				return null;
			}
		};
	}
	
	public static void event(Event event, long delay) {
		new RunLater(event, delay).start();
	}
	
	public interface Event {
		void handle();
	}
}