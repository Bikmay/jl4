package barBossHouse;

public final class Customer {

    private String name;
    private String secondName;
    private int age;
    private Address address;


    private final Customer MATURE_UNKNOWN_CUSTOMER = new Customer(21);
    private final Customer NOT_MATURE_UNKNOWN_CUSTOMER = new Customer(14);

    public static final String DEFAULT_NAME="";
    public static final String DEFALT_SECONDNAME="";
    public static final int DEFAULT_AGE=-1;
    public static final Address DEFAULT_ADDRESS=null;


    //todo: опять же, дефолт в константы
    //todo: do
    public Customer() {
        new Customer(DEFAULT_NAME,DEFALT_SECONDNAME,  DEFAULT_AGE, DEFAULT_ADDRESS);
    }

    public Customer(int age) {
        new Customer("", "", age, DEFAULT_ADDRESS);
    }

    public Customer(String name, String secondName, int age, Address address) {
        this.name = name;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }


    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return secondName + " " + name + " " + age + " " + address.toString();
    }

    @Override
    public int hashCode() {
        return name.hashCode() ^ secondName.hashCode() ^ age ^ address.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() == obj.getClass()) {
            Customer customer = (Customer) obj;
            if (this.name.equals(customer.name) & this.secondName.equals(customer.secondName) & this.age == customer.age & this.address.equals(customer.address)) {
                return true;
            }

        }
        return false;
    }
}
