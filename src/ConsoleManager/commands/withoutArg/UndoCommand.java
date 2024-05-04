package ConsoleManager.commands.withoutArg;

import ConsoleManager.commands.CollectionChangeRecord;
import dragon.Dragon;
import execution.ExecutionManager;

import java.util.Scanner;
import java.util.Stack;

public class UndoCommand implements Command{
    private Stack<CollectionChangeRecord> changes = new Stack<>();
    @Override
    public void execute() {
        if(changes.empty()){
            ExecutionManager.consoleManager.println("Нечего отменять!");
        }
        else{
            CollectionChangeRecord change = changes.pop();
            switch (change.getFlag()){
                case ADD -> {
                    ExecutionManager.collectionManager.removeById(change.getChange().getId(),true);
                }
                case UPDATE -> {
                    ExecutionManager.collectionManager.updateById(change.getChange().getId(), change.getChange(),true);
                }
                case REMOVE -> {
                    ExecutionManager.collectionManager.add(change.getChange(),true);
                }
                case CLEAR -> {
                    ExecutionManager.collectionManager.add(change.getChange(),true);
                    if(!changes.empty()){
                    execute();}
                }
                default -> {}
            }
        }
    }

    @Override
    public void executeFromScript(Scanner scanner) {
        execute();
    }
    public void addChange(CollectionChangeRecord change){
        changes.push(change);
        System.out.println(change.getChange());
    }
}
