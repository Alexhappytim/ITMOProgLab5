package server.multiThreading;

import common.network.Request;
import common.network.Response;
import server.Server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProcessingThread extends Thread{
    Request request;
    public ProcessingThread(Request request){
        this.request = request;
    }
    @Override
    public void run() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Server.lockCommands.lock();
        if (Server.dbConnection.checkUser(request.getLogin(), request.getPassword()) || request.getCommand().startsWith("register")) {
            if(request.getArg()!=null) {
                request.getArg().setAuthorId(Server.dbConnection.getUserId(request.getLogin()));
            }
            Response resp = new Response(Server.commandManager.runCommand(request.getCommand(), request.getArg(), Server.dbConnection.getUserId(request.getLogin())));

            Server.lockCommands.unlock();

            executorService.submit(new ResponceThread(resp));
        } else {
            Response resp = new Response("Неправильный логин/пароль");
            Server.lockCommands.unlock();
            executorService.submit(new ResponceThread(resp));
        }
    }
}
