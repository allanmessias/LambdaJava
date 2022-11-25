package LambdaTutorial;

import java.util.ArrayList;
import java.util.List;

import LambdaTutorial.Person.Sex;

public class LambdaExpressionTutorial {
    public static void main(String[] args) {
        Person person = new Person();
        List<Person> list = new ArrayList<>();

        list.add(person);

        person.printPersons(list, (Person p) -> p.gender == Sex.MALE && p.getAge() >= 18 && p.getAge() <= 60);
        person.printPersonsWithPredicate(list,
                (Person p) -> p.gender == Sex.MALE && p.getAge() >= 18 && p.getAge() <= 60);

    }

}
