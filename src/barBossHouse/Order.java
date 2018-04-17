package barBossHouse;

public interface Order {

    boolean addDish(MenuItem item);

    String[] getItemsNames();

    int getItemQuantity(String string);

    int getItemQuantity(MenuItem item);

    MenuItem[] getItems();

    boolean remove(String itemName);

    boolean remove(MenuItem item);

    int removeAll(String itemName);

    int removeAll(MenuItem item);

    MenuItem[] sortedItemsByCostDesc();

    double costTotal();

    //gbl
    Customer getCustomer();

    void setCustomer(Customer customer);

    String toString();

    boolean equals(Object obj);

    int hashCode();


}
