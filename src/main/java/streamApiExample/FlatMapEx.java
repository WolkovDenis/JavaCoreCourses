package streamApiExample;

import patProject.Person;
import patProject.PersonService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlatMapEx {
    public static void main(String[] args) throws IOException, InterruptedException {
        PersonService personService = new PersonService();

        ArrayList<Person> arrayList = personService.sendRequestToRandomUsersApi(10);
        Map<Boolean, List<Person>> hashmap = arrayList
                .stream()
                .collect(Collectors.partitioningBy(s -> s.getBod().getYear() < 1990));

        ArrayList<Country> countries = new ArrayList<>();
        arrayList
                .stream()
                .collect(Collectors.groupingBy(Person::getCountry))
                .forEach((k,v) -> countries.add(new Country(k,v)));
        countries.forEach(System.out::println);
        System.out.println("//////////////////////////////////////////////////////////////////////////////");
        arrayList
                .stream()
                .collect(Collectors.groupingBy(Person::getCountry))
                .forEach((k,v) -> countries.add(new Country(k,v)));
        countries.stream().flatMap(c -> c.persons.stream()).forEach(System.out::println);
    }

}

class Country {
    String name;
    List<Person> persons;

    public Country() {
    }

    public Country(String name, List<Person> person) {
        this.name = name;
        this.persons = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPerson() {
        return persons;
    }

    public void setPerson(List<Person> person) {
        this.persons = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (name != null ? !name.equals(country.name) : country.name != null) return false;
        return persons != null ? persons.equals(country.persons) : country.persons == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (persons != null ? persons.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", person=" + persons +
                '}';
    }
}