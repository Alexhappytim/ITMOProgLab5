package com.client.ui.commands;

import com.client.ClientMain;
import com.client.ui.newDragon.NewDragonController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CommandsScene {
    private Stage stage;
    NewDragonController controller;
    public CommandsScene(int localeIndex){
        stage = new Stage();
        stage.setResizable(false);
        FXMLLoader loader = new FXMLLoader(ClientMain.class.getResource("xml/commands.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        controller = loader.getController();
//            controller.setLocale(localeIndex);
//            controller.setStage(stage);

        this.stage.setScene(new Scene(root));
    }
    public void show() {
        stage.show();
    }
}
