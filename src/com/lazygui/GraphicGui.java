package com.lazygui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GraphicGui extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    Button btn = new Button();
    btn.setGraphic(new ImageView("file:src\\com\\lazygui\\icons8_google_web_search_32.png"));

    VBox vBox = new VBox();
    vBox.getChildren().add(btn);
    vBox.setAlignment(Pos.CENTER);
    Scene scene = new Scene(vBox,250,50);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
