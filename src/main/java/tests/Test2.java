package tests;

import java.util.*;
import java.util.stream.Collectors;

public class Test2 {

    static class Vacancy{

        String name;
        int cell;

        public Vacancy(String name, int cell) {
            this.name = name;
            this.cell = cell;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCell() {
            return cell;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vacancy vacancy = (Vacancy) o;
            return cell == vacancy.cell && Objects.equals(name, vacancy.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, cell);
        }

        @Override
        public String toString() {
            return  name + ',' + cell;
        }
    }

    static class People{
        String name;
        Vacancy vacancy;
        int completeTask;
        int penalty;

        public People(String name, Vacancy vacancy, int completeTask, int penalty) {
            this.name = name;
            this.vacancy = vacancy;
            this.completeTask = completeTask;
            this.penalty = penalty;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Vacancy getVacancy() {
            return vacancy;
        }

        public void setVacancy(Vacancy vacancy) {
            this.vacancy = vacancy;
        }

        public int getCompleteTask() {
            return completeTask;
        }

        public void setCompleteTask(int completeTask) {
            this.completeTask = completeTask;
        }

        public int getPenalty() {
            return penalty;
        }

        public void setPenalty(int penalty) {
            this.penalty = penalty;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            People people = (People) o;
            return completeTask == people.completeTask && penalty == people.penalty && Objects.equals(name, people.name) && Objects.equals(vacancy, people.vacancy);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, vacancy, completeTask, penalty);
        }

        @Override
        public String toString() {
            return name + "," + vacancy.name + "," + completeTask + "," + penalty;
        }
    }

    public static void main(String[] args) {
        Map<String,Vacancy> vacancyMap = new HashMap<>();
        List<Vacancy> vacancyList = new ArrayList<>();
        List<People> peopleList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int countVacancy = scanner.nextInt();

        for(int i = 0; i < countVacancy; i++){
            String vacancyString = scanner.next();
            String[] dataVacancy = vacancyString.split(",");
            String nameVacancy = dataVacancy[0];
            Vacancy vacancy = new Vacancy(nameVacancy, Integer.valueOf(dataVacancy[1]));
            vacancyList.add(vacancy);
            vacancyMap.put(nameVacancy, vacancy);
        }

        int countPeople = scanner.nextInt();

        for(int i = 0; i < countPeople; i++){
            String peopleString = scanner.next();
            String[] dataPeople = peopleString.split(",");
            People people = new People(dataPeople[0], vacancyMap.get(dataPeople[1]), Integer.valueOf(dataPeople[2]), Integer.valueOf(dataPeople[3]));
            peopleList.add(people);
        }

        List<People> result = new ArrayList<>();

        Map<Vacancy, List<People>> groupingPeople = peopleList.stream().collect(Collectors.groupingBy(People::getVacancy));
        groupingPeople.forEach((k,v)->{
            v.stream().sorted(Comparator.comparingInt((People p) -> p.completeTask).thenComparingInt(p -> -p.penalty).reversed()).limit(k.getCell()).forEach(p-> result.add(p));
        });

        result.stream().sorted(Comparator.comparing(People::getName)).forEach(people -> System.out.println(people.getName()));

    }
}
