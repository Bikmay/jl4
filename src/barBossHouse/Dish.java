package barBossHouse;

public class Dish extends MenuItem {
    //todo: дефолт
    //todo:do

    private static final int DEFAULT_VALUE = 0;

    protected Dish(String name, String description) {
        super(name, description, DEFAULT_VALUE);
    }

    protected Dish(String name, String description, int cost) {
        super(name, description, cost);
    }

    @Override
    public String toString() {

        return String.format("%s %s", super.toString(), super.getDescription());

        //return super.toString() + " " + super.getDescription();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        MenuItem menuItem = this;

        if (obj.getClass() == this.getClass() && menuItem.equals(obj)) {
            return true;

        }
        return false;
    }
}


