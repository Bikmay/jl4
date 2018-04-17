package barBossHouse;

public interface Queue {


    int getSize();

    Object get(int index);
    void add(Object order);

    boolean remove(int index);

    Object[] getArray();

}
