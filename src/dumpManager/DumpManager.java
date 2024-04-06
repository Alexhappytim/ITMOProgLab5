package dumpManager;

import dragon.Dragon;
import execution.ExecutionManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DumpManager {
    public ArrayList<String> initialReadFromFile(String path) {
        ArrayList<String> temp = new ArrayList<>();
        try (FileReader reader = new FileReader(path)) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                temp.add(scanner.nextLine());
            }
            return temp;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveToFile() throws IOException {
        FileWriter fileWriter = new FileWriter("out.csv");

        Iterator<Dragon> iter = ExecutionManager.collectionManager.getCollection().iterator();
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
