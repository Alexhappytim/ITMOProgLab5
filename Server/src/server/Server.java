package server;

import common.network.Request;
import common.network.Response;
import server.collectionManager.CollectionManager;
import server.dumpManager.DumpManager;
import server.commandManager.CommandManager;
import server.network.ConnectionManager;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Server {
    public static CollectionManager collectionManager;
    public static CommandManager commandManager;
    public static DumpManager dumpManager;
    public static boolean isRunning = true;

    public static ConnectionManager connectionManager;
    public static Logger logger = Logger.getLogger(ServerMain.class.getName());



    public static void start(String fileAdress){
        try {
            FileHandler fileHandler = new FileHandler("log.txt");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        collectionManager = new CollectionManager();
        commandManager = new CommandManager();
        dumpManager = new DumpManager();
        dumpManager.initialReadFromFile(fileAdress);
        try {
           connectionManager = new ConnectionManager(1234);
        }catch (Exception e){
            logger.severe("Порт занят");
            return;
        }
        logger.info("Сервер инициализирован");
        Scanner in = new Scanner(System.in);
        while(isRunning){
            Request request = connectionManager.receiveReq();
            if(request != null){
            connectionManager.sendResp(new Response(commandManager.runCommand(request.getCommand(),request.getArg())));}
            try{
            if(System.in.available()!=0){
                commandManager.runCommandLocal(in.nextLine());
            }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        logger.info("Сервер закончил работу штатно");
    }
    public static void printError(String error){
        logger.severe(error);
    }
    public static void printInfo(String info){
        logger.info(info);
    }

}
