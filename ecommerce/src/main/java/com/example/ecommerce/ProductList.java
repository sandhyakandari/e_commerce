package com.example.ecommerce;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class ProductList {
    private TableView<Product> productTable;
    public VBox createTable(ObservableList<Product>data)
       {
        //column
        TableColumn id=new TableColumn("10");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn name=new TableColumn("NAME");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

          TableColumn price=new TableColumn("PRICE");
          price.setCellValueFactory(new PropertyValueFactory<>("price"));
        //dummy data
       productTable =new TableView<>();
        productTable.setItems(data);
        productTable.getColumns().addAll(id,name,price);
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox vBox=new VBox();
        // gicve padding in whole vbox;
       vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(productTable);
        return vBox;

    }

public  VBox getALlProducts(){
        ObservableList<Product>data=Product.getAllProducts();
        return createTable(data);
}
public Product getSelectedProduct(){
        return  productTable.getSelectionModel().getSelectedItem();
}
public VBox getProductsInCart(ObservableList<Product>data){
        return createTable(data);
}
}
