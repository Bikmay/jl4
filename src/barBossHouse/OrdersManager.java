package barBossHouse;

import java.time.LocalDate;

public interface OrdersManager {

    int itemsQuantity(String itemName);
    int itemsQuantity(MenuItem item);

    Order[] getOrders();
    int ordersCostSummary();
    int ordersQuantity();

    int getQuantityOrderOfDay(LocalDate date);
    Queue getListOrdersOfDay(LocalDate date);
    Queue getCustomerListOrders(Customer customer);

}
