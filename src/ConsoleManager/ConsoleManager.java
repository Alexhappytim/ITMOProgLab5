package ConsoleManager;

import collectionManager.ValidateError;
import dragon.*;
import execution.ExecutionManager;

import javax.swing.text.StyledEditorKit;
import java.util.*;

public class ConsoleManager {
    Scanner in = new Scanner(System.in);

    public void start() {
        println("Вас приветствует менеджер коллекции драконов!\nВведите команду(для получения списка команд напишите help)");

    }

    public Dragon inputNewElement() {
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
                        1 / 0
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
        return new Dragon(nameS, new Coordinates(coordX, coordY), age,speaking,color,type,head);

    }

    public void printError(CustomError error) {
        println(error.getErrorMessage());
    }

    public void println(String line) {
        System.out.println(line);
    }

    public void printCollection(Collection<Dragon> col){
        int[] stringSizes = {0,0,0,0,0,0,0,0,0,0};
        Iterator<Dragon> iter = col.iterator();
        ArrayList<Dragon> collection = new ArrayList<>();
        Dragon temp = null;
        while (iter.hasNext()) {
            temp = iter.next();
            stringSizes[0] = Math.max(temp.getId().toString().length(),stringSizes[0]);
            stringSizes[1] = Math.max(temp.getName().length(),stringSizes[1]);
            stringSizes[2] = Math.max(temp.getCoordinates().getX().toString().length(),stringSizes[2]);
            stringSizes[3] = Math.max(Float.valueOf(temp.getCoordinates().getY()).toString().length(),stringSizes[3]);
            stringSizes[4] = Math.max(temp.getCreationDate().toString().length(),stringSizes[4]);
            stringSizes[5] = Math.max(temp.getAge().toString().length(),stringSizes[5]);
            stringSizes[6] = Math.max(Boolean.valueOf(temp.isSpeaking()).toString().length(),stringSizes[6]);
            stringSizes[7] = Math.max(temp.getColor().name().length(),stringSizes[7]);
            stringSizes[8] = Math.max(temp.getType().name().length(),stringSizes[8]);
            stringSizes[9] = Math.max(temp.getHead().getToothCount().toString().length(),stringSizes[9]);

            collection.add(temp);
        }
        ExecutionManager.consoleManager.println(String.valueOf("-").repeat(Arrays.stream(stringSizes).sum()+21));
        for (Dragon dragon : collection) {
            ExecutionManager.consoleManager.println("|" + dragon.getId() + String.valueOf(" ").repeat(stringSizes[0] - dragon.getId().toString().length()) + " |" +
                    dragon.getName() + String.valueOf(" ").repeat(stringSizes[1] - dragon.getName().length()) + " |" +
                    dragon.getCoordinates().getX() + String.valueOf(" ").repeat(stringSizes[2] - dragon.getCoordinates().getX().toString().length()) + " |" +
                    dragon.getCoordinates().getY() + String.valueOf(" ").repeat(stringSizes[3] - Float.valueOf(dragon.getCoordinates().getY()).toString().length()) + " |" +
                    dragon.getCreationDate() + String.valueOf(" ").repeat(stringSizes[4] - dragon.getCreationDate().toString().length()) + " |" +
                    dragon.getAge() + String.valueOf(" ").repeat(stringSizes[5] - dragon.getAge().toString().length()) + " |" +
                    dragon.isSpeaking() + String.valueOf(" ").repeat(stringSizes[6] - Boolean.valueOf(dragon.isSpeaking()).toString().length()) + " |" +
                    dragon.getColor().name() + String.valueOf(" ").repeat(stringSizes[7] - dragon.getColor().name().length()) + " |" +
                    dragon.getType().name() + String.valueOf(" ").repeat(stringSizes[8] - dragon.getType().name().length()) + " |" +
                    dragon.getHead().getToothCount() + String.valueOf(" ").repeat(stringSizes[9] - dragon.getHead().getToothCount().toString().length()) + " |");
        }

        ExecutionManager.consoleManager.println(String.valueOf("-").repeat(Arrays.stream(stringSizes).sum()+21));
    }
}
