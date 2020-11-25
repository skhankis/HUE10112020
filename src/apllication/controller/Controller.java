package apllication.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Controller {
    public ListView<Status> statiList;
    private File file;
    public Stage stage;
    ObservableList<Status> list = FXCollections.observableArrayList();
    ArrayList<Status> set = new ArrayList<>();

    public void load(File file) {
        String s;
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
            try {
                br.readLine(); // ignoriere die erste Zeile => Überschriften

                while ((s = br.readLine()) != null) {
                    // s enthält die gesamte Zeile
                    s = s.replace("\"", ""); // ersetze alle " in der Zeile
                    Status a = new Status();

                    String[] words = s.split(" ");
                    a.nummber = Integer.parseInt(words[0]);
                    a.status = words[1];
                    list.add(a); // füge Artikel zur Liste hinzu
                    set.add(a);
                }
            } finally {
                br.close();
            }
        } catch (IOException io) {
        }

        articleList.setItems(list);
    }

    public void editStatiClicked(ActionEvent actionEvent) {
        application.MyFXMLLoader loader = new application.MyFXMLLoader();
        loader.loadFXML("view/status.fxml", "Stati bearbeiten");
    }

    public void editPrioritiesClicked(ActionEvent actionEvent) {
        application.MyFXMLLoader loader = new application.MyFXMLLoader();
        loader.loadFXML("view/priority.fxml", "Prioritäten bearbeiten");
    }
    public void saveClicked(ActionEvent actionEvent) {

    }
    public void setStage(Stage s) {
        this.stage = s;
    }

    public void cancel(ActionEvent actionEvent) {
        return;
    }
    public void openFile(ActionEvent actionEvent) {

        this.file = new FileChooser().showOpenDialog(stage);
        load(file);
    }
}
