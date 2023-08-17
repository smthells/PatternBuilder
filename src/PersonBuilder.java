public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;
    private boolean isAgeSet = false;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным!");
        }
        this.age = age;
        this.isAgeSet = true;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Обязательно должны быть указаны имя и фамилия!");
        }
        Person person;
        if (isAgeSet && address != null) {
            person = new Person(name, surname, age, address);
        } else if (isAgeSet) {
            person = new Person(name, surname, age);
        } else if (address != null) {
            person = new Person(name, surname, address);
        } else {
            person = new Person(name, surname);
        }
        return person;
    }
}
