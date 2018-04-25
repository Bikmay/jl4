package barBossHouse;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class InternetOrdersManager  implements OrdersManager{

    private Queue queue;
    private LocalDateTime dateTime;


    public InternetOrdersManager() {
        queue = new ListNode<Order>();
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




    @Override
    public int itemsQuantity(String itemName) {
        int count = 0;
        for (int i = 0; i < queue.getSize(); i++) {
            count += ((Order)queue.get(i)).getItemQuantity(itemName);


        }
        return count;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int count = 0;
        for (int i = 0; i < queue.getSize(); i++) {
            count += ((Order)queue.get(i)).getItemQuantity(item);
        }
        return count;
    }

    @Override
    public Order[] getOrders() {
        Object[] mass = queue.getArray();
        Order[] arr=new Order[queue.getSize()];

        for (int i = 0; i <mass.length ; i++) {
            arr[i]=(Order)mass[i];
        }
        return arr;
    }

    @Override
    public int ordersCostSummary() {
        Order[] orders = this.getOrders();
        int cost = 0;

        for (int i = 0; i < queue.getSize(); i++) {

            cost += ((Order)queue.get(i)).costTotal();

        }
        return cost;
    }

    @Override
    public int ordersQuantity() {
        return queue.getSize();
    }

    @Override
    public int getQuantityOrderOfDay(LocalDate date) {
        int count=0;
        for (int i = 0; i <queue.getSize() ; i++) {
            if(((Order)queue.get(i)).getLocalDate().equals(dateTime));
                count++;
        }
        return count;

    }

    @Override
    public Queue getListOrdersOfDay(LocalDate date) {
        Queue list = new ListNode<Order>();
        for (int i = 0; i <queue.getSize() ; i++) {
            if(((Order)queue.get(i)).getLocalDate().equals(dateTime));
                    list.add(queue.get(i));
        }
        return list;


    }

    @Override
    public Queue getCustomerListOrders(Customer customer) {
        Queue list = new ListNode<Order>();
        for (int i = 0; i <queue.getSize() ; i++) {
            if(((Order)queue.get(i)).getCustomer().equals(customer));
                list.add(queue.get(i));
        }
        return list;
    }
}
