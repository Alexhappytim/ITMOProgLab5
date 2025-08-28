package com.client.ui.map;

import com.client.ClientMain;
import common.dragon.Dragon;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.PriorityQueue;

public class MapScene {
    private Stage stage;

    public MapScene(Integer currentLocaleIndex, PriorityQueue<Dragon> collection) {
        try {
            System.out.println(collection);
            stage = new Stage();
            stage.setResizable(false);
            FXMLLoader loader = new FXMLLoader(ClientMain.class.getResource("xml/map.fxml"));

            Parent root = loader.load();
            MapController controller = loader.getController();
            controller.setCurrentLocaleIndex(currentLocaleIndex);


            this.stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadColorMap(Map<String, Color> colorScheme, Map<Long, String> ownership){

    }

    public void show() {
        stage.show();
    }
}
