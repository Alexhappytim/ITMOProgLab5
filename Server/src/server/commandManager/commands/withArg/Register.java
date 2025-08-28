package server.commandManager.commands.withArg;

import common.dragon.Dragon;
import common.network.Response;
import server.Server;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Register implements CommandWithArgument{
    @Override
    public Response execute(String arg, Dragon dragon, Integer userId) {
       ResultSet res = Server.dbConnection.executeGetReq("select * from users where login='"+arg.split(" ")[0]+"'");
        try {
            if(!res.next()){
                Server.dbConnection.executeInsertReq("insert into users (login, password) values ('"+arg.split(" ")[0]+"', '"+arg.split(" ")[1]+"')");
                return new Response( "Вы успешно зарегистрировались\nДля дальнейшей работы залогиньтесь через команду login {login} {password}",Response.OK);
            }else{
                return new Response("Пользователь с таким логином существует", Response.ALREADYEXIST);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
