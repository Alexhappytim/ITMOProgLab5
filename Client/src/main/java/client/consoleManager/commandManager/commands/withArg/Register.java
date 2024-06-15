package client.consoleManager.commandManager.commands.withArg;

import client.Client;
import common.network.Request;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Register implements CommandWithArgument{
    @Override
    public void execute(String arg) {
        String tmp = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD2");
            // Хеширование строки
            byte[] hash = md.digest(arg.split(" ")[1].getBytes());
            // Преобразование хеша в шестнадцатеричное представление
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            Client.requestsManager.sendRequest(new Request("register "+arg.split(" ")[0]+" "+hexString.toString(),null));

            Client.consoleManager.println(Client.requestsManager.receiveRespond().getResponse());
        } catch (NoSuchAlgorithmException e) {
            Client.consoleManager.println("Ошибка хэширования");
        }
        catch (ArrayIndexOutOfBoundsException e){
            Client.consoleManager.println("Введите логин и пароль как аргументы команды");
        }


    }

    @Override
    public void executeFromScript(String arg, Scanner scanner) {
        execute(arg);
    }
}
