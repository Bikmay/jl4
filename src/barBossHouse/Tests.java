package barBossHouse;

import java.util.LinkedList;

public class Tests {

    //todo чот так себе тесты)
    public static void main(String[] args) {

        TableOrder order = new TableOrder();

        System.out.println(testCheckClassOrder1(order));

        LinkedList list;

    }

    private static boolean testCheckClassOrder1(TableOrder order)//Тестим возвращение массива блюд без дубликатов
    {
        order.addDish(new MenuItem("Картошечка", "Быстрее"));
        order.addDish(new MenuItem("Грибы", "медленее"));
        order.addDish(new MenuItem("Борщец", "Быстрее"));
        order.addDish(new MenuItem("Пюре", "Горячее"));
        order.addDish(new MenuItem("Картошечка", "Быстрее"));

        String[] testMass = order.getNamesBookedDishs();

        for (int i = 0; i < testMass.length; i++) {
            for (int j = 0; j < testMass.length; j++) {
                if (testMass[i].equals(testMass[j])) {
                    return false;
                }
            }

        }
        return true;
    }


}
