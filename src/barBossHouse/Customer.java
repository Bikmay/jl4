package barBossHouse;

public final class Customer {

    private String name;
    private String secondName;
    private int age;
    private Address address;


    private final Customer MATURE_UNKNOWN_CUSTOMER = new Customer(21);
    private final Customer NOT_MATURE_UNKNOWN_CUSTOMER = new Customer(14);

    //todo: опять же, дефолт в константы
    public Customer() {
        new Customer("", "", -1, null);
    }

    public Customer(int age) {
        new Customer("", "", age, null);
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
