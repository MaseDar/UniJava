package com.company;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class ViewHuman {
    private Human human;
    private GridPane grid;
    Text status;
    Text name;
//    Text label;

    private void createPane(){
        grid = new GridPane();
//        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label label = new Label("\nСтатус:");
        label.setFont(Font.font(20));
        grid.add(label, 0, 0, 2, 1);

        name = new Text(human.getName());
        name.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));
        name.textProperty().bind(human.nameStringProperty());
//        GridPane.setHalignment(name, HPos.CENTER);
        grid.add(name, 0, 1, 2, 1);


        status = new Text(human.getStatus());
        status.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));
        status.textProperty().bind(human.statusStringProperty());
//        GridPane.setHalignment(name, HPos.CENTER);
        grid.add(status, 0, 4,2,1);



    }
    public  GridPane getPane(){
        return  grid;
    }

    public void setHuman(Human human) {
        this.human = human;
        name.textProperty().bind(this.human.nameStringProperty());
        status.textProperty().bind(this.human.statusStringProperty());

    }
    public ViewHuman(Human human) {
        this.human = human;
        createPane();
    }}