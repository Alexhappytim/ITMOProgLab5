package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import server.Server;

import java.util.*;

public class ShowCommand implements Command {

    @Override
    public String execute(Dragon dragon1) {
        Collection<Dragon> col = Server.collectionManager.getCollection();
        String output = "";
        int[] stringSizes = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Iterator<Dragon> iter = col.iterator();
        ArrayList<Dragon> collection = new ArrayList<>();
        Dragon temp = null;
        while (iter.hasNext()) {
            temp = iter.next();
            stringSizes[0] = Math.max(temp.getId().toString().length(), stringSizes[0]);
            stringSizes[1] = Math.max(temp.getName().length(), stringSizes[1]);
            stringSizes[2] = Math.max(temp.getCoordinates().getX().toString().length(), stringSizes[2]);
            stringSizes[3] = Math.max(Float.valueOf(temp.getCoordinates().getY()).toString().length(), stringSizes[3]);
            stringSizes[4] = Math.max(temp.getCreationDate().toString().length(), stringSizes[4]);
            stringSizes[5] = Math.max(temp.getAge().toString().length(), stringSizes[5]);
            stringSizes[6] = Math.max(Boolean.valueOf(temp.isSpeaking()).toString().length(), stringSizes[6]);
            stringSizes[7] = Math.max(temp.getColor().name().length(), stringSizes[7]);
            if (temp.getType() == null) {
                stringSizes[8] = Math.max(4, stringSizes[8]);
            } else {
                stringSizes[8] = Math.max(temp.getType().name().length(), stringSizes[8]);
            }
            if (temp.getHead() == null) {
                stringSizes[9] = Math.max(4, stringSizes[9]);
            } else {
                stringSizes[9] = Math.max(temp.getHead().getToothCount().toString().length(), stringSizes[9]);
            }


            collection.add(temp);
        }
        output += String.valueOf("-").repeat(Arrays.stream(stringSizes).sum() + 21) + "\n";
        collection.sort(new Comparator<Dragon>() {
            @Override
            public int compare(Dragon o1, Dragon o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (Dragon dragon : collection) {
            String temp1 = dragon.getType() == null ? "null" : dragon.getType().name();
            String temp2 = dragon.getHead() == null ? "null" : String.valueOf(dragon.getHead().getToothCount());
            output += "|" + dragon.getId() + String.valueOf(" ").repeat(stringSizes[0] - dragon.getId().toString().length()) + " |" +
                    dragon.getName() + String.valueOf(" ").repeat(stringSizes[1] - dragon.getName().length()) + " |" +
                    dragon.getCoordinates().getX() + String.valueOf(" ").repeat(stringSizes[2] - dragon.getCoordinates().getX().toString().length()) + " |" +
                    dragon.getCoordinates().getY() + String.valueOf(" ").repeat(stringSizes[3] - Float.valueOf(dragon.getCoordinates().getY()).toString().length()) + " |" +
                    dragon.getCreationDate() + String.valueOf(" ").repeat(stringSizes[4] - dragon.getCreationDate().toString().length()) + " |" +
                    dragon.getAge() + String.valueOf(" ").repeat(stringSizes[5] - dragon.getAge().toString().length()) + " |" +
                    dragon.isSpeaking() + String.valueOf(" ").repeat(stringSizes[6] - Boolean.valueOf(dragon.isSpeaking()).toString().length()) + " |" +
                    dragon.getColor().name() + String.valueOf(" ").repeat(stringSizes[7] - dragon.getColor().name().length()) + " |" +
                    temp1 + String.valueOf(" ").repeat(stringSizes[8] - temp1.length()) + " |" +
                    temp2 + String.valueOf(" ").repeat(stringSizes[9] - temp2.length()) + " |" + "\n";
        }
        output += String.valueOf("-").repeat(Arrays.stream(stringSizes).sum() + 21) + "\n";
        return output;
    }
}
