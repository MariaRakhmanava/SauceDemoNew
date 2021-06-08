package objects;

public class CustomerInformation {
    String firstName;
    String lastName;
    String postalCode;

    public CustomerInformation(String firstName, String surname, String zip) {
        this.firstName = firstName;
        lastName = surname;
        postalCode = zip;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
