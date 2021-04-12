/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch3HW;

import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author RazanIT
 */
public class MainApp extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane loader = FXMLLoader.load(getClass().getResource("StudentScreen.fxml"));
        Map<String, Pane> mapPanes = new TreeMap<>();
        mapPanes.put("Students", loader);
        Scene scene = new Scene(mapPanes.get("Students"));       
        primaryStage.setScene(scene);
        primaryStage.setTitle("Student Processing Screen");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}