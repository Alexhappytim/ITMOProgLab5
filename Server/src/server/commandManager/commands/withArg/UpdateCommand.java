package server.commandManager.commands.withArg;

import common.dragon.Dragon;
import common.network.Response;
import server.Server;

import java.util.Iterator;

public class UpdateCommand implements CommandWithArgument {


    @Override
    public Response execute(String arg, Dragon dragon, Integer userId) {
        try{
            Long a = Long.parseLong(arg);
            String tempType;
            if(dragon.getType() == null){
                tempType = "NULL, ";
            }else{
                tempType = "'"+dragon.getType()+"', ";
            }
            Server.dbConnection.executeInsertReq("update dragons set "+
                    "name='"+dragon.getName()+"', " +
                    "x="+dragon.getCoordinates().getX()+", "+
                    "y="+dragon.getCoordinates().getY()+", "+
                    "age="+dragon.getAge()+", "+
                    "creation_date=NOW(), "+
                    "speaking="+dragon.isSpeaking()+", "+
                    "color='"+dragon.getColor()+"', "+
                    "type="+tempType+
                    "tooth_count="+dragon.getToothCount()+" where id="+a+"and author_id="+userId);

            Iterator<Dragon> iter = Server.collectionManager.getCollection().iterator();
            Dragon temp = null;
            while(iter.hasNext()) {
                temp = iter.next();
                if (temp.getId().equals(a) && temp.getAuthorId().equals(userId)) {
                    Server.collectionManager.updateById(a,dragon,userId);
                    return new Response("Элемент обновлен",Response.OK);
                }
            }
            return new Response("У вас нет элемента с таким id",Response.NOSUCHELEMENT);
        }catch(Exception e){
            e.printStackTrace();
            return new Response("",Response.UNKNOWNERROR);
        }

    }
}
