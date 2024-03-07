package collectionManager;

import dragon.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.PriorityQueue;

public class CollectionManager {
    private PriorityQueue<Dragon> collection;
    private java.util.Date creationDate;
    public CollectionManager(){
        collection = new PriorityQueue<Dragon>();
        creationDate = new Date();
    }
    public void add(Dragon dragon){
        collection.add(dragon);
    }
    public void updateById(DragonWrapper dragonWrapper){
        Iterator<Dragon> iter = collection.iterator();
        Dragon temp = null;
        while(iter.hasNext()) {
            temp = iter.next();
            if (temp.getId().equals(dragonWrapper.getId())) {
                break;
            }
        }
        if(temp != null){
            temp.setName(dragonWrapper.getName());
            temp.setCoordinates(dragonWrapper.getCoordinates());
            temp.setCreationDate(dragonWrapper.getCreationDate());
            temp.setAge(dragonWrapper.getAge());
            temp.setSpeaking(dragonWrapper.isSpeaking());
            temp.setColor(dragonWrapper.getColor());
            temp.setType(dragonWrapper.getType());
            temp.setHead(dragonWrapper.getHead());
        }

    }
    public PriorityQueue<Dragon> getCollection(){
        return collection;
    }
    public void removeById(Long id){
        Iterator<Dragon> iter = collection.iterator();
        Dragon temp = null;
        while(iter.hasNext()) {
            temp = iter.next();
            if (temp.getId().equals(id)) {
                break;
            }
        }
        if(temp!=null){
            collection.remove(temp);
        }
    }
    public void clear(){
        collection.clear();
    }
    public Dragon head(){
        return collection.peek();
    }
    public Dragon removeHead(){
        return collection.poll();
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
            add(dragon);
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


    /*private ValidateError validateDragon(boolean isFromFile,Long id, String name, Coordinates coordinates, java.util.Date creationDate, Long age, boolean speaking, Color color, DragonType type, DragonHead head){
        if(id == null){
            return ValidateError.IDISNULL;
        }
        if(Dragon.isIdExist(id)){
            return ValidateError.IDISUSED;
        }
        if(name == null){
            return ValidateError.NAMEISNULL;
        }
        if(coordinates == null){
            return ValidateError.COORDINATESISNULL;
        }
        if(creationDate == null){
            return ValidateError.DATEISNULL;
        }
        if(age == null){
            return ValidateError.AGEISNULL;
        }
        if(color == null){
            return ValidateError.COLORISNULL;
        }
        if(type == null){
            return ValidateError.DRAGONTYPEISNULL;
        }
        if(id<=0 && isFromFile){
            return ValidateError.NEGATIVEID;
        }
        if(name.isEmpty()){
            return ValidateError.NAMEISEMPTY;
        }
        if(age<=0){
            return ValidateError.NEGATIVEAGE;
        }


    }*/
}
