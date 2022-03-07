package com.prince.cicd;

import com.prince.cicd.test.lambda.Class2;
import com.prince.cicd.test.lambda.Class3;
import com.prince.cicd.test.lambda.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String... args){

//        Supplier<String> supplier = () -> "Test CI/CD";
//        System.out.println(supplier.get());
//
//        Consumer<String> consumer = (String s) ->  {
//            System.out.println(s);
//            System.out.println(s);
//            System.out.println(s);
//            System.out.println("Show another line");
//        };
//
//        consumer.accept("Implementing Consumer.accept");
//
//        System.out.println("Test CI/CD -> Lambda Expression : No-1");
//        System.out.println("Test CI/CD -> Lambda Expression : No-2");
//        System.out.println("Test CI/CD -> Lambda Expression : No-3");
//
//        Main.testRunnableInt();
        test();
    }

    public static void test(){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(8);
        numbers.add(9);
        numbers.add(2);
        numbers.add(1);
        numbers.add(4);

        numbers.forEach((n) -> {
             System.out.println(n);

        });

        numbers.removeIf(c -> c % 2 == 0);

        System.out.println();

        numbers.forEach(System.out::println);
    }

    public static void testRunnableInt(){
        Runnable runner = () -> {
            int a = 5 * 5;
            System.out.println(a);
            System.out.println();
        };
        runner.run();
    }

    public static void class2Impl(){
        Class2 class2 = new Class2() {
            @Override
            public String get() {
                return "Hello-lambda..";
            }
        };

        System.out.println(class2.get());

        Class2 class21 = () -> {
            return "Hello - lambda 2...";
        };

        System.out.println(class21.get());
    }

    public static void class3Impl(){
        Class3 class3 = new Class3() {
            @Override
            public String calculate(int a, int b) {
                return String.valueOf(a * b);
            }
        };

        System.out.println(class3.calculate(5, 4));

        Class3 class31 = (a,b) -> {
            return  String.valueOf(a * b);
        };

        System.out.println(class31.calculate( 6, 4));
    }

    public static void personImpl(){

        Consumer<Person> personConsumer = new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                if (person.getFirstname().equals("Pierre")){
                    StringBuilder lastname = new StringBuilder(person.getFirstname());
                    System.out.println(lastname.reverse());
                }
                else{
                    System.out.println(person.getFirstname());
                }
            }
        };

        Person person = new Person();
        person.setFirstname("Pierre");
        person.setLastname("Jean");
        personConsumer.accept(person);

        Consumer<Person> personConsumer1 = (p) -> {
            if (p.getFirstname().equals("Pierre")){
                StringBuilder lastname = new StringBuilder(p.getFirstname());
                System.out.println(lastname.reverse());
            }
                else{
                System.out.println(p.getFirstname());
            }
        };

        personConsumer1.accept(person);
    }

    public static void testFunctionInt(){
        Function <Person, String> function = person -> person.getLastname();

        Person person = new Person();
        person.setLastname("Peter Pan");
        person.setFirstname("Zoro");

        System.out.println(function.apply(person));

        Function<Person, String> function1 = (p) -> {
            return p.getLastname();
        };

        System.out.println(function1.apply(person));

    }

    public static  void testPredicateInt(){
        Predicate <Person> personPredicate = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getLastname().equals("Pierre");
            }
        };
        Person person = new Person();
        person.setFirstname("Prince");
        person.setLastname("Pierre");
        personPredicate.test(person);

        Predicate<Person> personPredicate1 = (p) -> {
          return p.getLastname().equals("Pierre");
        };


    }
}