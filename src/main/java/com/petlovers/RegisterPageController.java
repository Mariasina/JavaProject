package com.petlovers;

import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterPageController {
    public static Scene CreateScene() throws Exception {
        URL sceneUrl = RegisterPageController.class
        .getResource("register-page.fxml");
        Parent root = FXMLLoader.load(sceneUrl);
        Scene scene = new Scene(root);
        return scene;
    }

    @FXML
    protected Button btCad;
    @FXML
    protected TextField tfFullName;
    @FXML
    protected PasswordField psUserPass;
}
