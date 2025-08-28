package com.client;


import com.client.consoleManager.ConsoleManager;
import com.client.consoleManager.commandManager.ClientCommandManager;
import javafx.scene.control.Alert;

public class Client {
    public static boolean isRunning= true;
    public static ConsoleManager consoleManager= new ConsoleManager();
    public static ClientCommandManager clientCommandManager= new ClientCommandManager();
    public static RequestsManager requestsManager;
    public static String curLogin = "";
    public static String curPassword = "";
    public static void start(){
        consoleManager.start();
        try{
            requestsManager = new RequestsManager();
        }catch (Exception e){
            System.out.println("Непредвиденная ошибка реквестменеджера");
        }


    }

    public static void infoAlert(String info) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(info);
        alert.showAndWait();
    }


    public static void errorAlert(String error) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(error);
        alert.showAndWait();
    }
}