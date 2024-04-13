package ConsoleManager;

import ConsoleManager.commands.withArg.*;
import ConsoleManager.commands.withoutArg.*;
import collectionManager.ValidateError;
import dragon.*;
import execution.ExecutionManager;

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
        commandArgHashMap.put("execute_script", new ExecuteScriptCommand());
        commandArgHashMap.put("filter_by_color", new FilterByColor());
        commandArgHashMap.put("filter_contains_name", new FilterContainsName());
        commandArgHashMap.put("filter_less_than_speaking", new FilterLessThanSpeaking());
    }
    public void runCommand(String command){
        String[] com = command.split(" ");
        if(commandHashMap.containsKey(com[0])){
                commandHashMap.get(com[0]).execute();
        }else if(commandArgHashMap.containsKey(com[0])){
                commandArgHashMap.get(com[0]).execute(command.replaceFirst(com[0] + " ", ""));
        }else{
            ExecutionManager.consoleManager.println("Нет такой команды");
        }
    }

    public void runCommand(String command, Scanner scanner){
        String[] com = command.split(" ");
        if(commandHashMap.containsKey(com[0])){
                commandHashMap.get(com[0]).executeFromScript(scanner);
        }else if(commandArgHashMap.containsKey(com[0])){
                commandArgHashMap.get(com[0]).executeFromScript(command.replaceFirst(com[0]+" ",""),scanner);
        }else{
            ExecutionManager.consoleManager.println("Нет такой команды");
        }
    }

    public Dragon inputNewElementFromFile(Scanner scanner) {
        String nameS, coordXS, coordYS, ageS, speakingS, colorS, typeS, toothCountS;
        Long coordX = null;
        Float coordY = null;
        Long age = null;
        Boolean speaking = false;
        Color color = null;
        DragonType type = null;
        DragonHead head = null;


        boolean normTakoiDragon = true;
        nameS = scanner.nextLine();
        if (nameS.isEmpty()) {
            normTakoiDragon = false;
        }



        coordXS = scanner.nextLine();
        if (!coordXS.isEmpty()) {
            try {
                coordX = Long.parseLong(coordXS);
                if (coordX > 41) {
                    normTakoiDragon = false;
                }
            } catch (Exception e) {
                normTakoiDragon = false;
            }
        } else {
            normTakoiDragon = false;
        }

        coordYS = scanner.nextLine();
        if (!coordYS.isEmpty()) {
            try {
                coordY = Float.parseFloat(coordYS);
                if (coordY < -49) {
                    normTakoiDragon = false;

                }
            } catch (Exception e) {
                normTakoiDragon = false;

            }
        } else {
            normTakoiDragon = false;
        }

        ageS = scanner.nextLine();
        if (!ageS.isEmpty()) {
            try {
                age = Long.parseLong(ageS);
                if (age < 0) {
                    normTakoiDragon = false;
                }
            } catch (Exception e) {
                normTakoiDragon = false;
            }
        } else {
            age = null;
        }

        speakingS = scanner.nextLine();
        if (!speakingS.isEmpty()) {
            try {
                speaking = Boolean.parseBoolean(speakingS);
                if(!(speakingS.equals("false")||speakingS.equals("true"))){
                    normTakoiDragon = false;
                }
            } catch (Exception e) {
                normTakoiDragon = false;
            }
        } else {
            normTakoiDragon = false;
        }

        colorS = scanner.nextLine();
        if (!colorS.isEmpty()) {
            switch (colorS) {
                case "GREEN" -> {
                    color = Color.GREEN;
                }
                case "BLACK" -> {
                    color = Color.BLACK;
                }
                case "BLUE" -> {
                    color = Color.BLUE;
                }
                case "ORANGE" -> {
                    color = Color.ORANGE;
                }
                case "BROWN" -> {
                    color = Color.BROWN;
                }
                default -> {
                    normTakoiDragon = false;
                }
            }
        } else {
            normTakoiDragon = false;
        }
        typeS = scanner.nextLine();
        if (!typeS.isEmpty()) {
            switch (typeS) {
                case "WATER" -> {
                    type = DragonType.WATER;
                }
                case "UNDERGROUND" -> {
                    type = DragonType.UNDERGROUND;
                }
                case "AIR" -> {
                    type = DragonType.AIR;
                }
                case "FIRE" -> {
                    type = DragonType.FIRE;
                }
                default -> {
                    normTakoiDragon = false;
                }
            }
        } else {
            type = null;
        }

        toothCountS = scanner.nextLine();
        if (!toothCountS.isEmpty()) {
            try {
                Double toothCount = Double.parseDouble(toothCountS);
                head = new DragonHead(toothCount);
            } catch (Exception e) {
                normTakoiDragon = false;
            }
        } else {
            head = null;
        }
        if(normTakoiDragon) {
            return new Dragon(nameS, new Coordinates(coordX, coordY), age, speaking, color, type, head);
        }
        else{return null;}

    }



}
