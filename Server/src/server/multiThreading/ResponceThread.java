package server.multiThreading;

import common.network.Response;
import server.Server;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class ResponceThread implements Runnable{
    Response resp;
    public ResponceThread(Response resp){
        this.resp = resp;
    }
    @Override
    public void run() {
        Server.lockSending.lock();
        try{
            if(resp.getStatusCode().equals(Response.OK) ){
            resp.setCollection(Server.collectionManager.getCollection());
            Map<Long, String> ownershipMap = new HashMap<>();
            ResultSet set = Server.dbConnection.executeGetReq("select users.id, users.login from users");
            while (set.next()){
                ownershipMap.put(set.getLong(1), set.getString(2));
            }
            resp.setOwnershipMap(ownershipMap);}
        }catch (Exception e){
            e.printStackTrace();
        }

        Server.connectionManager.sendResp(resp);
        Server.lockSending.unlock();
    }
}
