import dragon.*;

import java.util.Arrays;
import java.util.Date;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args){
        Dragon a = new Dragon("Гоша",new Coordinates((long)0,0),(long)15,true, Color.GREEN, DragonType.WATER,new DragonHead((double)15));
        Dragon b = new Dragon("Гоша",new Coordinates((long)0,0),(long)15,true, Color.GREEN, DragonType.WATER,new DragonHead((double)15));
        Dragon c = new Dragon("Гоша",new Coordinates((long)0,0),(long)15,true, Color.GREEN, DragonType.WATER,new DragonHead((double)15));
        Dragon d = new Dragon("Гоша",new Coordinates((long)0,0),(long)15,true, Color.GREEN, DragonType.WATER,new DragonHead((double)15));
        System.out.println(c.getId() + d.getId());


    }
}
