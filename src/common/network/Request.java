package common.network;

import common.dragon.Dragon;

import java.io.Serializable;

public class Request implements Serializable {
    private String command;
    private Dragon arg;
    public Request(String command,Dragon arg){

        this.command = command;
        this.arg = arg;
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
}
