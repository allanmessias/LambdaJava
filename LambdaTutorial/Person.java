package LambdaTutorial;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public class Person {
    public enum Sex {
        MALE, FEMALE;
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public void printPerson() {

    }

    public int getAge() {
        return 20;
    }

    /**
     * 1ª abordagem: Criar um método que procura membros por uma característica
     */
    public void printPersonsOlderThan(List<Person> list, int age) {
        for (Person p : list) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    // Esta abordagem acima pode falhar pois não está sujeita a inserção de novos
    // tipos de dados, ou seja, caso a estrutua
    // de Person mude, teriámos de alterar muitas coisas na nossa API para acomodar
    // essa mudança.

    /**
     * 2ª abordagem: Criar um método mais geral e genérico
     */
    public void printPersonWithinAgeRange(List<Person> list, int low, int high) {
        for (Person p : list) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }
    // E se quiséssemos algo mais profundo, como informações sobre o sexo da pessoa,
    // ou uma combinação de ranges?
    // Mesmo que esse método seja mais genérico, criar um método para cada situação
    // pode criar código repetido e falho
    // Nessa situação, podemos mudar o critério para outra classe

    /**
     * 3ª abordagem: Especifique o código do critério de busca numa classe Local
     */
    public void printPersons(List<Person> list, CheckPerson tester) {
        for (Person p : list) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    /**
     * 4ª abordagem: Especifica o código do critério com uma expressão Lambda
     */

    /**
     * 5ª abordagem: Use uma interface funcional com expressões lambdas
     */
    public void printPersonsWithPredicate(List<Person> list, Predicate<Person> tester) {
        for (Person p : list) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    /**
     * 6ª abordagem: Use lambda pela sua aplicação
     */

}
