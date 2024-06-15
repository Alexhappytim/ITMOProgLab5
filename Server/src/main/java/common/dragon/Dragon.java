package common.dragon;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashSet;

public class Dragon implements Comparable<Dragon>, Serializable {

    private static final long serialVersionUID = 5720185671098347L;

    static {
        existId = new HashSet<Long>();
    }

    private static HashSet<Long> existId;

    private static Long newId() {
        for (long i = 1; i < 1000000000; i++) {
            if (!existId.contains(i)) {
                existId.add(i);
                return i;
            }
        }
        return (long) -1;
    }

    public static boolean isIdExist(Long id) {
        return existId.contains(id);
    }


    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long age; //Значение поля должно быть больше 0, Поле может быть null
    private boolean speaking;
    private Color color; //Поле не может быть null
    private DragonType type; //Поле может быть null
    private DragonHead head;
    private Integer authorId;

    public Dragon(Long id, String name, Coordinates coordinates, Long age, boolean speaking, Color color, DragonType type, DragonHead head,Integer authorId) {
        this(id, name, coordinates, new Date(), age, speaking, color, type, head, authorId);
    }

    public Dragon(Long id, String name, Coordinates coordinates, java.util.Date creationDate, Long age, boolean speaking, Color color, DragonType type, DragonHead head, Integer authorId) {
        setId(id);
        setName(name);
        setCoordinates(coordinates);
        setCreationDate(creationDate);
        setAge(age);
        setSpeaking(speaking);
        setColor(color);
        setType(type);
        setHead(head);
        setAuthorId(authorId);
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public boolean isSpeaking() {
        return speaking;
    }

    public void setSpeaking(boolean speaking) {
        this.speaking = speaking;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public DragonType getType() {
        return type;
    }

    public void setType(DragonType type) {
        this.type = type;
    }

    public DragonHead getHead() {
        return head;
    }

    public void setHead(DragonHead head) {
        this.head = head;
    }

    @Override
    public int compareTo(Dragon o) {
        return this.id.compareTo(o.getId());
    }

    @Override
    public String toString() {
        return "Dragon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates.getX() + " " + coordinates.getY() +
                ", creationDate=" + DateFormat.getDateInstance().format(creationDate) +
                ", age=" + age +
                ", speaking=" + speaking +
                ", color=" + color +
                ", type=" + type +
                ", head=" + head +
                ", authorId=" + authorId +
                "}";
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }
    public Double getToothCount(){
        if(head == null){
            return null;
        }else{
            return head.getToothCount();
        }
    }
}
