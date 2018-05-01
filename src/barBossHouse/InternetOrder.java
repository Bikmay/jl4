package barBossHouse;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class InternetOrder implements Order {

    private LocalDateTime dateTime;
    private int size;
    private ListNode<MenuItem> list;


    private Customer customer;


    public InternetOrder() {
        list = new ListNode();
        this.dateTime= LocalDateTime.now();
    }

    public InternetOrder(int[] positions, Customer customer) {
        this.dateTime= LocalDateTime.now();
    }


    public boolean addDish(MenuItem menuItem) throws UnlawfulActionException {

        LocalDateTime now = LocalDateTime.now();
        if (menuItem.getClass()==new Drink().getClass())
            if(now.getHour()>22 && now.getHour()<8 && now.getHour()>0)
                throw new UnlawfulActionException();

        list.add(menuItem);
        size++;
        return true;

    }

    public boolean remove(String deleteDish) {
        for (int i = 0; i < list.size; i++) {

            if (deleteDish.equals(((Order)list.get(i)))) {
                size--;
                return list.remove(i);


            }
        }
        return false;


    }

    public boolean remove(MenuItem item) {
        for (int i = 0; i < list.size; i++) {

            if (item.equals(list.get(i))) {
                size--;
                return list.remove(i);

            }
        }
        return false;


    }

    public int removeAll(String deleteDish) {
        int count = 0;
        for (int i = 0; i < list.size; i++) {

            if (deleteDish.equals((((MenuItem)list.get(i)).getName()))) {
                list.remove(i);
                count++;

            }
        }
        return count;


    }

    public int removeAll(MenuItem item) {
        int count = 0;
        for (int i = 0; i < list.size; i++) {

            if (item.equals(list.get(i))) {
                list.remove(i);
                count++;
            }
        }
        return count;


    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] arr = new MenuItem[list.size];

        list = ListNode.sort(list, 0, -1);

        for (int i = 0; i < list.size; i++) {
            arr[i] = (MenuItem)list.get(i);
        }
        return arr;
    }

    public int getQuantity() {
        return size;
    }//без дырок

    public double costTotal() {
        int cost = 0;
        for (int i = 0; i < list.size; i++) {
            cost += ((MenuItem)list.get(i)).getCost();

        }
        return cost;
    }

    public MenuItem[] getItems() {
        MenuItem[] arr = new MenuItem[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (MenuItem)list.get(i);
        }
        return arr;
    }

    public int getItemQuantity(String findDish) {
        int count = 0;
        for (int i = 0; i < list.size; i++) {

            if (findDish.equals(((MenuItem)list.get(i)).getName())) {

                count++;

            }
        }
        return count;


    }

    public int getItemQuantity(MenuItem item) {
        int count = 0;
        for (int i = 0; i < list.size; i++) {

            if (item.equals(list.get(i))) {

                count++;
            }
        }
        return count;


    }

    public String[] getItemsNames() {
        String[] resArr = new String[list.size];

        for (int i = 0; i < list.size; i++) {
            resArr[i] = ((MenuItem)list.get(i)).getName();
        }
        return resArr;
    }


    public Customer getCustomer() {
        return customer;
    }



    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder =new StringBuilder();

        stringBuilder.append("InternetOdrder:").append("\n").append(customer.toString()).append("\n").append(size).append("\n");


        for (int i = 0; i < size; i++) {
            stringBuilder.append(list.get(i).toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {

        InternetOrder order = (InternetOrder) obj;
        if (obj.getClass() == this.getClass()) {
            if (order.customer.equals(this.customer) && this.size == order.size && order.equals(this.list) && order.dateTime.equals(this.dateTime)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return size ^ customer.hashCode() ^ list.hashCode() ^ list.hashCode();
    }

    @Override
    public LocalDateTime getLocalDate() {
        return dateTime;
    }


}
