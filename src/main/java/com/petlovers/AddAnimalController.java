package com.petlovers;

import java.net.URL;

import com.petlovers.model.UserData;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

public class AddAnimalController {
    private UserData user;

    public static Scene CreateScene(UserData user) throws Exception {
        URL sceneUrl = RegisterPageController.class
        .getResource("pet-register-page.fxml");
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        
        // Acessa o controlador e define o usuário logado
        AddAnimalController controller = loader.getController();
        controller.setUser(user);
        
        Scene scene = new Scene(root);
        return scene;
    }

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
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
    protected TextArea tfPetDescription;

    @FXML
    protected void tryAddAnimal(ActionEvent e) throws Exception {
        AddAnimal addAnimal = AddAnimal.tryAddAnimal(
            tfPetName.getText(), Integer.parseInt(tfPetAge.getText()), tfPetType.getText(), tfPetBreed.getText(), tfPetGender.getText(), tfPetDescription.getText(), user
        );

        Stage currentStage = (Stage)tfPetName.getScene().getWindow();
        currentStage.close();

        Scene scene = InitialPageController.CreateScene(user);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
