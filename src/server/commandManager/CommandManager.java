package server.commandManager;

import server.Server;
import server.commandManager.commands.withArg.*;
import server.commandManager.commands.withoutArg.*;
import common.dragon.*;

import java.util.HashMap;
import java.util.Scanner;

public class CommandManager {
    private HashMap<String, Command> commandHashMap;
    private HashMap<String, CommandWithArgument> commandArgHashMap;
    public CommandManager(){
        commandHashMap=new HashMap<>();
        commandArgHashMap=new HashMap<>();
        commandHashMap.put("help",new HelpCommand());
        commandHashMap.put("add",new AddCommand());
        commandHashMap.put("add_if_max",new AddIfMaxCommand());
        commandHashMap.put("info",new InfoCommand());
        commandHashMap.put("show",new ShowCommand());
        commandHashMap.put("clear",new ClearCommand());
        commandHashMap.put("save",new SaveCommand());
        commandHashMap.put("exit", new ExitCommand());
        commandHashMap.put("head",new HeadCommand());
        commandHashMap.put("remove_head",new RemoveHeadCommand());

        commandArgHashMap.put("update", new UpdateCommand());
        commandArgHashMap.put("remove_by_id", new RemoveByIdCommand());
        commandArgHashMap.put("filter_by_color", new FilterByColor());
        commandArgHashMap.put("filter_contains_name", new FilterContainsName());
        commandArgHashMap.put("filter_less_than_speaking", new FilterLessThanSpeaking());
    }
    public String runCommand(String command,Dragon dragon){
        String[] com = command.split(" ");
        if(commandHashMap.containsKey(com[0])){
                return commandHashMap.get(com[0]).execute(dragon);
        }
        else if(commandArgHashMap.containsKey(com[0])){
                return commandArgHashMap.get(com[0]).execute(command.replaceFirst(com[0] + " ", ""), dragon);
        }
        return "";
    }




}
