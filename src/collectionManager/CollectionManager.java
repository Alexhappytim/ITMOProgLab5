package collectionManager;

import ConsoleManager.commands.CollectionChangeRecord;
import ConsoleManager.commands.withoutArg.UndoCommand;
import dragon.*;
import execution.ExecutionManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.PriorityQueue;

import static ConsoleManager.commands.CollectionChangeRecord.Flags.*;

public class CollectionManager {
    private PriorityQueue<Dragon> collection;
    private java.util.Date creationDate;
    public CollectionManager(){
        collection = new PriorityQueue<Dragon>();
        creationDate = new Date();
    }
    public void add(Dragon dragon,boolean undo){
        if(!undo) {
            ((UndoCommand) ExecutionManager.commandManager.getUndoCommand()).addChange(new CollectionChangeRecord(ADD, dragon));
        }
        collection.add(dragon);

    }
    public void updateById(Long id, Dragon dragon,boolean undo){
        Iterator<Dragon> iter = collection.iterator();
        Dragon temp = null;
        while(iter.hasNext()) {
            temp = iter.next();
            if (temp.getId().equals(id)){
                break;
            }else{temp = null;}
        }
        if(temp != null){
            if(!undo) {
                ((UndoCommand) ExecutionManager.commandManager.getUndoCommand()).addChange(new CollectionChangeRecord(UPDATE, temp));
            }
            temp.setName(dragon.getName());
            temp.setCoordinates(dragon.getCoordinates());
            temp.setCreationDate(dragon.getCreationDate());
            temp.setAge(dragon.getAge());
            temp.setSpeaking(dragon.isSpeaking());
            temp.setColor(dragon.getColor());
            temp.setType(dragon.getType());
            temp.setHead(dragon.getHead());
        }

    }
    public PriorityQueue<Dragon> getCollection(){
        return collection;
    }
    public void removeById(Long id,boolean undo){
        Iterator<Dragon> iter = collection.iterator();
        Dragon temp = null;
        while(iter.hasNext()) {
            temp = iter.next();
            if (temp.getId().equals(id)) {
                break;
            }
        }
        if(temp!=null){
            if(!undo) {
                ((UndoCommand) ExecutionManager.commandManager.getUndoCommand()).addChange(new CollectionChangeRecord(REMOVE, temp));
            }
            collection.remove(temp);
        }
    }
    public void clear(){
        Iterator<Dragon> iter = collection.iterator();
        Dragon temp = null;
        while(iter.hasNext()) {
            temp = iter.next();
            ((UndoCommand) ExecutionManager.commandManager.getUndoCommand()).addChange(new CollectionChangeRecord(CLEAR,temp));
        }
        collection.clear();
    }
    public Dragon head(){
        return collection.peek();
    }
    public Dragon removeHead(){
        Dragon temp =collection.poll();
        ((UndoCommand) ExecutionManager.commandManager.getUndoCommand()).addChange(new CollectionChangeRecord(REMOVE,temp));
        return temp;
    }
    public void addIfMax(Dragon dragon){
        Iterator<Dragon> iter = collection.iterator();
        Dragon temp = null;
        boolean flag = true;
        while(iter.hasNext()) {
            temp = iter.next();
            if(dragon.getId()<=temp.getId()){
                flag=false;
                break;
            }
        }
        if(flag){
            ((UndoCommand) ExecutionManager.commandManager.getUndoCommand()).addChange(new CollectionChangeRecord(ADD,dragon));
            add(dragon, false);
        }
    }
    public ArrayList<Dragon> filterByColor(Color color){
        Iterator<Dragon> iter = collection.iterator();
        Dragon temp = null;
        ArrayList<Dragon> viv = new ArrayList<>();
        while(iter.hasNext()) {
            temp = iter.next();
            if (temp.getColor().equals(color)) {
                viv.add(temp);
            }
        }
        return viv;
    }
    public ArrayList<Dragon> filterContainsName(String name){
        Iterator<Dragon> iter = collection.iterator();
        Dragon temp = null;
        ArrayList<Dragon> viv = new ArrayList<>();
        while(iter.hasNext()) {
            temp = iter.next();
            if (temp.getName().contains(name)) {
                viv.add(temp);
            }
        }
        return viv;
    }
    public ArrayList<Dragon> filterLessThanSpeaking(boolean speaking){
        Iterator<Dragon> iter = collection.iterator();
        Dragon temp = null;
        ArrayList<Dragon> viv = new ArrayList<>();
        while(iter.hasNext()) {
            temp = iter.next();
            if(speaking && !temp.isSpeaking()){
                viv.add(temp);
            }

        }
        return viv;
    }
    public String info(){
        return "Коллекция типа PriorityQueue\nДата инициализации: "+creationDate+"\nКол-во элементов: "+ collection.size();
    }



}
