package server.commandManager.commands.withArg;

import common.dragon.Dragon;

import java.util.Scanner;

public interface CommandWithArgument {
    String execute(String arg, Dragon dragon);
}
