package JDBCImplementations.Entity;

public class Person {
    //All final attributes
    private final String firstName; // required
    private final String lastName; // required
    private final String city; // optional
    private final String phone; // optional
    private final String address; // optional

    private Person(PersonBuilder personBuilder) {
        this.firstName = personBuilder.firstName;
        this.lastName = personBuilder.lastName;
        this.city = personBuilder.city;
        this.phone = personBuilder.phone;
        this.address = personBuilder.address;
    }

    //All getter, and NO setter to provde immutability
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getCity() {
        return city;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User: "+this.firstName+", "+this.lastName+", "+this.city+", "+this.phone+", "+this.address;
    }

    public static class PersonBuilder {
        private final String firstName;
        private final String lastName;
        private String city;
        private String phone;
        private String address;

        public PersonBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public Person.PersonBuilder city(String city) {
            this.city = city;
            return this;
        }
        public Person.PersonBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public Person.PersonBuilder address(String address) {
            this.address = address;
            return this;
        }
        //Return the finally consrcuted User object
        public Person build() {
            return new Person(this);
        }
    }
}
