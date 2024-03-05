package collectionManager;

import dragon.*;

import java.util.Iterator;
import java.util.PriorityQueue;

public class CollectionManager {
    private PriorityQueue<Dragon> collection;
    public CollectionManager(){
        collection = new PriorityQueue<Dragon>();
    }
    public void add(Dragon dragon){
        collection.add(dragon);
    }
    public void updateById(Long id){
        Iterator<Dragon> iter = collection.iterator();
        Dragon temp;
        while(iter.hasNext()){
            temp = iter.next();
            if(temp.getId().equals(id)){
                break;
            }
        }
        //TODO вызов изменения объекта
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
