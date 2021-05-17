package net.imyeyu.betterfx.service;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 * 快速构造稍后执行
 * <br>示例:
 * <pre>
 * RunLater.time(1000).event(() -> {
 *     // 延时 1 秒后执行（属于 FX 线程）
 * })
 * </pre>
 * 
 * 夜雨 创建于 2021-02-13 13:14
 */
public class RunLater extends Service<Void> {
	
	private long delay = 0;
	
	protected Task<Void> createTask() {
		return new Task<>() {
			protected Void call() throws Exception {
				Thread.sleep(delay);
				return null;
			}
		};
	}
	
	/**
	 * 延时（毫秒）
	 * 
	 * @param delay 延时毫秒
	 */
	public void setDelay(long delay) {
		this.delay = delay;
	}
	
	public void event(Event event) {
		this.setOnSucceeded(e -> event.handle());
		this.start();
	}
	
	public static RunLater time(long delay) {
		RunLater r = new RunLater();
		r.setDelay(delay);
		return r;
	}
	
	public interface Event {
		void handle();
	}
}