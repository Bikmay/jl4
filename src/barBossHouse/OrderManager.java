package barBossHouse;

import java.util.function.Predicate;

public class OrderManager {
    //todo ИМЕНОВАНИЕ МАТЬ ЕГО СУКА БЛЯТЬ ГРОБ ГРОБ КЛАДБИЩЕ ПИДР
    //todo зачем static?
    private TableOrder[] ordersOfTable;

    //todo такие же приемы с конструкторами как и в остальных классах
    //todo и их вроде не хватает)
    //Чекни задание
    public OrderManager(int InputNumberOfTable) {
        TableOrder[] OrdersOfTable = new TableOrder[InputNumberOfTable];

        int numberOfTable = InputNumberOfTable;
    }


    public void addOrder(int numberTable, TableOrder addlyOrder) {
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



    //todo ты перепишешь этот метод на использование предиката, как только доделаешь всё до конца)
    //do
    public TableOrder[] findFreeTables() {

        Predicate<TableOrder> predicate = (e) -> e==null;

        return getTables(predicate);
    }

    public TableOrder[] findBusyTables() {

        Predicate<TableOrder> predicate = (e) -> e != null;

        return getTables(predicate);
    }

    //todo так может здесь надо только ордера вернуть, а не массив ордеров с дырками?)
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
            allCost += item.totalCost();
        }
        return allCost;

    }

    //todo чот я не уверен, что этот метод прям по заданию сделан
    //todo но могу ошибаться, а открывать задание лень))
    //вроде так
    //do
    public int getCountDish(String nameOfDish) {
        int count = 0;
        for (int i = 0; i < ordersOfTable.length; i++) {
            count += ordersOfTable[i].getDishesCount(nameOfDish);
        }
        return count;
    }

    //todo у тебя здесь не хватает методов из задания)
}
