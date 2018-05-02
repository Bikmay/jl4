package barBossHouse;

import sun.security.provider.PolicySpiFile;

public class Address {

    public final Address EMPTY_ADDRESS = new Address();
    private String cityName;
    private String streetName;
    private int zipCode;
    private int buildingName;
    private char buildingLetter;
    private int apartmentNumber;


    public static final String DEFAULT_CITYNAME = "";
    public static final String DEFAULT_STREETNAME = "";
    public static final int DEFAULT_ZIPCODE = -1;
    public static final int DEFAULT_BUILDINGNAME=-1;
    public static final char DEFAULT_BUILDINGLETTER=' ';
    public static final int DEFAULT_APARTMENTNUMBER=-1;


    public Address(String cityName, String streetName, int zipCode, int buildingName, char buildingLetter, int apartmentNumber) {

        if (zipCode < 0 | apartmentNumber < 0 | buildingName < 0 | Character.isLetter(buildingLetter))
            throw new IllegalArgumentException();

        this.cityName = cityName;
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.buildingName = buildingName;
        this.buildingLetter = buildingLetter;
        this.apartmentNumber = apartmentNumber;
    }

    //TODO: стой, ты опять дефолтные значения в константы не убираешь? оО
    //do
    public Address() {
        new Address(DEFAULT_CITYNAME, DEFAULT_STREETNAME, DEFAULT_ZIPCODE, DEFAULT_BUILDINGNAME, DEFAULT_BUILDINGLETTER, DEFAULT_APARTMENTNUMBER);
    }

    public Address(String streetName, int buildingName, char buildingLetter, int apartmentNumber) {
        new Address("Самара", streetName, DEFAULT_ZIPCODE, buildingName, buildingLetter, apartmentNumber);
    }


    public String getCityName() {
        return cityName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getBuildingName() {
        return buildingName;
    }

    public char getBuildingLetter() {
        return buildingLetter;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }


    //todo:do
    @Override
    public String toString() {

        return String.format("%s %d %s %s %s - %d", cityName, zipCode, streetName, buildingName, buildingLetter, apartmentNumber);

    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == this.getClass()) {
            Address secObj = (Address) obj;
            if (secObj.apartmentNumber == this.apartmentNumber &&
                    secObj.buildingLetter == this.buildingLetter &&
                    secObj.buildingName == this.buildingName &&
                    secObj.streetName.equals(this.streetName) &&
                    secObj.zipCode == this.zipCode &&
                    secObj.cityName.equals(this.cityName)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }


    }

    @Override
    public int hashCode() {
        return cityName.hashCode() ^ streetName.hashCode() ^ apartmentNumber ^ buildingName ^ buildingLetter ^
                zipCode;
    }


}
