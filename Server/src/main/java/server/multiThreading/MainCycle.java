package server.multiThreading;

import common.network.Request;
import common.network.Response;
import server.Server;

import java.util.Scanner;
import java.util.concurrent.RecursiveTask;

public class MainCycle extends RecursiveTask<Integer> {
    int mode;
    public MainCycle(int mode){
        this.mode = mode;
    }
    @Override
    protected Integer compute() {
        switch (mode){
            case 0:{
                new MainCycle(1).fork();
                new MainCycle(2).fork();
            }
            case 1:{
                while (Server.isRunning) {
                    Server.lockConnection.lock();
                    Request request = Server.connectionManager.receiveReq();

                    Server.lockConnection.unlock();
                    if (request != null) {
                        ProcessingThread thread = new ProcessingThread(request);
                        thread.start();
                    }

                }
            }
            case 2:{
                while (Server.isRunning) {
                Scanner in = new Scanner(System.in);
                try {
                    if (System.in.available() != 0) {
                        Server.lockCommands.lock();

                        Server.commandManager.runCommandLocal(in.nextLine());
                        Server.lockCommands.unlock();

                    }
                } catch (Exception e) {}
                }
            }
        }



        return 1;
    }
}
