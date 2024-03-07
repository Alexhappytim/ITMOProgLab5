package dragon;

import java.util.Date;

public class DragonWrapper {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long age; //Значение поля должно быть больше 0, Поле может быть null
    private boolean speaking;
    private Color color; //Поле не может быть null
    private DragonType type; //Поле может быть null
    private DragonHead head;

    public DragonWrapper(Long id, String name, Coordinates coordinates, java.util.Date creationDate, Long age, boolean speaking, Color color, DragonType type, DragonHead head) {
        setId(id);
        setName(name);
        setCoordinates(coordinates);
        setCreationDate(creationDate);
        setAge(age);
        setSpeaking(speaking);
        setColor(color);
        setType(type);
        setHead(head);
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
}
