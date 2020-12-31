package sample;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class Main extends Application {
    public static Label status = new Label("");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Registration portal");
        primaryStage.setScene(Scene1.getScene1(primaryStage));
        primaryStage.show();
    }

}
