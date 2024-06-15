package server.multiThreading;

import common.network.Response;
import server.Server;

public class ResponceThread implements Runnable{
    Response resp;
    public ResponceThread(Response resp){
        this.resp = resp;
    }
    @Override
    public void run() {
        Server.lockSending.lock();
        Server.connectionManager.sendResp(resp);
        Server.lockSending.unlock();
    }
}
