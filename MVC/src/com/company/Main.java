package com.company;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application{
  @Override
public void start(Stage primaryStage) {

    primaryStage.setTitle("Model of Human");
    Human human = new Human("None",1);
    HBox root = new HBox(10);

  ViewHuman viewHuman = new ViewHuman(human);

    root.getChildren().add(editBlock(human));

    root.getChildren().add(new Separator(Orientation.VERTICAL));

    root.getChildren().add(viewHuman.getPane());

  Scene scene = new Scene(root, 1000, 400);
  primaryStage.setScene(scene);
  primaryStage.show();
}
  private VBox editBlock(Human human){
    VBox editPane = new VBox(10);
    editPane.setPadding(new Insets(20));

    Label labelTitle = new Label("\nВведите имя и возраст");
    labelTitle.setFont(Font.font(20));

    TextField editName = new TextField();
    editName.setFont(Font.font(20));
    editName.setPrefSize(150, 40);

    Spinner<Integer> editAge = new Spinner<>(0, 100, 0, 1);
    editAge.setPrefSize(100, 40);
    editAge.setStyle("-fx-font-size: 20");

    Button btn = new Button("Узнать статус");
    btn.setFont(Font.font(20));
    btn.setOnAction((ActionEvent event) -> {
      human.setName(editName.getText());
      human.setAge(editAge.getValue());

      if((editAge.getValue() >= 0) && (editAge.getValue() <= 11))
        human.setStatus("Детство");

      if((editAge.getValue() >= 12) && (editAge.getValue() <= 19))
        human.setStatus("Юность");

      if((editAge.getValue() >= 20) && (editAge.getValue() <= 35))
        human.setStatus("Молодость");

      if(editAge.getValue() >= 36)
        human.setStatus("Зрелость");
    });
    editPane.getChildren().addAll( labelTitle, editName, editAge, btn);
    return editPane;
  }
  public static void main(String[] args) {
    launch(args);
  }
}

