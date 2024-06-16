package server.collectionManager;

import common.dragon.Color;
import common.dragon.Dragon;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class CollectionManager {
    private PriorityQueue<Dragon> collection;
    private Date creationDate;

    public CollectionManager(){
        collection = new PriorityQueue<Dragon>();
        creationDate = new Date();
    }
    public void add(Dragon dragon){
        collection.add(dragon);
    }
    public void updateById(Long id, Dragon dragon, Integer userId){
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
            temp.setAuthorId(userId);
        }

    }
    public PriorityQueue<Dragon> getCollection(){
        return collection;
    }
    public boolean removeById(Long id,Integer userId){
        Iterator<Dragon> iter = collection.iterator();
        Dragon temp = null;
        while(iter.hasNext()) {
            temp = iter.next();
            if (temp.getId().equals(id) && temp.getAuthorId().equals(userId)) {
                collection.remove(temp);
                return true;
            }
        }
        return false;
    }
    public void clear(Integer userId){
        PriorityQueue<Dragon> temp = new PriorityQueue<>();

        // Перебираем все элементы в оригинальной очереди
        while (!collection.isEmpty()) {
            Dragon element = collection.poll();
            if (!element.getAuthorId().equals(userId)) {
                temp.add(element);
            }
        }

        collection.clear();
        collection.addAll(temp);
    }
    public Dragon head(){
        return collection.peek();
    }
    public Dragon removeHead(Integer userId){
        PriorityQueue<Dragon> temp = new PriorityQueue<>();

        // Перебираем все элементы в оригинальной очереди
        while (!collection.isEmpty()) {
            Dragon element = collection.poll();
            if (!element.getAuthorId().equals(userId)) {
                temp.add(element);
            }
            else{
                collection.addAll(temp);
                return element;
            }
        }

        collection.addAll(temp);
        return null;


    }
    public ArrayList<Dragon> filterByColor(Color color){
        ArrayList<Dragon> viv = (ArrayList<Dragon>) collection.stream().filter(n -> n.getColor().equals(color)).collect(Collectors.toList());
        return viv;
    }
    public ArrayList<Dragon> filterContainsName(String name){
        ArrayList<Dragon> viv = (ArrayList<Dragon>) collection.stream().filter(n -> n.getName().contains(name)).collect(Collectors.toList());
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
