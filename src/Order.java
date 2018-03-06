public class Order {

    //todo пересмотри свою политику именования в этом и других классах. Dish можешь не трогать, там нормально)
    private int size;
    private boolean CheckOpportunity = true;
    private Dish[] MassOfFood;
    private int index = 0;

    //todo константы и конструкторы по аналогии с Dish
    Order() {
        MassOfFood = new Dish[16];
    }

    Order(int NumberOfElements) {
        MassOfFood = new Dish[NumberOfElements];
    }

    Order(Dish[] MassOfFood) {

    }

    private static double[] quickSort(double[] mass, int b, int e) {
        int l = b, r = e;
        double piv = mass[(b + e) / 2];
        do {
            while (mass[l] < piv) l++;
            while (mass[r] > piv) r--;
            if (l <= r) mass = swap(mass, l, r);
        } while (l <= r);
        if (b < r) quickSort(mass, b, r);
        if (e > l) quickSort(mass, l, e);
        return mass;
    }  //Быстрая сортировака


    private static double[] swap(double[] mass, int firstIndex, int secondIndex) {
        double copyFirstValue;
        copyFirstValue = mass[firstIndex];
        mass[firstIndex] = mass[secondIndex];
        mass[secondIndex] = copyFirstValue;
        return mass;
    }

    //todo именование дерьмо

    public int deleteFoods(String NameFindFood) {
        int count = 0;
        for (int i = 0; i < MassOfFood.length; i++) {
            if (NameFindFood.equals(MassOfFood[i].getName())) {
                MassOfFood[i] = null;
                count++;
                //todo и ты на каждой операции будешь двигать массив? не надо так)
                //todo проще сначала все удалить, а потом перенести на пустые элементы
                System.arraycopy(MassOfFood, i, MassOfFood, i + 1, MassOfFood.length - i - 1);
            }
        }
        return count;
    }

    //todo именование дерьмо
    //todo но метод оставляет за собой дырку в массиве, это нехорошо)
    public boolean deleteOneFood(String NameFindFood) {
        for (int i = 0; i < MassOfFood.length; i++) {
            if (NameFindFood == MassOfFood[i].getName()) {
                MassOfFood[i] = null;
                return true;
            }
        }
        return false;
    }

    //todo именование дерьмо
    //todo именование переменных тоже дерьмо
    public Dish[] getSortMassDishs() {
        Dish[] dishmass = returnDishs();
        double[] w_mass = new double[dishmass.length];
        Dish[] ResMass = new Dish[dishmass.length];
        //todo зачем ты это делаешь??
        for (int i = 0; i < dishmass.length; i++) {
            w_mass[i] = dishmass[i].getCost();
        }
        w_mass = quickSort(w_mass, 0, w_mass.length - 1);
        //todo и здесь... ??
        for (int i = 0; i < w_mass.length; i++) {
            for (int j = 0; j < ResMass.length; j++) {
                if (dishmass[j].getCost() == w_mass[i]) {
                    ResMass[i] = dishmass[j];
                    dishmass[j] = null;
                }
            }
        }
        //todo тебе достаточно использовать просто метод быстрой сортировки,
        //todo зачем ты занимаешься созданием бесполезных массиввов?
        return ResMass;
    }


    //todo именование дерьмо
    //todo не нужно отлавливать на данном этапе исключения
    //todo используешь приватный сайз для добавления. Если он меньше длины массива, то просто добавляешь
    //todo если меньше, то увеличиваешь массив вдвое, копируешь и добавляешь
    public boolean addToOrder(Dish Food) {
        try {
            MassOfFood[index] = Food;
            index++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //todo именование дерьмо
    //todo вернул бы копию массива от 0 до size
    public Dish[] returnDishs() {
        Dish[] ResultMass = new Dish[MassOfFood.length];
        for (int i = 0; i < MassOfFood.length; i++) {
            if (MassOfFood == null) break;
            ResultMass[i] = MassOfFood[i];
        }
        return ResultMass;
    }


    //todo именование дерьмо
    public int numberDishsOfOrder(String nameOfDish) {
        Dish[] MassOfDish = returnDishs(); //todo зачем???
        int niga = 0;
        for (int i = 0; i < MassOfDish.length; i++) {
            if (nameOfDish == MassOfDish[i].getName()) { //todo сравнение строк по == ?!!
                niga++;
            }
        }
        return niga;
    }

    //todo именование дерьмо
    public double returnCostOfOrder() {
        double sum = 0;
        for (int i = 0; i < MassOfFood.length; i++) {
            sum += MassOfFood[i].getCost();
        }
        return sum;
    }

    //todo именование дерьмо
    //todo что блять здесь происходит >_<
    public String[] getMassOfDish() {
        int niga = MassOfFood.length;
        int R_a = 0;
        for (int i = 0; i < MassOfFood.length; i++) {
            for (int j = 0; j < MassOfFood.length; j++) {
                if (MassOfFood[i].getName() == MassOfFood[j].getName()) {
                    if (R_a > 0) {
                        niga -= 1;
                    }
                    R_a++;
                }
            }
        }
        //todo неплохим выходом из сиутации будет следующий подход
        //todo создаешь стринговый массив размера size
        //todo при совпадении имени добавляешь в массив имя блюда
        //todo тримишь массив и возвращаешь его
        String[] ReturNames = new String[niga];
        boolean Checker = true;
        int k = 0;
        for (int i = 0; i < MassOfFood.length; i++) {
            for (int j = 0; j < ReturNames.length; j++) {
                if (MassOfFood[i].getName() == MassOfFood[j].getName()) {
                    Checker = false;
                }
            }
            if (Checker == true) { //todo сравнивать логические переменные на булевские литералы? ВАТ?!
                ReturNames[k] = MassOfFood[i].getName();
                k++;
            }
        }
        return ReturNames;
    }

    //todo А ты уверен, что реализовал здесь все методы по заданию?
}
