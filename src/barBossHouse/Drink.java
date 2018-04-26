package barBossHouse;

public class Drink extends MenuItem implements Alcoholable {

    private double alcoholVol;
    private DrinkTypeEnum type;


    public Drink(double cost, String name, DrinkTypeEnum type, String description, double alcoholVol) {



        super(name,description,cost);

        if(alcoholVol<0 | alcoholVol>100)
            throw new IllegalArgumentException();

        this.type = type;
        this.alcoholVol = alcoholVol;


    }


    public Drink(double cost, String name, DrinkTypeEnum type, String description) {
        super(name, description, cost);
        this.type = type;
        this.alcoholVol = 0;
    }

    public Drink(String name, DrinkTypeEnum type) {
        super(name, "", 0);
        this.type = type;
        this.alcoholVol = 0;
    }
    public Drink(){
        super("","",0);
    }


    public DrinkTypeEnum getType() {
        return type;
    }

    @Override
    public String toString() {
        return type + " " + getName() + "," + getCost() + "р." + " Alcholol:" + alcoholVol + "%" + " " + getDescription();
    }

    @Override
    public int hashCode() {
        Double aVol = alcoholVol;
        return type.hashCode() ^ super.hashCode() ^ aVol.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Drink drink = (Drink) obj;
        if (this.getClass() == obj.getClass()) {
            if (drink.type.equals(this.type) & drink.alcoholVol == this.alcoholVol)
                return true;
        }
        return false;
    }

    @Override
    public boolean isAlcoholicDrink() {
        return false;
    }

    @Override
    public double getAlcoholVol() {
        return 0;
    }
}
