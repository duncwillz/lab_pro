/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae_tracker;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Kwaku Adjei <duncanadjei@gmail.com>
 */
public class AE_Tracker extends Application {
        private final String mainView = "/views/lab_pro.fxml";

    @Override
    public void start(Stage primaryStage) {
      callBack(mainView,"LAB AE TRACKER", false, primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
      public void callBack(String source, String title, boolean state, Stage primaryStage) {
        try {
            Parent myload = FXMLLoader.load(getClass().getResource(source));
            Scene scene = new Scene(myload);
            String style = getClass().getResource("/css/Application.css").toExternalForm();
            scene.getStylesheets().addAll(style);
            primaryStage.setTitle(title);
            primaryStage.setScene(scene);
            primaryStage.setIconified(state);
            primaryStage.getIcons().add(new Image("/img/schoollogo.jpg"));
            primaryStage.show();
            primaryStage.setMaximized(state);
            primaryStage.setResizable(state);
        } catch (IOException ex) {
            Logger.getLogger(AE_Tracker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
