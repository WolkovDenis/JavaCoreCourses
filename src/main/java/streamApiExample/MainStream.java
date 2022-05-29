package streamApiExample;

import patProject.Person;
import patProject.PersonService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainStream {
    public static void main(String[] args) throws IOException, InterruptedException {
        PersonService personService = new PersonService();
        ArrayList<Person> arrayList = personService.sendRequestToRandomUsersApi(10);
        System.out.println(arrayList);
        for (Person person : arrayList) {
            person.getCountry();
        }
        arrayList
                .stream()
                .map(person -> person.getCountry())
                .filter(country -> country.equals("United Kingdom"))
                .forEach(System.out::println);

        List<String> collect = arrayList
                .stream()
                .filter(p -> p.getBod().getYear() < 1980)
                .map(person -> person.getFirstName().toUpperCase(Locale.ROOT))
                .peek(System.out::println).collect(Collectors.toList());

        // arrayList.stream()
        Stream.of(1, 2, 3, 4, 5, 6, 7, 9).reduce((acc, n) -> acc + n)
                .ifPresent(System.out::println);

        arrayList
                .stream()
                .map(person -> person.getBod().getYear())
                .reduce((acc, year) -> acc + (LocalDate.now().getYear() - year))
                .ifPresent(System.out::println);

        arrayList
                .stream()
                .sorted((p,p1)->{
                  if (p.getFirstName().compareTo(p1.getFirstName()) != 0){
                        return   p.getFirstName().compareTo(p1.getFirstName());
                  }  else if (p.getLastName().compareTo(p1.getLastName()) !=0) {
                      return  p.getLastName().compareTo(p1.getLastName());
                  } else {
                      return p.getBod().compareTo(p1.getBod());
                  }
                }).forEach(System.out::println);

        Stream.of(111,111,234,546,654)
                .distinct()
                .forEach(System.out::println);

        System.out.println(Stream.of(111,111,234,546,654).count());

                    
    }
}
