import ConsoleManager.commands.ShowCommand;
import dragon.*;
import execution.ExecutionManager;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ExecutionManager.start(args[0]);
        ShowCommand c = new ShowCommand();
        c.execute();
        //ExecutionManager.collectionManager.add(new Dragon("Гоша",new Coordinates((long)0,0),(long)15,true, Color.GREEN, DragonType.WATER,new DragonHead((double)15)));
        //ExecutionManager.collectionManager.add(new Dragon("Гошаaaaaa",new Coordinates((long)10,10),(long)150,false, Color.BLUE, DragonType.AIR,new DragonHead((double)150)));

//        System.out.println(ExecutionManager.dumpManager.initialReadFromFile(args[0]));
//        ExecutionManager.commandManager.show();
//        System.out.println(ExecutionManager.consoleManager.inputNewElement());
    }
}
