package com.petlovers;

import java.net.URL;

import org.hibernate.sql.Delete;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeletePageController {
    public static Scene CreateScene() throws Exception {
        URL sceneUrl = RegisterPageController.class
        .getResource("delete-page.fxml");
        Parent root = FXMLLoader.load(sceneUrl);
        Scene scene = new Scene(root);
        return scene;
    }

    @FXML
    protected PasswordField psUserPass;
    @FXML
    protected TextField tfUserEmail;

    @FXML
    protected void tryDeleteUser(ActionEvent e) throws Exception {
        DeleteUser delete = DeleteUser.tryDeleteUser(
            tfUserEmail.getText(), psUserPass.getText()
        );

        Scene scene = LoginPageController.CreateScene();

        Stage currentStage = (Stage)tfUserEmail.getScene().getWindow();
        currentStage.close();

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
