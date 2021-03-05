# BetterFX

来源
> [YeyuUtils](https://github.com/imyeyu/YeyuUtils) > [iTools](https://github.com/imyeyu/iTools) > [PixelFX](https://github.com/imyeyu/PixelFX) > BetterFX

以上 YeyuUtils 和 iTools 都废弃了

---------
## FX 扩展

#### 1. 改进的 AnchorPane
原来的
```
AnchorPane.setTopAnchor(node, 10d);
AnchorPane.setLeftAnchor(node, 10d);
AnchorPane.setRightAnchor(node, 10d);
AnchorPane.setBottomAnchor(node, 10d);
```
现在可以这样用
```
AnchorPaneX.def(node, 10, 10, 10, 10);
```
#### 2. 背景填充 BgFill
原来的
```
// 纯色背景
new Background(new BackgroundFill(Paint.valueOf("red"), CornerRadii.EMPTY, new Insets(10)));
// 渐变背景
Stop[] stops = new Stop[] { new Stop(0, Color.valueOf("red")), new Stop(1, Color.valueOf("blue"))};
new Background(new BackgroundFill(
	new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops),
	CornerRadii.EMPTY,
	new Insets(10)
));
```
现在可以这样用
```
// 纯色背景
new BgFill("red").insets(new Insets(10)).build();
// 渐变背景
new BgFill("red", "blue").toRight().build();
// 随机测试背景
BgFill.test();
```
#### 3. 图像背景 BgImage
原来的
```
new Background(new BackgroundImage(new Image("/img.png"), BackgroundRepeat.NOT_REPEAT, BackgroundRepeat.NOT_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));
```
现在可以这样用
```
new BgImage("/img.png").build();
// 自适应背景
new BgImage("/bg.png").cover().build();
```
#### 4. 改进的 Border
原来的
```
new Border(new BorderStroke(
	Paint.valueOf("red"), Paint.valueOf("red"), Paint.valueOf("red"), Paint.valueOf("red"),
	BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
	new CornerRadii.EMPTY,
	new BorderWidths(1),
	new Insets.EMPTY
));
```
现在可以这么做
```
new BorderX("red").build();
// 不同宽度
new BorderX("red").width(1, 2, 3, 4).build();
// 圆角
new BorderX("red").radius(.5, true).build();
// 单边边框
new BorderX("red").top().build();
```
#### 5. 空的选择器 NoSelectionModel
可以关闭 TableView、ListView、TreeView 等组件的选择功能

## FX 多任务

#### 1. 快速构造异步执行 RunAsync&lt;T&gt;
```
new RunAsync<String> {

	public String call() throws Exception {
		// 这里不是 FX 线程，可以执行一些长时间的事情
	}

	public void onFinish(String t) {
		// 参数是 call() 执行的返回结果，这里是 FX 线程，可以操作 UI
	}
}.start();
```

#### 2. 快速构造稍后执行 RunLater
注意这是异步的
```
RunLater.time(1000).event(() -> {
	// 延时 1 秒后执行（属于 FX 线程）
})
```