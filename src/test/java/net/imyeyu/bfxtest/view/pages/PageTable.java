package net.imyeyu.bfxtest.view.pages;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.util.Random;

/**
 * 表格
 *
 * 夜雨 创建于 2021-05-16 23:42
 */
public class PageTable extends ScrollPane {

	public PageTable() {
		TableView<Bean> t = new TableView<>();
		TableColumn<Bean, String> name = new TableColumn<>("name");
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		TableColumn<Bean, String> age = new TableColumn<>("age");
		age.setCellValueFactory(new PropertyValueFactory<>("age"));

		t.getColumns().add(name);
		t.getColumns().add(age);
		t.setPrefHeight(260);
		for (int i = 0; i < 50; i++) {
			Bean b = new Bean();
			b.setName("name" + i);
			b.setAge(new Random().nextInt(40));
			t.getItems().add(b);
		}

		setPadding(new Insets(14, 0, 0, 20));
		setContent(new VBox(12, t, new Label("组件没有做修改，只是 CSS 样式调整")));
	}

	public static class Bean {

		private final SimpleStringProperty name = new SimpleStringProperty();
		private final SimpleIntegerProperty age = new SimpleIntegerProperty();

		public String getName() {
			return name.get();
		}

		public SimpleStringProperty nameProperty() {
			return name;
		}

		public void setName(String name) {
			this.name.set(name);
		}

		public int getAge() {
			return age.get();
		}

		public SimpleIntegerProperty ageProperty() {
			return age;
		}

		public void setAge(int age) {
			this.age.set(age);
		}
	}
}