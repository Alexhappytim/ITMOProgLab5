package com.client.ui.collection;

import com.client.ClientMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class CollectionScene {
    private Stage stage;
    private CollectionController controller;
    private int localeIndex;

    public CollectionScene(int localeIndex) {
        this.localeIndex = localeIndex;
        try {
            stage = new Stage();
            FXMLLoader loader = new FXMLLoader(ClientMain.class.getResource("xml/table.fxml"));
            Parent root = loader.load();

            controller = loader.getController();
            setup();

            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setup() {
        stage.setResizable(false);
        controller.setLocale(localeIndex);
        controller.setStage(stage);
    }

    public void show() {
        stage.show();
    }
}
