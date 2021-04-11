package net.imyeyu.betterfx.service;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 字节交流速度计算
 *
 * 夜雨 创建于 2021/4/10 19:54
 */
public class ByteSpeed extends Service<Double> {

	public static double BUFFER = 0;

	private double old;
	private Timer timer;

	protected Task<Double> createTask() {
		return new Task<>() {

			private boolean returnToggle = false;

			protected Double call() {
				timer = new Timer();
				timer.scheduleAtFixedRate(new TimerTask() {
					public void run() {
						if (BUFFER == old) {
							updateValue(returnToggle ? null : 0d);
							returnToggle = !returnToggle;
						} else {
							updateValue(BUFFER - old);
							old = BUFFER;
						}
					}
				}, 0, 1000);
				return 0d;
			}
		};
	}

	public void reset() {
		this.old = 0;
		ByteSpeed.BUFFER = 0;
	}

	public void shutdown() {
		timer.cancel();
		timer.purge();
		timer = null;
	}
}