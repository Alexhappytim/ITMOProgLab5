package com.client.consoleManager.commandManager.commands.withArg;

import common.network.Response;

import java.util.Scanner;

public interface CommandWithArgument {
    Response execute(String arg);
    Response executeFromScript(String arg, Scanner scanner);
}
