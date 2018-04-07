package barBossHouse;

import java.util.function.Predicate;

public class TablesOrderManager {

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

        Predicate<TableOrder> predicate = (e) -> e==null;

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


    public double getCostAllOrder() {
        double allCost = 0;
        for (TableOrder item : ordersOfTable) {
            allCost += item.costTotal();
        }
        return allCost;

    }


    public int getCountDish(String nameOfDish) {
        int count = 0;
        for (int i = 0; i < ordersOfTable.length; i++) {
            count += ordersOfTable[i].getItemQuantity(nameOfDish);
        }
        return count;
    }

    public int getCountMenuItem(MenuItem item)
    {
        int count=0;
        TableOrder[] arr=findBusyTables();
        for (TableOrder order:arr
             ) {
            count+=order.getItemQuantity(item);

        }
        return count;
    }


    public int getCountOrders()
    {
        return findBusyTables().length;
    }
}
