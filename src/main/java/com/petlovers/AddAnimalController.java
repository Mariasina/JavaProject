package com.petlovers;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddAnimalController {
    public static Scene CreateScene() throws Exception {
        URL sceneUrl = RegisterPageController.class
        .getResource("pet-register-page.fxml");
        Parent root = FXMLLoader.load(sceneUrl);
        Scene scene = new Scene(root);
        return scene;
    }

    @FXML
    protected Button btCadPet;
    @FXML
    protected TextField tfPetName;
    @FXML
    protected TextField tfPetAge;
    @FXML
    protected TextField tfPetType;
    @FXML
    protected TextField tfPetBreed;
    @FXML
    protected TextField tfPetGender;
    @FXML
    protected TextField tfPetDescription;

    @FXML
    protected void tryAddAnimal(ActionEvent e) throws Exception {
        AddAnimal addAnimal = AddAnimal.tryAddAnimal(
            tfPetName.getText(), Integer.parseInt(tfPetAge.getText()), tfPetType.getText(), tfPetBreed.getText(), tfPetGender.getText(), tfPetDescription.getText()
        );

        Stage currentStage = (Stage)tfPetName.getScene().getWindow();
        currentStage.close();

        Scene scene = LoginPageController.CreateScene();

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
