package apllication.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Status {

    public ListView listView;
    public ListView statiList = listView;
    private File file;
    public Stage stage;
    private int nummber;
    private  String status;
    @FXML
    ObservableList<Status> list = FXCollections.observableArrayList();
    ArrayList<Status> set = new ArrayList<>();

    public void load(File file) {
        String s;
        BufferedReader br = null;

        String row;
        try{
        BufferedReader csvReader = new BufferedReader(new FileReader(file));
        try{
            while ((row = csvReader.readLine()) != null) {
                Status a = new Status();
                String[] data = row.split(",");
                a.nummber = Integer.parseInt(data[0]);
                a.status = data[1];
                list.add(a); // füge Artikel zur Liste hinzu
                set.add(a);
             }
        }finally{
            csvReader.close();
            }
        }catch (IOException io) {
            }


        statiList.setItems(list);
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