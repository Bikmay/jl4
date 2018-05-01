package barBossHouse;

import java.time.LocalDate;

public final class Customer {

    public static final String DEFAULT_NAME = "";
    public static final String DEFALT_SECONDNAME = "";
    public static final int DEFAULT_AGE = -1;
    public static final Address DEFAULT_ADDRESS = null;

// FIXME: 20.04.2018 
    //private final Customer MATURE_UNKNOWN_CUSTOMER = new Customer(21);
    //private final Customer NOT_MATURE_UNKNOWN_CUSTOMER = new Customer(14);
    public static final LocalDate DEFAULT_DATE_BIRTHDAY = null;
    private String name;
    private String secondName;
    private LocalDate birthday;
    private Address address;


    public Customer() {
        new Customer(DEFAULT_NAME, DEFALT_SECONDNAME, DEFAULT_ADDRESS, DEFAULT_DATE_BIRTHDAY);
    }

    public Customer(LocalDate date) {
        new Customer("", "", DEFAULT_ADDRESS, date);
    }

    public Customer(String name, String secondName, Address address, LocalDate birthday) {

        LocalDate now = LocalDate.now();
//TODO: среда подсказывает мне, что эта конструкция всегда будет false
        if (now.getYear() < birthday.getYear() | (now.getYear() == birthday.getYear() & now.getMonthValue() < birthday.getMonthValue()) && ((now.getYear() == birthday.getYear() & now.getMonthValue() == birthday.getMonthValue() & now.getDayOfWeek().getValue() < birthday.getDayOfWeek().getValue())))
            throw new IllegalArgumentException();


        this.name = name;
        this.secondName = secondName;
        this.birthday = birthday;
        this.address = address;
    }


    public int getAge() {

        LocalDate now = LocalDate.now();

        return now.getYear() - birthday.getYear();

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
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(name).append(" ");
        stringBuilder.append(secondName).append(" ");
        stringBuilder.append(getAge()).append(" ");
        stringBuilder.append(address.toString());
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        return name.hashCode() ^ secondName.hashCode() ^ getAge() ^ address.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() == obj.getClass()) {
            Customer customer = (Customer) obj;
            if (this.name.equals(customer.name) & this.secondName.equals(customer.secondName) & this.getAge() == customer.getAge() & this.address.equals(customer.address)) {
                return true;
            }

        }
        return false;
    }
}
