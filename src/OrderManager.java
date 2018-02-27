public class OrderManager {

    static Order[] OrdersOfTable;

    OrderManager(int InputNumberOfTable) {
        Order[] OrdersOfTable = new Order[InputNumberOfTable];

        int NumberOfTable = InputNumberOfTable;
    }

    public static void addOrderToTable(int NumberOfTable, Order AddlyOrder) {
        OrdersOfTable[NumberOfTable - 1] = AddlyOrder;
    }

    public static void addDishToTableOrder(int NumberOfTable, Dish AddlyDish) {
        OrdersOfTable[NumberOfTable - 1].addToOrder(AddlyDish);
    }

    public static void clearTableOrder(int NumberOfTable) {
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

    public static int getNumberDishs(String nameOfDish) {
        int NumberOfDish = 0;
        for (int i = 0; i < OrdersOfTable.length; i++) {
            NumberOfDish += OrdersOfTable[i].numberDishsOfOrder(nameOfDish);
        }

        return NumberOfDish;
    }
}
