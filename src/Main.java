import collectionManager.CollectionManager;
import dragon.*;

import java.util.Arrays;
import java.util.Date;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args){
        Dragon a = new Dragon("Гоша",new Coordinates((long)0,0),(long)15,true, Color.GREEN, DragonType.WATER,new DragonHead((double)15));
        Dragon b = new Dragon("Гоша",new Coordinates((long)0,0),(long)15,false, Color.GREEN, DragonType.WATER,new DragonHead((double)15));
        Dragon c = new Dragon("Гоша",new Coordinates((long)0,0),(long)15,true, Color.GREEN, DragonType.WATER,new DragonHead((double)15));
        Dragon d = new Dragon("Гоша",new Coordinates((long)0,0),(long)15,false, Color.GREEN, DragonType.WATER,new DragonHead((double)15));
        CollectionManager manager = new CollectionManager();
        manager.add(a);
        manager.add(b);
        manager.add(c);
        manager.add(d);
//        System.out.println(manager.getCollection());
        //manager.updateById(new DragonWrapper((long) 2,"Петя",new Coordinates((long)0,0),new Date(),(long)15,true, Color.GREEN, DragonType.WATER,new DragonHead((double)15)));
//        manager.removeById((long) 2);
//        manager.addIfMax(b);
//        manager.addIfMax(d);
//        System.out.println(manager.getCollection());
//            System.out.println(manager.filterLessThanSpeaking(true));
        System.out.println(manager.info());
    }
}
