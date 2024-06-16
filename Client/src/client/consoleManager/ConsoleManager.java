package client.consoleManager;

import common.dragon.*;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleManager {
    Scanner in = new Scanner(System.in);

    public void start() {
        println("Вас приветствует менеджер коллекции драконов!\nВведите команду(для получения списка команд напишите help)");

    }
    public String input(){
        return in.nextLine();
    }

    public Dragon inputNewElement() {
        try{
        String nameS, coordXS, coordYS, ageS, speakingS, colorS, typeS, toothCountS;
        Long coordX = null;
        Float coordY = null;
        Long age = null;
        Boolean speaking = false;
        Color color = null;
        DragonType type = null;
        DragonHead head = null;
        do {
            println("Введите имя");
            nameS = in.nextLine();
            if (nameS.isEmpty()) {
                printError(ValidateError.NAMEISNULL);
            }
        } while (nameS.isEmpty());

        do {
            println("Введите поле X подкласса coordinates");
            coordXS = in.nextLine();
            if (!coordXS.isEmpty()) {
                try {
                    coordX = Long.parseLong(coordXS);
                    if (coordX > 41) {
                        printError(ValidateError.BIGX);
                        coordXS = "";
                    }
                } catch (Exception e) {
                    printError(ValidateError.PARSINGERROR);
                    coordXS = "";
                }
            } else {
                printError(ValidateError.COORDXISNULL);
            }
        } while (coordXS.isEmpty());

        do {
            println("Введите поле Y подкласса coordinates");
            coordYS = in.nextLine();
            if (!coordYS.isEmpty()) {
                try {
                    coordY = Float.parseFloat(coordYS);
                    if (coordY < -49) {
                        printError(ValidateError.SMALLY);
                        coordYS = "";
                    }
                } catch (Exception e) {
                    printError(ValidateError.PARSINGERROR);
                    coordYS = "";
                }
            } else {
                printError(ValidateError.COORDYISNULL);
            }
        } while (coordYS.isEmpty());

        do {
            println("Введите возраст");
            ageS = in.nextLine();
            if (!ageS.isEmpty()) {
                try {
                    age = Long.parseLong(ageS);
                    if (age < 0) {
                        printError(ValidateError.NEGATIVEAGE);
                        ageS = "#specialKostil";
                    }
                } catch (Exception e) {
                    printError(ValidateError.PARSINGERROR);
                    ageS = "#specialKostil";
                }
            } else {
                age = null;
            }
        } while (ageS.equals("#specialKostil"));

        do {
            println("Введите поле speaking");
            speakingS = in.nextLine();
            if (!speakingS.isEmpty()) {
                try {
                    speaking = Boolean.parseBoolean(speakingS);
                    if(!(speakingS.equals("false")||speakingS.equals("true"))){
                        int i = 1 / 0;
                    }
                } catch (Exception e) {
                    printError(ValidateError.PARSINGERROR);
                    speakingS = "";
                }
            } else {
                printError(ValidateError.SPEAKINGISNULL);
            }
        } while (speakingS.isEmpty());

        do {
            println("Выберете класс энама Color.");
            println("Для этого введите одно из:GREEN; BLACK; BLUE; ORANGE; BROWN");

            colorS = in.nextLine();
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
                        printError(ValidateError.NOSUCHCOLOR);
                        colorS = "";
                    }
                }
            } else {
                printError(ValidateError.COLORISNULL);
            }
        } while (colorS.isEmpty());

        do {
            println("Выберете класс энама DragonType.");
            println("Для этого введите одно из:WATER; UNDERGROUND; AIR; FIRE");

            typeS = in.nextLine();
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
                        printError(ValidateError.NOSUCHTYPE);
                        typeS = "#specialKostil";
                    }
                }
            } else {
                type = null;
            }
        } while (typeS.equals("#specialKostil"));

        do {
            println("Введите количество зубов, пустая строка означает что сама голова это null");
            toothCountS = in.nextLine();
            if (!toothCountS.isEmpty()) {
                try {
                    Double toothCount = Double.parseDouble(toothCountS);
                    head = new DragonHead(toothCount);
                } catch (Exception e) {
                    printError(ValidateError.PARSINGERROR);
                    toothCountS = "#specialKostil";
                }
            } else {
                head = null;
            }
        } while (toothCountS.equals("#specialKostil"));
        return new Dragon(nameS, new Coordinates(coordX, coordY), age,speaking,color,type,head,42);
        }catch(NoSuchElementException e){
            System.exit(0);
        }

        return null;
    }

    public void printError(CustomError error) {
        println(error.getErrorMessage());
    }

    public void println(String line) {
        System.out.println(line);
    }
    public void print(String line) {
        System.out.print(line);
    }


}
