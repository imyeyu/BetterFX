package net.imyeyu.betterfx.component;

import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

/**
 * 不显示根节点的树形结构，实现多个根节点
 *
 * 夜雨 创建于 2021/4/26 01:34
 */
public class XTreeView<T> extends TreeView<T> {

	private final TreeItem<T> dummyRoot = new TreeItem<>();

	public XTreeView() {
		dummyRoot.setExpanded(true);
		setRoot(dummyRoot);
		setShowRoot(false);
	}

	@SafeVarargs
	public final void setRoots(TreeItem<T>... roots) {
		dummyRoot.getChildren().addAll(roots);
	}

	public ObservableList<TreeItem<T>> getRoots() {
		return dummyRoot.getChildren();
	}
}