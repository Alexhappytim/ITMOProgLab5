package server.network.database;

import server.Server;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.Scanner;
import java.util.Stack;

public class DBConnection {
    private Connection connection;

    public DBConnection(String arg) throws FileNotFoundException, SQLException {
        FileReader reader = new FileReader(arg);
        Scanner scanner = new Scanner(reader);
        String url = scanner.nextLine();
        String login = scanner.nextLine();
        String password = scanner.nextLine();
        connection = DriverManager.getConnection(url,login,password);
    }

    public ResultSet executeGetReq(String str) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            return statement.executeQuery(str);
        } catch (SQLException e) {
            Server.printError("Потеряна связь с базой данных");
            return null;
        }

    }
    public int executeInsertReq(String str){

        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(str);
        } catch (SQLException e) {
            Server.printError("Потеряна связь с базой данных");
            return -1;
        }
    }
    public Boolean checkUser(String login,String password){
        ResultSet res = executeGetReq("select * from users where login='"+login+"' and password='"+password+"'");
        try {
            return res.next();
        } catch (SQLException e) {
            Server.printError("Потеряна связь с базой данных");
            return false;
        }
    }
    public Integer getUserId(String login){
        ResultSet res = executeGetReq("select id from users where login='"+login+"'");
        try {
            if(res.next()){
                return res.getInt(1);
            }else{
                return -1;
            }
        } catch (SQLException e) {
            Server.printError("Потеряна связь с базой данных");
            return -1;
        }
    }

    public Integer getCurrentId(){
        try {
            ResultSet res = executeGetReq("select currval('s409683.dragons_id_seq') as a from s409683.dragons");
            res.next();
            return res.getInt(1);
        } catch (SQLException e) {
            Server.printError("Потеряна связь с базой данных");
            return -1;
        }
    }
}
