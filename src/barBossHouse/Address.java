package barBossHouse;

public class Address {

    public final Address EMPTY_ADDRESS = null;
    private String cityName;
    private String streetName;
    private int zipCode;
    private int buildingName;
    private char buildingLetter;
    private int apartmentNumber;

    public Address(String cityName, String streetName, int zipCode, int buildingName, char buildingLetter, int apartmentNumber) {
        this.cityName = cityName;
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.buildingName = buildingName;
        this.buildingLetter = buildingLetter;
        this.apartmentNumber = apartmentNumber;
    }


    public Address() {
        new Address("", "", -1, -1, ' ', -1);
    }

    public Address(String streetName, int buildingName, char buildingLetter, int apartmentNumber) {
        new Address("Самара", streetName, -1, buildingName, buildingLetter, apartmentNumber);
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

    //todo: заюзай StringBuilder
    //todo:do
    @Override
    public String toString() {

        String.format("%d %d , %s")
        //return cityName + " " + zipCode + "," + streetName + " " + buildingName + " " + buildingLetter + "-" + apartmentNumber;
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
