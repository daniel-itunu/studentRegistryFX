package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;

public class Database {

    public static List<String> getStudentList() {
        return studentList;
    }

    public static ObservableList<String> studentList= FXCollections.observableArrayList();

}
