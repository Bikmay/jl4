public class Dish {


    public String NameOfFood;
    private String DescriptionsOrders;
    private double cost = 0;


    public Dish(String InputNameOfFood, String InputDescriptionsOrders)
    {
        NameOfFood = InputNameOfFood;
        DescriptionsOrders = InputDescriptionsOrders;
        cost=0;
    }

    public double getCostOfOrder()
    {
        return cost;
    }

    public void setNewCost(double new_cost)
    {
        this.cost = new_cost;

    }

    public String getNameOfFood()
    {
        return NameOfFood;
    }

    public void setNameFood(String new_name)
    {
        this.NameOfFood = new_name;
    }

    public String getDescription()
    {
        return DescriptionsOrders;
    }

    public void setNameDescription(String new_name)
    {
        DescriptionsOrders=new_name;
    }



}
