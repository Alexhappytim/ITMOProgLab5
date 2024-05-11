package common.dragon;

import java.io.Serializable;

public class Coordinates implements Serializable {

    private static final long serialVersionUID = 5612794112023L;
    private Long x; //Максимальное значение поля: 41, Поле не может быть null
    private float y; //Значение поля должно быть больше -49
    public Coordinates(Long x, float y){
        setX(x);
        setY(y);
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }
}
