package com.client.ui.newDragon;

import com.client.ClientMain;
import common.dragon.Dragon;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NewDragonScene {
    private Stage stage;
    NewDragonController controller;
    public NewDragonScene(int localeIndex){
        stage = new Stage();
        stage.setResizable(false);
        FXMLLoader loader = new FXMLLoader(ClientMain.class.getResource("xml/newDragon.fxml"));
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

    public NewDragonScene(int localeIndex, Dragon dragon){
        stage = new Stage();
        stage.setResizable(false);
        FXMLLoader loader = new FXMLLoader(ClientMain.class.getResource("xml/newDragon.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        controller = loader.getController();
        controller.setDragon(dragon);
//            controller.setLocale(localeIndex);
//            controller.setStage(stage);

        this.stage.setScene(new Scene(root));
    }
    public void show() {
        stage.show();
    }
}
