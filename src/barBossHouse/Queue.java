package barBossHouse;

public class Queue {

    int count=0;
    Order value;
    Queue next;
    Queue prev;


    public boolean add(Order order)
    {
        next=new Queue();
        next.value=order;
        next.prev=this;
        count++;
        return true;
    }
}
