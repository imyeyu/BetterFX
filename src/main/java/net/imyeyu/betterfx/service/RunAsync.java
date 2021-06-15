package net.imyeyu.betterfx.service;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 * 异步执行
 * <br>示例:
 * <pre>
 * new RunAsync<String> {
 * 
 *     public String call() throws Exception {
 *         // 这里不是 FX 线程，可以执行一些长时间的事情
 *     }
 *
 *     public void onFinish(String t) {
 *         // 参数是 call() 执行的返回结果，这里是 FX 线程，可以操作 UI
 *     }
 *
 *     public void onException(Throwable e) {
 *         // 线程异常。这里是 FX 线程
 *     }
 * }.start();
 * </pre>
 * 
 * @param <T> 数据处理返回类型
 *
 * 夜雨 创建于 2021-02-13 12:56
 */
public abstract class RunAsync<T> extends Service<T> {
	
	public RunAsync() {
		setOnSucceeded(e -> onFinish());
		valueProperty().addListener((obs, o, t) -> onFinish(t));
		exceptionProperty().addListener((obs, o, e) -> onException(e));
	}
	
	protected Task<T> createTask() {
		return new Task<>() {
			protected T call() throws Exception {
				return RunAsync.this.call();
			}
		};
	}

	/**
	 * 执行事件（非 FX 线程）
	 * 
	 * @return 处理结果
	 * @throws Exception 处理异常
	 */
	public abstract T call() throws Exception;

	/** 完成事件（FX 线程，只要线程结束就会调用） */
	public void onFinish() {

	}
	
	/**
	 * 完成事件（FX 线程，返回非 null 时触发）
	 * 
	 * @param t 执行事件返回值
	 */
	public void onFinish(T t) {
		// 子类实现
	}

	/**
	 * 发生异常（FX 线程）
	 *
	 * @param e 异常
	 */
	public void onException(Throwable e) {
		e.printStackTrace();
	}
}