package barBossHouse;

public interface Queue {

    boolean add(Object obj);

    Order getValueOrder(int index);
    boolean add(Order order);

}
