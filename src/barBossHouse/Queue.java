package barBossHouse;

public interface Queue {


    int getSize();
    Order getValueOrder(int index);
    boolean add(Order order);
    boolean remove(int index);
    Order[] getArrayOrder();

}
