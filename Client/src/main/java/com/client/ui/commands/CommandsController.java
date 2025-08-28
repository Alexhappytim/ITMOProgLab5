package com.client.ui.commands;

import com.client.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import java.io.File;

public class CommandsController {
    @FXML
    private Button clearButton;

    @FXML
    private Button executeScriptButton;

    @FXML
    private Button headButton;

    @FXML
    private Button removeHeadButton;
    private FileChooser fileChooser;
    @FXML
    public void initialize(){

        fileChooser = new FileChooser();
        fileChooser.setTitle("Open Script File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Script Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
    }

    @FXML
    void onClearButtonClick() {
        Client.clientCommandManager.runCommand("clear");
    }

    @FXML
    void onExecuteScriptButtonClick() {
        File selectedFile = fileChooser.showOpenDialog(executeScriptButton.getScene().getWindow());
        if (selectedFile != null) {
            String scriptPath = selectedFile.getAbsolutePath();
            Client.clientCommandManager.runCommand("execute_script "+scriptPath);
        }
    }

    @FXML
    void onHeadButtonClick() {
        Client.infoAlert(Client.clientCommandManager.runCommand("head").getResponse());
    }

    @FXML
    void onRemoveHeadButtonButtonClick() {
        Client.infoAlert(Client.clientCommandManager.runCommand("remove_head").getResponse());
    }
}
