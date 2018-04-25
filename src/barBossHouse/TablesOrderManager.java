package barBossHouse;

import java.time.LocalDate;
import java.util.function.Predicate;

public class TablesOrderManager implements OrdersManager {

    private TableOrder[] ordersOfTable;


    //Чекни задание
    public TablesOrderManager(int InputNumberOfTable) {
        TableOrder[] OrdersOfTable = new TableOrder[InputNumberOfTable];

        int numberOfTable = InputNumberOfTable;
    }


    public void add(int numberTable, TableOrder addlyOrder) {
        if (ordersOfTable.length <= numberTable) {
            ordersOfTable[numberTable] = addlyOrder;

        } else {
//            TableOrder[] newMass = new TableOrder[ordersOfTable.length * 2];
//            System.arraycopy(ordersOfTable, 0, newMass, 0, ordersOfTable.length);
//            newMass[ordersOfTable.length] = addlyOrder;
//            ordersOfTable = newMass;

        }
    }


    public void addDishToTableOrder(int NumberOfTable, int index, MenuItem menuItem) {
        ordersOfTable[NumberOfTable - 1].addDish(menuItem);
    }

    public void clearTableOrder(int NumberOfTable) {
        ordersOfTable[NumberOfTable - 1] = null;
    }


    //do
    public TableOrder[] findFreeTables() {

        Predicate<TableOrder> predicate = (e) -> e == null;

        return getTables(predicate);
    }

    public TableOrder[] findBusyTables() {

        Predicate<TableOrder> predicate = (e) -> e != null;

        return getTables(predicate);
    }


    //do
    public TableOrder[] getAllOrders() {

        return ordersOfTable;
    }

    private TableOrder[] getTables(Predicate<TableOrder> predicate) {
        int i = 0;
        TableOrder[] orders = new TableOrder[ordersOfTable.length];
        for (int j = 0; j < ordersOfTable.length; j++) {
            if (predicate.test(ordersOfTable[j])) {
                orders[i] = ordersOfTable[j];
            }
        }


        return orders;
    }



    public Order getOrder(int index) {
        return ordersOfTable[index];
    }

    public int getCountOrders() {
        return findBusyTables().length;
    }

    public int removeAll(TableOrder order) {
        int count = 0;
        for (int i = 0; i < ordersOfTable.length; i++) {

            if (ordersOfTable[i].equals(order)) {
                ordersOfTable[i] = null;
                count++;
                System.arraycopy(ordersOfTable, i + 1, ordersOfTable, i, ordersOfTable.length - i);
            }
        }
        if (count > 0)
            return count;
        else
            return -1;

    }

    public int remove(TableOrder order) {
        int count = 0;
        for (int i = 0; i < ordersOfTable.length; i++) {

            if (ordersOfTable[i].equals(order)) {
                ordersOfTable[i] = null;
                count++;
                System.arraycopy(ordersOfTable, i + 1, ordersOfTable, i, ordersOfTable.length - i);
                return i;
            }
        }
        return -1;
    }

    public void remove(int index) {
        System.arraycopy(ordersOfTable, index + 1, ordersOfTable, index, ordersOfTable.length - index);
        ordersOfTable[ordersOfTable.length] = null;
    }

    @Override
    public int itemsQuantity(String itemName) {
        int count = 0;
        for (int i = 0; i < ordersOfTable.length; i++) {
            count += ordersOfTable[i].getItemQuantity(itemName);
        }
        return count;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int count = 0;
        TableOrder[] arr = findBusyTables();
        for (TableOrder order : arr
                ) {
            count += order.getItemQuantity(item);

        }
        return count;
    }

    @Override
    public Order[] getOrders() {
        return new Order[0];
    }

    @Override
    public int ordersCostSummary() {
        double allCost = 0;
        for (TableOrder item : ordersOfTable) {
            allCost += item.costTotal();
        }
        return (int)allCost;
    }

    @Override
    public int ordersQuantity() {
        return findBusyTables().length;
    }

    @Override
    public int getQuantityOrderOfDay(LocalDate date) {
        int count=0;
        for (int i = 0; i <ordersOfTable.length ; i++) {
            if((ordersOfTable[i]).getLocalDate().equals(date));
            count++;
        }
        return count;
    }

    @Override
    public Queue getListOrdersOfDay(LocalDate date) {
        Queue list = new ListNode<Order>();
        for (int i = 0; i <ordersOfTable.length ; i++) {
            if((ordersOfTable[i]).getLocalDate().equals(date));
            list.add(ordersOfTable[i]);
        }
        return list;

    }

    @Override
    public Queue getCustomerListOrders(Customer customer) {
        Queue list = new ListNode<Order>();
        for (int i = 0; i <ordersOfTable.length; i++) {
            if((ordersOfTable[i]).getCustomer().equals(customer));
            list.add(ordersOfTable[i]);
        }
        return list;
    }
}
