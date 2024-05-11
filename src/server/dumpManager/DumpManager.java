package server.dumpManager;

import common.dragon.*;
import server.Server;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DumpManager {
    public void initialReadFromFile(String path) {
        try (FileReader reader = new FileReader(path)) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String temp = scanner.nextLine();
                List<String> items = Arrays.asList(temp.split("\\s*;\\s*"));
                if(!(items.get(1).startsWith("\"") && items.get(1).endsWith("\""))) {
                    throw new IOException();
                }
                if(Dragon.isIdExist(Long.parseLong(items.get(0)))||Long.parseLong(items.get(2))>41||Float.parseFloat(items.get(3))<-49||Long.parseLong(items.get(5))<0||Long.parseLong(items.get(0))<0) {
                    throw new IOException();
                }
                Color color;
                DragonType type;
                switch (items.get(7)) {
                    case "\"GREEN\"" -> {
                        color = Color.GREEN;
                    }
                    case "\"BLACK\"" -> {
                        color = Color.BLACK;
                    }
                    case "\"BLUE\"" -> {
                        color = Color.BLUE;
                    }
                    case "\"ORANGE\"" -> {
                        color = Color.ORANGE;
                    }
                    case "\"BROWN\"" -> {
                        color = Color.BROWN;
                    }
                    default -> {
                        throw new IOException();
                    }

                }
                switch (items.get(8)) {
                case "\"WATER\"" -> {
                    type = DragonType.WATER;
                }
                case "\"UNDERGROUND\"" -> {
                    type = DragonType.UNDERGROUND;
                }
                case "\"AIR\"" -> {
                    type = DragonType.AIR;
                }
                case "\"FIRE\"" -> {
                    type = DragonType.FIRE;
                }
                case "" ->{type = null;}
                default -> {
                    throw new IOException();
                }}
                DragonHead head;
                if(items.get(9).isEmpty()){
                    head=null;
                }else{head=new DragonHead(Double.parseDouble( items.get(9)));}
                Dragon tempDragon = new Dragon(
                        Long.parseLong(items.get(0)),
                        items.get(1).replaceFirst("\"","").replaceFirst("\"",""),
                        new Coordinates(Long.parseLong(items.get(2)),Float.parseFloat(items.get(3))),
                        new Date(Long.parseLong(items.get(4))),
                        Long.parseLong(items.get(5)),
                        Boolean.parseBoolean(items.get(6)),
                        color,
                        type,
                        head
                );
                Server.collectionManager.add(tempDragon);
            }

        } catch (FileNotFoundException e) {
            Server.printError("Ошибка доступа к файлу");
        } catch (Exception e) {
            Server.printError("Ошибка чтения файла");
        }

    }

    public void saveToFile() throws IOException {
        FileWriter fileWriter = new FileWriter("out.csv");

        Iterator<Dragon> iter = Server.collectionManager.getCollection().iterator();
        Dragon temp = null;
        while (iter.hasNext()) {
            temp = iter.next();
            fileWriter.write(temp.getId() + ";\""
                    + temp.getName() + "\";"
                    + temp.getCoordinates().getX() + ";"
                    + temp.getCoordinates().getY() + ";\""
                    + temp.getCreationDate() + "\";"
                    + temp.getAge() + ";"
                    + temp.isSpeaking() + ";\""
                    + temp.getColor().name() + "\";\""
                    + temp.getType().name() + "\";"
                    + temp.getHead().getToothCount() + "\n");
        }
        fileWriter.close();

    }

}
