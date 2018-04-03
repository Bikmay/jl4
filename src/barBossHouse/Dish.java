package barBossHouse;

public class Dish extends MenuItem{

    protected Dish(String name, String description) {
        super(name, description,0);
    }

    protected Dish(String name, String description,int cost) {
        super(name, description,cost);
    }

    @Override
    public String toString() {
        return super.toString()+" "+ super.getDescription();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    //todo переделать
    @Override
    public boolean equals(Object obj) {
        MenuItem menuItem= this;

        if (obj.getClass()==this.getClass() && menuItem.equals(obj))
        {
            return true;

        }
        return false;
    }
}


