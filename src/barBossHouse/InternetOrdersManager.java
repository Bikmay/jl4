package barBossHouse;

import java.time.LocalDate;
import java.time.LocalDateTime;
//TODO: как так получилось, что этот класс is never used?
public class InternetOrdersManager implements OrdersManager {

    private Queue queue;
    //TODO: а это поле is never assigned
    //do
    private LocalDateTime dateTime;


    public InternetOrdersManager() {
        queue = new ListNode<Order>();
        dateTime = LocalDateTime.now();
    }

    public InternetOrdersManager(Order[] arr) {
        for (Order a : arr
                ) {
            queue.add(a);

        }
        dateTime = LocalDateTime.now();
    }

    public boolean add(Order order) throws AlreadyAddedException {

        LocalDateTime now = LocalDateTime.now();
        if (now.getHour() > 22 | now.getHour() > 0 && now.getHour() < 8)
            throw new UnlawfulActionException("Time of sale of alcohol left");

        for (int i = 0; i < queue.getSize(); i++) {
            if (((Order) queue.get(i)).getCustomer().equals(order.getCustomer()) & ((Order) queue.get(i)).getLocalDate().equals(order.getLocalDate()))
                //TODO: вот тут ты по идее должен передать сообщение, что уже что-то добавлено, а не просто выбросить исключение
                //TODO: и так во всех случаях со всеми исключениями :)
                throw new AlreadyAddedException("The order has already been added");
        }

        queue.add(order);
        return true;
    }

    public Order getFirstOrder() {
        return (Order) queue.get(0);
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
            count += ((Order) queue.get(i)).getItemQuantity(itemName);


        }
        return count;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int count = 0;
        for (int i = 0; i < queue.getSize(); i++) {
            count += ((Order) queue.get(i)).getItemQuantity(item);
        }
        return count;
    }

    @Override
    public Order[] getOrders() {
        Object[] mass = queue.getArray();
        Order[] arr = new Order[queue.getSize()];

        for (int i = 0; i < mass.length; i++) {
            arr[i] = (Order) mass[i];
        }
        return arr;
    }

    @Override
    public int ordersCostSummary() {
        Order[] orders = this.getOrders();
        int cost = 0;

        for (int i = 0; i < queue.getSize(); i++) {

            cost += ((Order) queue.get(i)).costTotal();

        }
        return cost;
    }

    @Override
    public int ordersQuantity() {
        return queue.getSize();
    }

    @Override
    public int getQuantityOrderOfDay(LocalDate date) {
        int count = 0;
        for (int i = 0; i < queue.getSize(); i++) {
            if (((Order) queue.get(i)).getLocalDate().equals(dateTime)) ;
            count++;
        }
        return count;

    }

    @Override
    public Queue getListOrdersOfDay(LocalDate date) {
        Queue list = new ListNode<Order>();
        for (int i = 0; i < queue.getSize(); i++) {
            if (((Order) queue.get(i)).getLocalDate().equals(dateTime)) ;
            list.add(queue.get(i));
        }
        return list;


    }

    @Override
    public Queue getCustomerListOrders(Customer customer) {
        Queue list = new ListNode<Order>();
        for (int i = 0; i < queue.getSize(); i++) {
            if (((Order) queue.get(i)).getCustomer().equals(customer)) ;
            list.add(queue.get(i));
        }
        return list;
    }
}
