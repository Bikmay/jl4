package barBossHouse;



public class InternetOrder  implements Order{

    private int size;
    private ListNode head;
    private ListNode tail;

    private Customer customer;


    public InternetOrder()
    {
        head=new ListNode();
    }

    public InternetOrder(int[] positions, Customer customer)
    {

    }

    public boolean addDish(MenuItem menuItem) {

        tail=tail.add(menuItem);
        size++;
        return true;

    }

    public boolean remove(String deleteDish) {
        for (int i = 0; i <head.size ; i++) {

            if(deleteDish.equals(head.get(i).getName()))
            {
                size--;
                return head.remove(i);


            }
        }
        return false;


    }

    public boolean remove(MenuItem item) {
        for (int i = 0; i <head.size ; i++) {

            if(item.equals(head.get(i)))
            {
                size--;
                return head.remove(i);

            }
        }
        return false;


    }

    public int removeAll(String deleteDish) {
        int count=0;
        for (int i = 0; i <head.size ; i++) {

            if(deleteDish.equals(head.get(i).getName()))
            {
               head.remove(i);
               count++;

            }
        }
        return count;


    }

    public int removeAll(MenuItem item) {
        int count=0;
        for (int i = 0; i <head.size ; i++) {

            if(item.equals(head.get(i)))
            {
                head.remove(i);
                count++;
            }
        }
        return count;


    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] arr= new MenuItem[head.size];

        head=ListNode.sort(head,)
    }

    public int getQuantity() {
        return size;
    }//без дырок

    public double costTotal()
    {
        int cost=0;
        for (int i = 0; i <head.size ; i++) {
            cost+=head.get(i).getCost();

        }
        return cost;
    }

    public MenuItem[] getItems()
    {
        MenuItem[] arr = new MenuItem[size];
        for (int i = 0; i <size ; i++) {
            arr[i]=head.get(i);
        }
        return arr;
    }

    public int getItemQuantity(String findDish) {
        int count=0;
        for (int i = 0; i <head.size ; i++) {

            if(findDish.equals(head.get(i).getName()))
            {

                count++;

            }
        }
        return count;


    }

    public int getItemQuantity(MenuItem item) {
        int count=0;
        for (int i = 0; i <head.size ; i++) {

            if(item.equals(head.get(i)))
            {

                count++;
            }
        }
        return count;


    }

    public String[] getItemsNames()
    {
        String[] resArr = new String[head.size];

        for (int i = 0; i <head.size ; i++) {
            resArr[i]=head.get(i).getName();
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
        String resString="";
        resString+="InternetOrder:"+"\n";
        resString+=customer.toString()+"\n";
        resString+=size+"\n";
        for (int i = 0; i <size ; i++) {
           resString+=head.get(i).toString()+"\n";
        }
        return resString;
    }

    @Override
    public boolean equals(Object obj) {

        InternetOrder order = (InternetOrder) obj;
        if(obj.getClass()==this.getClass())
        {
            if(order.customer.equals(this.customer) && this.size == order.size && order.equals(this.head))
            {
                return true;
            }
        }
        return  false;
    }

    @Override
    public int hashCode() {
        return size^customer.hashCode()^head.hashCode()^tail.hashCode();
    }

}
