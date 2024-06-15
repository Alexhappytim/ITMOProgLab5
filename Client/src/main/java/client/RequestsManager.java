package client;

import common.network.Request;
import common.network.Response;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

import static java.lang.Thread.sleep;

public class RequestsManager {
    public DatagramChannel channel;
    InetSocketAddress serverAddress;
    public RequestsManager() throws IOException {
        channel= DatagramChannel.open();
        channel.configureBlocking(false);
        serverAddress = new InetSocketAddress("localhost", 1234);
    }


    public boolean sendRequest(Request request){
        if((Client.curLogin.isEmpty() || Client.curPassword.isEmpty()) && !request.getCommand().contains("register")){
            Client.consoleManager.println("Пользователь не авторизован");
            return false;
        }
        request.setLogin(Client.curLogin);
        request.setPassword(Client.curPassword);
        try{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(request);
        byte[] data = bos.toByteArray();
        ByteBuffer buffer = ByteBuffer.wrap(data);
        channel.send(buffer, serverAddress);
        }
        catch (Exception e){System.out.println(e);}
        return true;
    }
    public Response receiveRespond(){
        if(!(Client.curLogin.isEmpty() || Client.curPassword.isEmpty())) {
            try {
                ByteBuffer responseBuffer = ByteBuffer.allocate(8192);
                SocketAddress adress = null;
                Client.consoleManager.print("Ожидаю ответа.");
                int i = 0;
                while (adress == null && i < 100) {
                    adress = channel.receive(responseBuffer);
                    if (i % 10 == 0) {
                        Client.consoleManager.print(".");
                    }
                    sleep(50);
                    i++;
                }
                Client.consoleManager.println("");
                responseBuffer.flip();
                byte[] responseData = new byte[responseBuffer.remaining()];
                responseBuffer.get(responseData);
                ByteArrayInputStream bis = new ByteArrayInputStream(responseData);
                ObjectInputStream ois = new ObjectInputStream(bis);
                Response response = (Response) ois.readObject();

                return response;
            } catch (EOFException eofException) {

                return new Response("Ответ не получен");
            } catch (Exception e) {
                return new Response("Ошибка при получении ответа");
            }
        }
        return new Response("");
    }

}
