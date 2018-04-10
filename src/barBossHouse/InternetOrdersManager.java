package barBossHouse;

public class InternetOrdersManager {

    private Queue queue;


    public InternetOrdersManager()
    {
        queue=new ListNode();
    }

    public InternetOrdersManager(Order[] arr)
    {
        for ( Order a:arr
             ) {
            queue.add(a);

        }
    }

    public boolean add(Order order)
    {
        queue.add(order);
        return true;
    }

    public Order getFirstOrder()
    {
        return queue.getValueOrder(0);
    }

    public Order getFirstOrderAndDelete()
    {
        Order order = getFirstOrder();
        queue.remove(0);

        return order;
    }

    public int getSizeQueue()
    {
        return queue.getSize();
    }

    public Order[] getArrayQueue()
    {
        queue.getArrayOrder();
    }




}
