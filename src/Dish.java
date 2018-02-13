import java.util.ArrayList;

public class Dish {

    /*
    * Все комментарии актуальны для других классов, будут частично повторять то, что было сказано на паре
    * */

    //поля приватные, не инициализируются при объявлении, именуются согласно конвенции, в своем большинстве не должны быть статичными
    public static String NameOfFood;
    private static String DescriptionsOrders;
//делай как константу и не используй магические константы
    private static double cost=0;

//указания про конструкторы актуальны
    Dish(String InputNameOfFood,String InputDescriptionsOrders)
    {
        NameOfFood = InputNameOfFood;
        DescriptionsOrders = InputDescriptionsOrders;
        cost=0;
    }
//именуй методы в соответствии с конвенцией, геты, сеты, и т.д.

    public double costOfOrder()
    {
        return cost;
    }

    public static double getNewCost(double new_cost)
    {
        cost= new_cost;
        return  cost;
    }

    public String getNameOfFood()
    {
        return NameOfFood;
    }

    public static void renameFood(String new_name)
    {
        NameOfFood=new_name;
    }

    public static String getDescription()
    {
        return DescriptionsOrders;
    }

    public static void renameDescription(String new_name)
    {
        DescriptionsOrders=new_name;
    }



}
