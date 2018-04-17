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
        return queue.getValueOrder(0);
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
        return queue.getArrayOrder();

    }

    public int getOrderCost() {
        Order[] orders = queue.getArrayOrders();
        int cost = 0;

        for (int i = 0; i < queue.getSize(); i++) {

            cost += queue.getValueOrder(i).costTotal();

        }
        return cost;
    }

    public int getQualityOrder(String name) {
        int count = 0;
        for (int i = 0; i < queue.getSize(); i++) {
            count += queue.getValueOrder(i).getItemQuantity(name);


        }
        return count;

    }

    public int getQualityOrder(MenuItem item) {
        int count = 0;
        for (int i = 0; i < queue.getSize(); i++) {
            count += queue.getValueOrder(i).getItemQuantity(item);
        }
        return count;
    }


}
