package com.petlovers;

import java.net.URL;
import com.petlovers.model.UserData;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class InitialPageController {

    public static Scene CreateScene(UserData user) throws Exception {
        URL sceneUrl = InitialPageController.class
        .getResource("initial-page.fxml");
        Parent root = FXMLLoader.load(sceneUrl);
        Scene scene = new Scene(root);
        return scene;
    }
    
}
