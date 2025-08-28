package com.client.ui.register;

import com.client.ClientMain;
import com.client.ui.collection.CollectionController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationScene {
    private Stage stage;
    private RegistrationController controller;

    public RegistrationScene(int localeIndex) {
        try {
            stage = new Stage();
            stage.setResizable(false);
            FXMLLoader loader = new FXMLLoader(ClientMain.class.getResource("xml/registration.fxml"));
            Parent root = loader.load();

            controller = loader.getController();
//            controller.setLocale(localeIndex);
//            controller.setStage(stage);

            this.stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show() {
        stage.show();
    }
}
