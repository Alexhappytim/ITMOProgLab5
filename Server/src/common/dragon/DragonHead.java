package common.dragon;

import java.io.Serializable;

public class DragonHead implements Serializable {
    private static final long serialVersionUID = 911241242347L;
    private Double toothCount; //Поле не может быть null
    public DragonHead(Double toothCount){
        setToothCount(toothCount);
    }

    public Double getToothCount() {
        return toothCount;
    }

    public void setToothCount(Double toothCount) {
        this.toothCount = toothCount;
    }
}
