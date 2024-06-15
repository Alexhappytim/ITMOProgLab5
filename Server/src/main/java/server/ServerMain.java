package server;

import server.network.database.DBConnection;

import java.io.FileNotFoundException;
import java.net.SocketException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServerMain {
    public static void main(String[] args) throws SocketException {
         Server.start(args[0]);



        //execute_script C:\Users\timos\Desktop\отчетики\прога\lab5\lab5\src\script.txt
    }
}
