package server;

import common.network.Request;
import common.network.Response;
import server.collectionManager.CollectionManager;
import server.dumpManager.DumpManager;
import server.commandManager.CommandManager;
import server.network.ConnectionManager;

public class Server {
    public static CollectionManager collectionManager;
    public static CommandManager commandManager;
    public static DumpManager dumpManager;
    public static boolean isRunning = true;

    public static ConnectionManager connectionManager;

    public static void start(String fileAdress){
        collectionManager = new CollectionManager();
        commandManager = new CommandManager();
        dumpManager = new DumpManager();
        dumpManager.initialReadFromFile(fileAdress);
        try {
           connectionManager = new ConnectionManager(1234);
        }catch (Exception e){
            printError("не коннектится");
            return;
        }
        while(isRunning){
            Request request = connectionManager.receiveReq();
            connectionManager.sendResp(new Response(commandManager.runCommand(request.getCommand(),request.getArg())));
        }
    }
    public static void printError(String error){
        System.out.println("\u001B[31m" +"<Server>:Error - "+error+"\u001B[31m");
    }
    public static void printInfo(String info){
        System.out.println("\u001B[32m" +"<Server>:Info - "+info+"\u001B[32m");
    }

}
