package client;

import client.consoleManager.ConsoleManager;
import client.consoleManager.commandManager.ClientCommandManager;

public class Client {
    public static boolean isRunning= true;
    public static ConsoleManager consoleManager= new ConsoleManager();
    public static ClientCommandManager clientCommandManager= new ClientCommandManager();
    public static RequestsManager requestsManager;
    public static String curLogin = "";
    public static String curPassword = "";
    public Client(){
        consoleManager.start();
        try{
            requestsManager = new RequestsManager();
        }catch (Exception e){
            System.out.println("Непредвиденная ошибка реквестменеджера");
        }
        while(isRunning) {
            String inputCommand = consoleManager.input();
            clientCommandManager.runCommand(inputCommand);
        }
        try {
            requestsManager.channel.close();
        }catch (Exception e){}

    }
}