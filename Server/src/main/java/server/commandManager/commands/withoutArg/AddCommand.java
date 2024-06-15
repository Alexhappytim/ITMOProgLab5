package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import server.Server;

import java.sql.ClientInfoStatus;

public class AddCommand implements Command {
    @Override
    public String execute(Dragon dragon, Integer userId) {
        String tempType;
        if(dragon.getType() == null){
            tempType = "null, ";
        }else{
            tempType = "'"+dragon.getType()+"', ";
        }
        int tmp = Server.dbConnection.executeInsertReq(
                "insert into dragons " +
                        "(name, x, y, age, speaking, color, type, tooth_count, author_id)" +
                        "VALUES (" +
                        "'"+dragon.getName()+"', " +
                        dragon.getCoordinates().getX()+", "+
                        dragon.getCoordinates().getY()+", "+
                        dragon.getAge()+", "+
                        dragon.isSpeaking()+", "+
                        "'"+dragon.getColor()+"', "+
                        tempType+
                        dragon.getToothCount()+", "+
                        userId+")"
                        );

        if(tmp>0){
        Server.collectionManager.add(new Dragon(Long.valueOf(Server.dbConnection.getCurrentId()), dragon.getName(),
                dragon.getCoordinates(),
                dragon.getAge(),
                dragon.isSpeaking(),
                dragon.getColor(),
                dragon.getType(),
                dragon.getHead(),
                userId));

        return "Элемент успешно добавлен";}
        return "Ошибка при добавлении в базу данных";
    }


}
