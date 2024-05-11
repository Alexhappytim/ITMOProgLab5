package client;

import client.consoleManager.commandManager.ClientCommandManager;
import client.consoleManager.ConsoleManager;

public class Client {
    public static boolean isRunning= true;
    public static ConsoleManager consoleManager= new ConsoleManager();
    public static ClientCommandManager clientCommandManager= new ClientCommandManager();
    public static RequestsManager requestsManager;
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