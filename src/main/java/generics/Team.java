package generics;

import java.util.ArrayList;
import java.util.List;

public class Team<T> {
    private String name;
    private List<T> employees = new ArrayList<>();

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public void addEmployeeToTeam(T e) {
        employees.add(e);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
