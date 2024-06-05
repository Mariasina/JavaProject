package com.petlovers;

import java.net.URL;

import com.petlovers.model.AnimalData;
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

public class EditPetPageController {
    private UserData user;
    private AnimalData pet;

    public static Scene CreateScene(UserData user) throws Exception {
        URL sceneUrl = EditPetPageController.class
        .getResource("edit-pet-page.fxml");
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        
        // Acessa o controlador e define o usuário logado
        EditPetPageController controller = loader.getController();
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
    protected void editAnimal(ActionEvent e) throws Exception {
        long id = 1;
    
        EditAnimal.editAnimal(
            tfPetName.getText(), Integer.parseInt(tfPetAge.getText()), tfPetType.getText(), tfPetBreed.getText(), tfPetGender.getText(), tfPetDescription.getText(), id
        );

        Stage currentStage = (Stage)tfPetName.getScene().getWindow();
        currentStage.close();

        Scene scene = InitialPageController.CreateScene(user);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
