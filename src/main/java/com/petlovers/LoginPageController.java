package com.petlovers;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginPageController {
    public static Scene CreateScene() throws Exception {
        URL sceneUrl = LoginPageController.class
        .getResource("login-page.fxml");
        Parent root = FXMLLoader.load(sceneUrl);
        Scene scene = new Scene(root);
        return scene;
    }
        
    @FXML
    protected Button btEnter;
    @FXML
    protected TextField tfUserEmail;
    @FXML
    protected PasswordField pfUserPass;
   
    @FXML
    protected void submit(ActionEvent e) throws Exception {
        Authentification auth = Authentification.tryLogin(
            tfUserEmail.getText(), pfUserPass.getText()
        );
        if (!auth.userExists()) {
            Alert alert = new Alert(
                AlertType.ERROR,
                "Usuário inexistente.",
                ButtonType.OK
            );
            alert.showAndWait();
            return;
        }
            if (auth.getUser() == null) {
            Alert alert = new Alert(
                AlertType.ERROR,
                "Senha incorreta.",
                ButtonType.OK
            );
            alert.showAndWait();
            return;
        }
    }
}
