package apllication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MyFXMLLoader.setPrimaryStage(primaryStage);

        MyFXMLLoader loader = new MyFMXLLoader();
        loader.loadFXML("view/scene.fxml", "Ticketsystem");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
