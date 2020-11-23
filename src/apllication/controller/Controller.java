package apllication.controller;

public class Controller {
    public void editStatiClicked(ActionEvent actionEvent) {
        MyFXMLLoader loader = new application.MyFXMLLoader();
        loader.loadFXML("view/status.fxml", "Stati bearbeiten");
    }

    public void editPrioritiesClicked(ActionEvent actionEvent) {
        MyFXMLLoader loader = new application.MyFXMLLoader();
        loader.loadFXML("view/priority.fxml", "Prioritäten bearbeiten");
    }
}
