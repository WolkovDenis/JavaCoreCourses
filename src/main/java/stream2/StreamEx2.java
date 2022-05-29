package stream2;

import patProject.Person;
import patProject.PersonService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.*;
import java.util.stream.*;

public class StreamEx2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] mass = new String[5];
        Random random = new Random();
        // IntStream.range(0,100).forEach(System.out::println);
        // IntStream.generate(()-> random.nextInt(10)).skip(3).limit(7).forEach(System.out::println);
        //  int sum = IntStream.generate(() -> random.nextInt(10)).skip(3).limit(5).sum();
        // System.out.println(sum);

        PersonService service = new PersonService();
        List<Person> persons = service.sendRequestToRandomUsersApi(10);
        //    persons
        //            .stream()
        //            .sorted(Comparator.comparing(Person::getCountry)
        //                   .thenComparing(Person::getFirstName)
        //                   .thenComparing(Person::getCountry))
        //                   .forEach(System.out::println);

    /*    String domenMail = "@gmail.com";
        String collect = persons
                .stream()
                .map(s -> s.getLastName() + s.getBod().getYear())
                .collect(Collectors.joining(domenMail,"",domenMail));
        System.out.println(collect);


        IntStream intStream = IntStream.of(3,5,7,8);
        IntStream intStream2 = IntStream.of(1,2,3,4);
        IntStream.concat(IntStream.of(3,5,7,8),IntStream.of(1,2,3,4)).forEach(System.out::print);
*/

   /*     persons
                .stream()
                .mapToInt(person -> LocalDate.now().getYear() - person.getBod().getYear()).max()
                .ifPresent(System.out::println);
*/

        List<Integer> list = new ArrayList<>();

        List<Integer> list1 = Collections.synchronizedList(list);

        CopyOnWriteArrayList<Integer> copy = new CopyOnWriteArrayList<>();
        CopyOnWriteArrayList<Integer> copy1 = new CopyOnWriteArrayList<>();

        long l = System.currentTimeMillis();
        IntStream.range(0, 10_0000).parallel().forEach(copy::add);
        System.out.println((double) System.currentTimeMillis() - l);
        System.out.println(copy.size());

        long l1 = System.currentTimeMillis();
        IntStream.range(0, 10_0000).parallel().forEach(copy1::add);
        System.out.println((double) System.currentTimeMillis() - l1);
        System.out.println(copy1.size());

    }
}
