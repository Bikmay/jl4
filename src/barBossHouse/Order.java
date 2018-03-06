package barBossHouse;

public class Order {

    //todo пересмотри свою политику именования в этом и других классах.
    //todo Dish можешь не трогать, там нормально)
    private int size;
    private Dish[] dishes;
    private final int DEFAULT_COUNT_DISHES=16;

    //todo константы и конструкторы по аналогии с Dish
    public Order() {
        new Order(DEFAULT_COUNT_DISHES);
    }

    public Order(int numberOfElements) {
        dishes = new Dish[numberOfElements];
        size=numberOfElements;
    }

    public Order(Dish[] dishes) {

    }

    private static Dish[] quickSort(Dish[] mass, int b, int e) {
        int l = b, r = e;
        Dish piv = mass[(b + e) / 2];
        do {
            while (mass[l].getCost() < piv.getCost()) l++;
            while (mass[r].getCost() > piv.getCost()) r--;
            if (l <= r) mass = swap(mass, l, r);
        } while (l <= r);
        if (b < r) quickSort(mass, b, r);
        if (e > l) quickSort(mass, l, e);
        return mass;
    }  //Быстрая сортировака


    private static Dish[] swap(Dish[] mass, int firstIndex, int secondIndex) {
        Dish copyFirstValue;
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
            for (int j = 0; j < dishes.length; j++) {
                if (deleteDishes[i].equals(dishes[j].getName())) {
                    dishes[j] = null;
                    indexMass[count] = j;
                    count++;
                    size--;
                }
            }
        }

        for (int i = 0; i < indexMass.length; i++) {
            System.arraycopy(dishes,indexMass[i],dishes,indexMass[i]-i,count+size-indexMass[i]-1);
        }
        return count;
    }


    //todo именование дерьмо
    //todo но метод оставляет за собой дырку в массиве, это нехорошо)
    //do
    public boolean deleteDish(String deleteDish) {
        for (int i = 0; i < dishes.length; i++) {
            if (deleteDish.equals(dishes[i].getName())) {
                dishes[i] = null;
                System.arraycopy(dishes, i, dishes, i + 1, size);
                dishes[size]=null;
                size--;
                return true;
            }
        }
        return false;
    }

    //todo именование дерьмо
    //todo именование переменных тоже дерьмо
    //do
    public Dish[] getSortedDishes() {



        dishes = quickSort(dishes, 0, size - 1);

        //todo и здесь... ??
        //Вписываю в результирующий массив

        //todo тебе достаточно использовать просто метод быстрой сортировки,
        //todo зачем ты занимаешься созданием бесполезных массиввов?
        //Сортировка идёт по цене
        return dishes;
    }


    //todo именование дерьмо
    //todo не нужно отлавливать на данном этапе исключения
    //todo используешь приватный сайз для добавления. Если он меньше длины массива, то просто добавляешь
    //todo если меньше, то увеличиваешь массив вдвое, копируешь и добавляешь
    //do
    public boolean addDish(Dish dish) {

        if (dishes.length <= size) {
            dishes[size] = dish;
            size++;
            return true;
        } else {

            Dish[] newMass = new Dish[(size-1) * 2];
            System.arraycopy(dishes, 0, newMass, 0, size-1);
            newMass[size] = dish;
            dishes = newMass;
            size++;
            return true;
        }

    }

    //todo именование дерьмо
    //todo вернул бы копию массива от 0 до size
    //do
    public Dish[] getDishes() {
        Dish[] copyMass = new Dish[dishes.length];
        System.arraycopy(dishes, 0, copyMass, 0, dishes.length);
        return copyMass;
    }


    //todo именование дерьмо
    //do
    public int getDishesCount(String nameOfDish) {
        int count = 0;
        for (int i = 0; i < dishes.length; i++) {
            if (nameOfDish.equals(dishes[i].getName())) {
                count++;
            }
        }
        return count;
    }

    //todo именование дерьмо
    //do
    public double totalCost() {
        double cost = 0;
        for (int i = 0; i < dishes.length; i++) {
            cost += dishes[i].getCost();
        }
        return cost;
    }

    //todo именование дерьмо
    //todo что блять здесь происходит >_<
    //reform code
    //do
    public String[] getNamesBookedDishs() {
        String[] names = new String[dishes.length];

        for (int i = 0; i < dishes.length; i++) {
            names[i] = dishes[i].getName();
        }
        return names;
    }

    //todo А ты уверен, что реализовал здесь все методы по заданию?
    //один забыл, но сделал
    public int getCountDishes() {
        return size;
    }
}
