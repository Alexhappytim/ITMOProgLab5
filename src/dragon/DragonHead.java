package dragon;

public class DragonHead {
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
