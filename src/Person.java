import java.util.Objects;

public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String address;
    private boolean isAgeSet = false;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this(name, surname);
        this.age = age;
        this.isAgeSet = true;
    }

    public Person(String name, String surname, String address) {
        this(name, surname);
        this.address = address;
    }

    public Person(String name, String surname, int age, String address) {
        this(name, surname, age);
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public boolean hasAddress() {
        return getAddress() != null;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean hasAge() {
        return isAgeSet;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        child.setSurname(this.surname).setAddress(this.address);
        return child;
    }

    @Override
    public String toString() {
        return name + " " + surname +
               (hasAge() ? ", возраст:" + age : "") +
               (hasAddress() ? ", живет в " + address : "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && isAgeSet == person.isAgeSet && Objects.equals(name, person.name) &&
               Objects.equals(surname, person.surname) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, isAgeSet, address);
    }
}
