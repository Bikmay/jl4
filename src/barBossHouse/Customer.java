package barBossHouse;

import java.time.LocalDate;

public final class Customer {

    private String name;
    private String secondName;
    private LocalDate birthday;
    private Address address;

// FIXME: 20.04.2018 
    //private final Customer MATURE_UNKNOWN_CUSTOMER = new Customer(21);
    //private final Customer NOT_MATURE_UNKNOWN_CUSTOMER = new Customer(14);

    public static final String DEFAULT_NAME="";
    public static final String DEFALT_SECONDNAME="";
    public static final int DEFAULT_AGE=-1;
    public static final Address DEFAULT_ADDRESS=null;
    public static final LocalDate DEFAULT_DATE_BIRTHDAY=null;


    
    public Customer() {
        new Customer(DEFAULT_NAME,DEFALT_SECONDNAME, DEFAULT_ADDRESS,DEFAULT_DATE_BIRTHDAY);
    }

    public Customer(LocalDate date) {
        new Customer("", "", DEFAULT_ADDRESS,date);
    }

    public Customer(String name, String secondName,  Address address,LocalDate birthday) {
        this.name = name;
        this.secondName = secondName;
        this.birthday=birthday;
        this.address = address;
    }

    // FIXME: 20.04.2018 
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

    // FIXME: 20.04.2018 
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
