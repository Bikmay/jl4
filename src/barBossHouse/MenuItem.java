package barBossHouse;

public abstract class MenuItem {


    private static final int DEFAULT_COST = 0;
    private String name;
    private String description;
    private double cost;



    protected MenuItem(String name, String description) {
        this(name, description, DEFAULT_COST);
    }

    protected MenuItem(String name, String description, double cost) {

        if(cost<0)
            throw new IllegalArgumentException();

        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }


    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return name + "," + cost + "р.";
    }

    @Override
    public boolean equals(Object obj) {
        MenuItem menuItem = (MenuItem) obj;

        if (menuItem.name == this.name & this.cost == menuItem.cost)
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode() ^ description.hashCode() ^ (int) cost;
    }
}
