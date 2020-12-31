package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Scene1 {
    public static Scene getScene1(Stage primaryStage){

        VBox vBox = new VBox();

        Label heading = new Label("Portal");
        heading.setStyle("-fx-font-size : 42");
        heading.setAlignment(Pos.CENTER);
        heading.setTextFill(Paint.valueOf("#6c757d"));

        StackPane root = new StackPane();
        BorderPane borderPane = new BorderPane();

        Label label = new Label("Email");
        label.setTextFill(Paint.valueOf("#6c757d"));

        Label errorLabel = new Label("");
        errorLabel.setTextFill(Paint.valueOf("#6c757d"));

        TextField textField = new TextField();
        textField.setPromptText("Enter your email address");
        textField.setFocusTraversable(false);

        Button register = new Button("Register");
        register.setStyle("-fx-background-color : #28a745");
        register.setTextFill(Paint.valueOf("#f8f9fa"));

        Button viewList = new Button("View list");
        viewList.setStyle("-fx-background-color : #28a745");
        viewList.setTextFill(Paint.valueOf("#f8f9fa"));

        GridPane gridPane = new GridPane();
        gridPane.add(label, 0, 0);
        gridPane.add(textField, 1,0);
        gridPane.add(errorLabel, 2,0);
        gridPane.add(register,1, 2);
        gridPane.add(viewList, 1,3);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.CENTER);

        borderPane.setCenter(gridPane);

        root.getChildren().addAll(borderPane);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color : #f6f6f6");

        vBox.getChildren().addAll(heading, root);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(5);

        Scene scene1 = new Scene(vBox, 400, 500);

        register.setOnAction(actionEvent -> {
            if(textField.getText().isEmpty()){
                errorLabel.setText("email cannot be empty");
                errorLabel.setText("");
            }
            else if(!textField.getText().matches("^(.+)@(.+)$")){
                errorLabel.setText("invalid email pattern");
            }
            else {
                Student student = new Student();
                student.setEmail(textField.getText());
                if(!Database.getStudentList().contains(textField.getText())){
                    Database.getStudentList().add(student.toString());
                    errorLabel.setText("student registered successfully!!!");
                    primaryStage.setScene(Scene2.getScene2(primaryStage));

                } else { errorLabel.setText("student already registered!!!");
                    return;
                }
            }
        });

        viewList.setOnAction(actionEvent -> {
            primaryStage.setScene(Scene2.getScene2(primaryStage));
        });

        return scene1;
    }
}
