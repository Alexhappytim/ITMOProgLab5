package com.client.consoleManager.commandManager.commands.withoutArg;

import common.network.Response;

import java.util.Scanner;

public interface Command {
    Response execute();
    Response executeFromScript(Scanner scanner);
}
