package com.petlovers;

import java.net.URL;
import com.petlovers.model.UserData;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InitialPageController {
    private UserData user;

    public static Scene CreateScene(UserData user) throws Exception {
        URL sceneUrl = InitialPageController.class.getResource("initial-page.fxml");
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        
        InitialPageController controller = loader.getController();
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
    protected Button btCadAnimal;
    @FXML
    protected Button btDelUser;
    @FXML
    protected Button btEditPet;

    @FXML
    protected void goToAddAnimalPage(ActionEvent e) throws Exception{
        Stage currentStage = (Stage)btCadAnimal.getScene().getWindow();
        currentStage.close();

        Scene scene = AddAnimalController.CreateScene(user);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show(); 
    }

    @FXML
    protected void goToDeletePage(ActionEvent e) throws Exception{
        Stage currentStage = (Stage)btCadAnimal.getScene().getWindow();
        currentStage.close();

        Scene scene = DeletePageController.CreateScene();

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show(); 
    }

    @FXML
    protected void goToEditPetPage(ActionEvent e) throws Exception{
        Stage currentStage = (Stage)btCadAnimal.getScene().getWindow();
        currentStage.close();

        Scene scene = EditPetPageController.CreateScene(user);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show(); 
    }
    
}
