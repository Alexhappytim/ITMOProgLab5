package common.network;

import client.Client;
import common.dragon.Dragon;

import java.io.Serializable;

public class Request implements Serializable {
    private static final long serialVersionUID = 38512837591824689L;
    private String command;
    private Dragon arg;
    private String login;
    private String password;
    public Request(String command,Dragon arg, String login, String password){
        this.command = command;
        this.arg = arg;
        this.login = login;
        this.password = password;
    }
    public Request(String command,Dragon arg){
        this.command = command;
        this.arg = arg;
        this.login = Client.curLogin;
        this.password = Client.curPassword;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Dragon getArg() {
        return arg;
    }

    public void setArg(Dragon arg) {
        this.arg = arg;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
