package apllication.controller;

import java.awt.event.ActionEvent;

public class Controller {
    public void editStatiClicked(ActionEvent actionEvent) {
        application.MyFXMLLoader loader = new application.MyFXMLLoader();
        loader.loadFXML("view/status.fxml", "Stati bearbeiten");
    }

    public void editPrioritiesClicked(ActionEvent actionEvent) {
        application.MyFXMLLoader loader = new application.MyFXMLLoader();
        loader.loadFXML("view/priority.fxml", "Prioritäten bearbeiten");
    }
    public void openFile(ActionEvent actionEvent) {

    }
}
