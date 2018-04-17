package barBossHouse;

public class InternetOrdersManager {

    private Queue queue;


    public InternetOrdersManager() {
        queue = new ListNode();
    }

    public InternetOrdersManager(Order[] arr) {
        for (Order a : arr
                ) {
            queue.add(a);

        }
    }

    public boolean add(Order order) {
        queue.add(order);
        return true;
    }

    public Order getFirstOrder() {
        return (Order)queue.get(0);
    }

    public Order getFirstOrderAndDelete() {
        Order order = getFirstOrder();
        queue.remove(0);

        return order;
    }

    public int getSizeQueue() {
        return queue.getSize();
    }

    public Order[] getArrayQueue() {
        Object[] mass = queue.getArray();
        Order[] arr=new Order[queue.getSize()];

        for (int i = 0; i <mass.length ; i++) {
            arr[i]=(Order)mass[i];
        }
        return arr;

    }

    public int getOrderCost() {
        Order[] orders = this.getArrayQueue();
        int cost = 0;

        for (int i = 0; i < queue.getSize(); i++) {

            cost += ((Order)queue.get(i)).costTotal();

        }
        return cost;
    }

    public int getQualityOrder(String name) {
        int count = 0;
        for (int i = 0; i < queue.getSize(); i++) {
            count += ((Order)queue.get(i)).getItemQuantity(name);


        }
        return count;

    }

    public int getQualityOrder(MenuItem item) {
        int count = 0;
        for (int i = 0; i < queue.getSize(); i++) {
            count += ((Order)queue.get(i)).getItemQuantity(item);
        }
        return count;
    }


}
