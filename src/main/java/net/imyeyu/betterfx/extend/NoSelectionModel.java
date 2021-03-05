package net.imyeyu.betterfx.extend;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MultipleSelectionModel;

/**
 * 空的选择器，适用于 ListView
 * 
 * @author 夜雨
 *
 * @param <T> 数据类型
 */
public class NoSelectionModel<T> extends MultipleSelectionModel<T> {

	public ObservableList<Integer> getSelectedIndices() {
		return FXCollections.emptyObservableList();
	}

	public ObservableList<T> getSelectedItems() {
		return FXCollections.emptyObservableList();
	}

	public void selectIndices(int index, int... indices) {}

	public void selectAll() {}

	public void selectFirst() {}

	public void selectLast() {}

	public void clearAndSelect(int index) {}

	public void select(int index) {}

	public void select(T obj) {}

	public void clearSelection(int index) {}

	public void clearSelection() {}

	public boolean isSelected(int index) {
		return false;
	}

	public boolean isEmpty() {
		return true;
	}

	public void selectPrevious() {}

	public void selectNext() {}
}