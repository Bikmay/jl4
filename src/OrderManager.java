public class OrderManager {
    //todo ИМЕНОВАНИЕ МАТЬ ЕГО СУКА БЛЯТЬ ГРОБ ГРОБ КЛАДБИЩЕ ПИДР
    //todo зачем static?
   Order[] OrdersOfTable;

    //todo такие же приемы с конструкторами как и в остальных классах
    //todo и их вроде не хватает)
    //Чекни задание
    OrderManager(int InputNumberOfTable) {
        Order[] OrdersOfTable = new Order[InputNumberOfTable];

        int NumberOfTable = InputNumberOfTable;
    }


    public void addOrder(int NumberOfTable, Order AddlyOrder) {
        OrdersOfTable[NumberOfTable - 1] = AddlyOrder;
    }


    //TODO переписать
    public void addDishToTableOrder(int NumberOfTable, Dish AddlyDish) {
        OrdersOfTable[NumberOfTable - 1].addToOrder(AddlyDish);
    }

    public void clearTableOrder(int NumberOfTable) {
        OrdersOfTable[NumberOfTable - 1] = null;
    }

    public static int findFreeTable() {
        for (int i = 0; i < OrdersOfTable.length; i++) {
            if (OrdersOfTable[i] == null) {
                return i++;
            }
        }
        return 0;
    }
    //todo ты перепишешь этот метод на использование предиката, как только доделаешь всё до конца)
    public static int[] findFreeTables() {
        int[] massOfindexFreeTables = new int[OrdersOfTable.length];
        int j = 0;
        for (int i = 0; i < OrdersOfTable.length; i++) {
            if (OrdersOfTable[i] == null) {
                massOfindexFreeTables[j] = i;
                j++;
            }
        }
        return massOfindexFreeTables;
    }

    //todo так может здесь надо только ордера вернуть, а не массив ордеров с дырками?)
    public static Order[] getAllOrders() {
        return OrdersOfTable;
    }


    public static double getCostAllOrder() {
        double AllCost = 0;
        for (Order ExempalOrder : OrdersOfTable) {
            AllCost += ExempalOrder.returnCostOfOrder();
        }
        return AllCost;

    }

    //todo чот я не уверен, что этот метод прям по заданию сделан
    //todo но могу ошибаться, а открывать задание лень))
    public static int getNumberDishs(String nameOfDish) {
        int NumberOfDish = 0;
        for (int i = 0; i < OrdersOfTable.length; i++) {
            NumberOfDish += OrdersOfTable[i].numberDishsOfOrder(nameOfDish);
        }
        return NumberOfDish;
    }

    //todo у тебя здесь не хватает методов из задания)
}
