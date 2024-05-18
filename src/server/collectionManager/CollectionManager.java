package server.collectionManager;

import common.dragon.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public void updateById(Long id, Dragon dragon){
        Iterator<Dragon> iter = collection.iterator();
        Dragon temp = null;
        while(iter.hasNext()) {
            temp = iter.next();
            if (temp.getId().equals(id)){
                break;
            }else{temp = null;}
        }
        if(temp != null){
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
    public boolean addIfMax(Dragon dragon){
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
        return flag;
    }
    public ArrayList<Dragon> filterByColor(Color color){
//        Iterator<Dragon> iter = collection.iterator();
//        Dragon temp = null;
        ArrayList<Dragon> viv = (ArrayList<Dragon>) collection.stream().filter(n -> n.getColor().equals(color)).collect(Collectors.toList());
//        while(iter.hasNext()) {
//            temp = iter.next();
//            if (temp.getColor().equals(color)) {
//                viv.add(temp);
//            }
//        }
        return viv;
    }
    public ArrayList<Dragon> filterContainsName(String name){
        ArrayList<Dragon> viv = (ArrayList<Dragon>) collection.stream().filter(n -> n.getName().equals(name)).collect(Collectors.toList());

        return viv;
    }
    public ArrayList<Dragon> filterLessThanSpeaking(boolean speaking){
        ArrayList<Dragon> viv = (ArrayList<Dragon>) collection.stream().filter(n -> n.isSpeaking() == speaking).collect(Collectors.toList());

        return viv;
    }
    public String info(){
        return "Коллекция типа PriorityQueue\nДата инициализации: "+creationDate+"\nКол-во элементов: "+ collection.size();
    }



}
