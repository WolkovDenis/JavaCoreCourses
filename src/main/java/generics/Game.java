package generics;

import java.util.Random;

public class Game {
    public static <T extends Employee> void defineTeam(Team<T> team, Team<T> team2) {
        Random random = new Random();
        int i = random.nextInt( 2);
        if (i == 1) {
            System.out.println("Winner team" + " " + team.getName());
        } else {
            System.out.println("Winner team" + " " + team2.getName());
        }
    }

    public static void main(String[] args) {
        BackEndDeveloper backEndDeveloper = new BackEndDeveloper("Sergey", 35);
        BackEndDeveloper backEndDeveloper2 = new BackEndDeveloper("Olga", 27);
        Team<BackEndDeveloper> team = new Team("Apollo");
        team.addEmployeeToTeam(backEndDeveloper);
        team.addEmployeeToTeam(backEndDeveloper2);

        BackEndDeveloper backEndDeveloper3 = new BackEndDeveloper("Kostya", 32);
        BackEndDeveloper backEndDeveloper4 = new BackEndDeveloper("Ira", 24);
        Team<BackEndDeveloper> team3 = new Team("Apollone");
        team3.addEmployeeToTeam(backEndDeveloper3);
        team3.addEmployeeToTeam(backEndDeveloper4);


  /*
        TesterMan testerMan = new TesterMan("Oleg", 21);
        TesterMan testerMan2 = new TesterMan("Andrey", 37);
        Team<TesterMan> team2 = new Team("Ares");
        team2.addEmployeeToTeam(testerMan);
        team2.addEmployeeToTeam(testerMan2);
*/
        defineTeam(team, team3);
    }
}
