package patProject;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExample {

    // Интерфейс Function
    public static Integer getLength(Function<String, Integer> function, String s) {
        Integer apply = function.apply(s);
        return apply;
    }

    public static void filtering(ArrayList<Person> personList,
                                 Predicate<Person> predicito,
                                 Consumer<Person> cosumerito) {

        for (Person person : personList) {
            if (predicito.test(person)) cosumerito.accept(person);
        }
    }


    public static void main(String[] args) {
        PersonService personService = new PersonService();
        try {
            ArrayList<Person> arrayList = personService.sendRequestToRandomUsersApi(6);
            System.out.println(arrayList);

            //             filtering(arrayList, new Predicate<Person>() {   // Анонимный класс
            //             @Override
            //              public boolean test(Person person) {
            //                  return LocalDate.now().getYear() - person.getBod().getYear() < 40;
            //              }
            //          });


            // Длинный вариант лямбда
            //          filtering(arrayList,(Person person) ->{
            //               return LocalDate.now().getYear() - person.getBod().getYear() <40;
            //          });


            //           filtering(arrayList, p -> LocalDate.now().getYear() - p.getBod().getYear() < 40);
            //           System.out.println(p);
            //           filtering(arrayList, p -> {
            //               return LocalDate.now().getYear() - p.getBod().getYear() < 40;
            //           });

            Predicate<Person> consumer = p -> LocalDate.now().getYear() - p.getBod().getYear() < 40;
            Predicate<Person> consumer2 = p -> p.getCountry().equals("Germany");

            filtering(arrayList, consumer.and(consumer2),
                    p -> p.setFirstName(p.getFirstName().toUpperCase(Locale.ROOT)));


            arrayList.removeIf(p -> p.getCountry().equals("Iran"));
            System.out.println(arrayList);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

// Интерфейс Function
        Integer lambda = getLength(s -> s.length(), "Lambda");


    }
}


interface Predicito<T> {
    boolean test(T t);
}

interface Cosumerito<T> {

    void accept(T t);
}