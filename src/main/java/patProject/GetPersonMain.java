package patProject;

import java.io.IOException;
import java.util.ArrayList;

public class GetPersonMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        PersonService personService = new PersonService();

        long l = System.currentTimeMillis();
        personService.sendRequestToRandomUsersApi(10);
        System.out.println(System.currentTimeMillis() - l);

    }
}
