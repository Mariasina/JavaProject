package com.petlovers;

import com.petlovers.model.AnimalData;
import com.petlovers.model.UserData;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // long id = 2;
        // UserData user = new UserData();
        // user.setId(id);

        Scene scene = LoginPageController.CreateScene();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}