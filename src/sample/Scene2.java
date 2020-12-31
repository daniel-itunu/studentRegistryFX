package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Scene2 {
    public static Scene getScene2(Stage primaryStage){

        VBox vBox = new VBox();
        vBox.setStyle("-fx-background-color : #6c757d");
        ListView listView = new ListView();
        listView.getItems().addAll(Database.getStudentList());
        Button home = new Button("<-");
        home.setStyle("-fx-background-color : #6c757d");
        home.setTextFill(Paint.valueOf("#f8f9fa"));
        Button remove = new Button("Remove");
        remove.setStyle("-fx-background-color : #dc3545");
        remove.setTextFill(Paint.valueOf("#f8f9fa"));
        BorderPane borderPane = new BorderPane();
        HBox top = new HBox();
        top.getChildren().add(home);
        top.setStyle("-fx-background-color : #6c757d");

        HBox bottom = new HBox();
        bottom.getChildren().add(remove);
        bottom.setStyle("-fx-background-color : #6c757d");
        bottom.setAlignment(Pos.BOTTOM_CENTER);

        borderPane.setTop(top);
        borderPane.getTop().setStyle("-fx-background-color : #6c757d");
        borderPane.setCenter(listView);
        //borderPane.setBottom(bottom);
        borderPane.setAlignment(remove, Pos.BOTTOM_CENTER);

        vBox.getChildren().addAll(borderPane, bottom);
        Scene scene2 = new Scene(vBox, 400, 500);

        home.setOnAction(actionEvent -> {
            Main.status.setText("");
            primaryStage.setScene(Scene1.getScene1(primaryStage));
        });

        remove.setOnAction(actionEvent -> {
            if(Database.getStudentList().size()>0){
                Object obj = listView.getSelectionModel().getSelectedItem();
                Database.getStudentList().remove(obj);
            primaryStage.setScene(Scene2.getScene2(primaryStage));
            } else {
                Dialog<String> dialog = new Dialog();
                dialog.setTitle("message");
                ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                dialog.setContentText("No student data available");
                dialog.getDialogPane().getButtonTypes().add(type);
                dialog.showAndWait();
            }
        });

        return scene2;
    }
}
