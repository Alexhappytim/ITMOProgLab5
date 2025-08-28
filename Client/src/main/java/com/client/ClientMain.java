package com.client;

import com.client.ui.login.LoginScene;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Client.start();

        LoginScene loginScene = new LoginScene(stage);
        loginScene.show();

    }

    public static void main(String[] args) {
        launch();
    }
}