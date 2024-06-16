package server;

import common.dragon.*;
import server.collectionManager.CollectionManager;
import server.commandManager.CommandManager;
import server.dumpManager.DumpManager;
import server.multiThreading.MainCycle;
import server.network.ConnectionManager;
import server.network.database.DBConnection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Server {
    public static CollectionManager collectionManager;
    public static CommandManager commandManager;
    public static DumpManager dumpManager;
    public static boolean isRunning = true;

    public static ConnectionManager connectionManager;
    public static DBConnection dbConnection;
    public static Logger logger = Logger.getLogger(ServerMain.class.getName());
    public static ReentrantLock lockConnection= new ReentrantLock();
    public static ReentrantLock lockCommands = new ReentrantLock();

    public static ReentrantLock lockSending = new ReentrantLock();

    public static void start() {
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
        //dumpManager.initialReadFromFile(fileAdress);
        try {
            connectionManager = new ConnectionManager(1234);
        } catch (Exception e) {
            logger.severe("Порт занят");
            return;
        }
        try {
            dbConnection = new DBConnection("config.txt");

            ResultSet resultSet = dbConnection.executeGetReq("SELECT * FROM dragons");
            while (resultSet.next()) {
                DragonType temp;
                if (resultSet.getString("type") != null) {
                    temp = DragonType.valueOf(resultSet.getString("type"));
                } else {
                    temp = null;
                }
                collectionManager.add(
                        new Dragon(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                new Coordinates(resultSet.getLong("x"), resultSet.getFloat("y")),
                                resultSet.getDate("creation_date"),
                                resultSet.getLong("age"),
                                resultSet.getBoolean("speaking"),
                                Color.valueOf(resultSet.getString("color")),
                                temp,
                                new DragonHead(resultSet.getDouble("tooth_count")),
                                resultSet.getInt("author_id")
                    )
                );
            }

        } catch (FileNotFoundException e) {
            logger.severe("Конфиг не найден");
            return;
        } catch (SQLException e) {
            logger.severe("Ошибка подключения к базе данных");
            return;
        }

        logger.info("Сервер инициализирован");
        MainCycle mainCycle = new MainCycle(0);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(mainCycle);

        logger.info("Сервер закончил работу штатно");
    }

    public static void printError(String error) {
        logger.severe(error);
    }

    public static void printInfo(String info) {
        logger.info(info);
    }

}
