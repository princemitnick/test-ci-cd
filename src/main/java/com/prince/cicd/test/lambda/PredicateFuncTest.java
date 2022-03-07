package com.prince.cicd.test.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class PredicateFuncTest {

    public static void main(String... args){
        test2();
    }

    public static void test1(){
        List<String> strings = new ArrayList<>(List.of(
                "one",
                "two",
                "three",
                "four",
                "five"
        ));

        Predicate<String> filter = string -> string.startsWith("f");
        strings.removeIf(filter);



    }

    public static void test2(){
        List<String> strings = new ArrayList<>(List.of(
                "one",
                "two",
                "three",
                "four",
                "five"
        ));

        strings.removeIf((c) -> c.startsWith("t"));
        strings.forEach(c -> {
            if (c.startsWith("o")){
                System.out.println(c.toUpperCase());
            }
            else
                System.out.println(c);
        });

    }
}
