package barBossHouse;

import java.util.function.Predicate;

public class OrderManager {
    //todo ИМЕНОВАНИЕ МАТЬ ЕГО СУКА БЛЯТЬ ГРОБ ГРОБ КЛАДБИЩЕ ПИДР
    //todo зачем static?
   Order[] ordersOfTable;

    //todo такие же приемы с конструкторами как и в остальных классах
    //todo и их вроде не хватает)
    //Чекни задание
    OrderManager(int InputNumberOfTable) {
        Order[] OrdersOfTable = new Order[InputNumberOfTable];

        int NumberOfTable = InputNumberOfTable;
    }


    public void addOrder(int numberTable, Order addlyOrder) {
        if(ordersOfTable.length<=numberTable)
        {
            ordersOfTable[numberTable]=addlyOrder;

        }
        else
        {
            Order[] newMass= new Order[ordersOfTable.length*2];
            System.arraycopy(ordersOfTable,0,newMass,0,ordersOfTable.length);
            newMass[ordersOfTable.length]=addlyOrder;
            ordersOfTable=newMass;

        }
    }



    public void addDishToTableOrder(int NumberOfTable,int index, Dish dish) {
        ordersOfTable[NumberOfTable - 1].addToOrder(dish,index);
    }

    public void clearTableOrder(int NumberOfTable) {
        ordersOfTable[NumberOfTable - 1] = null;
    }

    public int findFreeTable() {
        for (int i = 0; i <ordersOfTable.length; i++) {
            if (ordersOfTable[i] == null) {
                return i++;
            }
        }
        return 0;
    }
    //todo ты перепишешь этот метод на использование предиката, как только доделаешь всё до конца)
    //do
    public Order[] findFreeTables() {

        Predicate<Order> predicate = (e)-> e.equals(null);

        return getTabels(predicate);
    }

    //todo так может здесь надо только ордера вернуть, а не массив ордеров с дырками?)
    //do
    public  Order[] getAllOrders() {

        for (int j = 0; j < ordersOfTable.length; j++) {
                if (ordersOfTable[j] == null) {
                    ordersOfTable[j] = ordersOfTable[j+1];
                    j++;
                }
            }


        return ordersOfTable;
    }
    public Order[] getTabels(Predicate<Order> predicate)
    {
        int i=0;
        Order[] orders = new Order[ordersOfTable.length];
        for (int j = 0; j < ordersOfTable.length; j++) {
            if (predicate.test(ordersOfTable[j])) {
                orders[i]=ordersOfTable[j];
            }
        }


        return orders;
    }




    public double getCostAllOrder() {
        double allCost = 0;
        for (Order exempalOrder : ordersOfTable) {
            allCost += exempalOrder.orderCost();
        }
        return allCost;

    }

    //todo чот я не уверен, что этот метод прям по заданию сделан
    //todo но могу ошибаться, а открывать задание лень))
    //вроде так
    //do
    public  int getCountDish(String nameOfDish) {
        int count = 0;
        for (int i = 0; i < ordersOfTable.length; i++) {
            count += ordersOfTable[i].getCountDish(nameOfDish);
        }
        return count;
    }

    //todo у тебя здесь не хватает методов из задания)
}
