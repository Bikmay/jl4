package barBossHouse;

public class TableOrder {

    //todo пересмотри свою политику именования в этом и других классах.
    //todo MenuItem можешь не трогать, там нормально)
    private int size;
    private MenuItem[] menuItems;
    private Customer customer;

    private final int DEFAULT_COUNT_DISHES=16;

    //todo константы и конструкторы по аналогии с MenuItem
    public TableOrder(Customer customer) {
        new TableOrder(DEFAULT_COUNT_DISHES,customer);
    }

    public TableOrder(int numberOfElements, Customer customer) {
        menuItems = new MenuItem[numberOfElements];
        size=numberOfElements;
        this.customer=customer;
    }

    public TableOrder(MenuItem[] menuItems, Customer customer) {
        this.customer=customer;
    }

    private static MenuItem[] quickSort(MenuItem[] mass, int b, int e) {
        int l = b, r = e;
        MenuItem piv = mass[(b + e) / 2];
        do {
            while (mass[l].getCost() < piv.getCost()) l++;
            while (mass[r].getCost() > piv.getCost()) r--;
            if (l <= r) mass = swap(mass, l, r);
        } while (l <= r);
        if (b < r) quickSort(mass, b, r);
        if (e > l) quickSort(mass, l, e);
        return mass;
    }  //Быстрая сортировака


    private static MenuItem[] swap(MenuItem[] mass, int firstIndex, int secondIndex) {
        MenuItem copyFirstValue;
        copyFirstValue = mass[firstIndex];
        mass[firstIndex] = mass[secondIndex];
        mass[secondIndex] = copyFirstValue;
        return mass;
    }

    //todo именование дерьмо
    //do1
    public int deleteDishes(String[] deleteDishes) {
        int count = 0;
        int[] indexMass = new int[deleteDishes.length];
        for (int i = 0; i < deleteDishes.length; i++) {
            for (int j = 0; j < menuItems.length; j++) {
                if (deleteDishes[i].equals(menuItems[j].getName())) {
                    menuItems[j] = null;
                    indexMass[count] = j;
                    count++;
                    size--;
                }
            }
        }

        for (int i = 0; i < indexMass.length; i++) {
            System.arraycopy(menuItems,indexMass[i], menuItems,indexMass[i]-i,count+size-indexMass[i]-1);
        }
        return count;
    }


    //todo именование дерьмо
    //todo но метод оставляет за собой дырку в массиве, это нехорошо)
    //do
    public boolean deleteDish(String deleteDish) {
        for (int i = 0; i < menuItems.length; i++) {
            if (deleteDish.equals(menuItems[i].getName())) {
                menuItems[i] = null;
                System.arraycopy(menuItems, i, menuItems, i + 1, size);
                menuItems[size]=null;
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean deleteMenuItem(MenuItem menuItem)
    {
        for (int i = 0; i <size ; i++) {
            if(menuItems[i].equals(menuItem))
            {
                System.arraycopy(menuItems,i,menuItems,i+1,size-i);
                return true;
            }

        }
        return false;
    }

    public int deleteMenuItems(MenuItem menuItem)
    {
         int count=0;

        for (int i = 0; i <size ; i++) {
            if(menuItems[i].equals(menuItem))
            {
                System.arraycopy(menuItems,i,menuItems,i+1,size-i);
                count++;
            }

        }
        return count;

    }

    //todo именование дерьмо
    //todo именование переменных тоже дерьмо
    //do
    public MenuItem[] getSortedDishes() {



        menuItems = quickSort(menuItems, 0, size - 1);

        //todo и здесь... ??
        //Вписываю в результирующий массив

        //todo тебе достаточно использовать просто метод быстрой сортировки,
        //todo зачем ты занимаешься созданием бесполезных массиввов?
        //Сортировка идёт по цене
        return menuItems;
    }


    //todo именование дерьмо
    //todo не нужно отлавливать на данном этапе исключения
    //todo используешь приватный сайз для добавления. Если он меньше длины массива, то просто добавляешь
    //todo если меньше, то увеличиваешь массив вдвое, копируешь и добавляешь
    //do
    public boolean addDish(MenuItem menuItem) {

        if (menuItems.length <= size) {
            menuItems[size] = menuItem;
            size++;
            return true;
        } else {

            MenuItem[] newMass = new MenuItem[(size-1) * 2];
            System.arraycopy(menuItems, 0, newMass, 0, size-1);
            newMass[size] = menuItem;
            menuItems = newMass;
            size++;
            return true;
        }

    }

    //todo именование дерьмо
    //todo вернул бы копию массива от 0 до size
    //do
    public MenuItem[] getMenuItems() {
        MenuItem[] copyMass = new MenuItem[menuItems.length];
        System.arraycopy(menuItems, 0, copyMass, 0, menuItems.length);
        return copyMass;
    }


    //todo именование дерьмо
    //do
    public int getDishesCount(String nameOfDish) {
        int count = 0;
        for (int i = 0; i < menuItems.length; i++) {
            if (nameOfDish.equals(menuItems[i].getName())) {
                count++;
            }
        }
        return count;
    }

    //todo именование дерьмо
    //do
    public double totalCost() {
        double cost = 0;
        for (int i = 0; i < menuItems.length; i++) {
            cost += menuItems[i].getCost();
        }
        return cost;
    }

    //todo именование дерьмо
    //todo что блять здесь происходит >_<
    //reform code
    //do
    public String[] getNamesBookedDishs() {
        String[] names = new String[menuItems.length];

        for (int i = 0; i < menuItems.length; i++) {
            names[i] = menuItems[i].getName();
        }
        return names;
    }

    //todo А ты уверен, что реализовал здесь все методы по заданию?
    //один забыл, но сделал
    public int getCountDishes() {
        return size;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        String returnString="";

        returnString+= "TakeOder:"+size+"\n";

        for (int i = 0; i <size ; i++) {
            returnString+=menuItems[i].toString()+"\n";
        }
        return returnString;
    }

    @Override
    public boolean equals(Object obj) {
        TableOrder tableOrder =(TableOrder) obj;
       if(obj.getClass()==this.getClass() && this.customer.equals(tableOrder))
       {
           for (int i = 0; i <size ; i++) {
               if(!(this.menuItems[i].equals(tableOrder.menuItems[i])))
               {
                   return false;
               }
           }
           return true;
       }
       return false;
    }
}
