package barBossHouse;

public class Tests {

    //todo чот так себе тесты)
    public static void main(String[] args) {

        Order order = new Order();

        System.out.println(testCheckClassOrder1(order));

    }

    private static boolean testCheckClassOrder1(Order order)//Тестим возвращение массива блюд без дубликатов
    {
        order.addToOrder(new Dish("Картошечка", "Быстрее"));
        order.addToOrder(new Dish("Грибы", "медленее"));
        order.addToOrder(new Dish("Борщец", "Быстрее"));
        order.addToOrder(new Dish("Пюре", "Горячее"));
        order.addToOrder(new Dish("Картошечка", "Быстрее"));

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
