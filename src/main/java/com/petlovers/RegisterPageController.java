package com.petlovers;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    protected TextField tfUserName;
    @FXML
    protected DatePicker dpBirthDate;
    @FXML
    protected TextField tfUserCPF;
    @FXML
    protected PasswordField psUserPass;
    @FXML
    protected TextField tfUserEmail;
    @FXML
    protected TextField tfUserPhone;
    @FXML
    protected TextField tfCity;
    @FXML
    protected TextField tfState;

    @FXML
    protected void tryRegister(ActionEvent e) throws Exception {
        String birthdate = String.valueOf(dpBirthDate.getValue().getDayOfMonth() + "/" + String.valueOf(dpBirthDate.getValue().getMonthValue()) + "/" + String.valueOf(dpBirthDate.getValue().getYear()));
        System.out.println(birthdate);

        Register register = Register.tryRegister(
            tfFullName.getText(), tfUserName.getText(), birthdate, tfUserCPF.getText(), psUserPass.getText(), tfUserEmail.getText(), tfUserPhone.getText(), tfCity.getText(), tfState.getText()
        );

        Stage currentStage = (Stage)tfUserName.getScene().getWindow();
        currentStage.close();

        Scene scene = LoginPageController.CreateScene();

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
