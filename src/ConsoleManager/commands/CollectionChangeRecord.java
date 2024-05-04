package ConsoleManager.commands;

import dragon.Dragon;

public class CollectionChangeRecord {
    private Flags flag;
    private Dragon change;

    public Flags getFlag() {
        return flag;
    }
    public CollectionChangeRecord(Flags f, Dragon dragon){
        setFlag(f);
        setChange(dragon.clone());
    }
    public void setFlag(Flags flag) {
        this.flag = flag;
    }

    public Dragon getChange() {
        return change;
    }

    public void setChange(Dragon change) {
        this.change = change;
    }

    public enum Flags{
        ADD,
        UPDATE,
        REMOVE,
        CLEAR
    }

}
