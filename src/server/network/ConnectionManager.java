package server.network;

import common.network.Request;
import common.network.Response;
import server.Server;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ConnectionManager {

    public DatagramSocket socket;
    byte[] buffer;
    DatagramPacket packet;
    public ConnectionManager(int port) throws SocketException {
        socket= new DatagramSocket(port);
        buffer = new byte[1024];
        packet = new DatagramPacket(buffer, buffer.length);
    }

    public Request receiveReq(){
        try {
                socket.receive(packet);
                ByteArrayInputStream bis = new ByteArrayInputStream(packet.getData());
                ObjectInputStream ois = new ObjectInputStream(bis);
                Request request = (Request) ois.readObject();
            Server.printInfo("Получил реквест "+request);
                return request;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void sendResp(Response resp){
        try {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(resp);
        byte[] response = bos.toByteArray();
        DatagramPacket responsePacket = new DatagramPacket(response, response.length, packet.getAddress(), packet.getPort());
        socket.send(responsePacket);
            Server.printInfo("Отправил респонс "+resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
