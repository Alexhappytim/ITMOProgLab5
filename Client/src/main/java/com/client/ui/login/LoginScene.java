package com.client.ui.login;

import com.client.ClientMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginScene {
    private Stage stage;

    public LoginScene(Stage stage) {
        try {
            this.stage = stage;
            stage.setResizable(false);
            FXMLLoader loader = new FXMLLoader(ClientMain.class.getResource("xml/login.fxml"));
            Parent root = loader.load();

            this.stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public LoginScene(int localeIndex) {
        try {
            stage = new Stage();
            stage.setResizable(false);
            FXMLLoader loader = new FXMLLoader(ClientMain.class.getResource("xml/login.fxml"));
            Parent root = loader.load();

            this.stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show() {
        stage.show();
    }
}
