package patProject;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.function.Supplier;

public class PersonService {

    public ArrayList<Person> sendRequestToRandomUsersApi(int numbersPerson) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(String.format("https://randomuser.me/api/?nat=us,dk,fr,gb&results=10", numbersPerson)))
                .build();
        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
        parseJsonResponseToPerson(response.body());
        return parseJsonResponseToPerson(response.body());
    }

    public ArrayList<Person> parseJsonResponseToPerson(String data) {
        JSONObject fullJsonObject = new JSONObject(data);
        int countPerson = fullJsonObject.getJSONObject("info").getInt("results");
        ArrayList<Person> persons = new ArrayList<>();
        for (int i = 0; i < countPerson; i++) {
            JSONObject results = fullJsonObject.getJSONArray("results").getJSONObject(i);

            Person person = new Person();
            JSONObject name = results.getJSONObject("name");
            person.setFirstName(name.getString("first"));
            person.setLastName(name.getString("last"));
            person.setGender(results.getString("gender"));
            person.setEmail(results.getString("email"));
            JSONObject dob = results.getJSONObject("dob");
            ZonedDateTime zonedDateTime = ZonedDateTime.parse(dob.getString("date"));
            person.setBod(zonedDateTime.toLocalDate());
            JSONObject location = results.getJSONObject("location");
            person.setCountry(location.getString("country"));


// Интерфейс Supplier
            String firstName = name.getString("first");
            String lastName = name.getString("last");
            String gender = results.getString("gender");
            String country = location.getString("country");
            String email = results.getString("email");
            LocalDate dateBethDay = zonedDateTime.toLocalDate();
            Supplier<Person> supplier = () -> new Person(firstName, lastName, gender, email, dateBethDay, country);
            persons.add(supplier.get());
        }
        return persons;
    }
}


