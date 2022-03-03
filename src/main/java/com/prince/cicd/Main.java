package com.prince.cicd;

import com.prince.cicd.test.lambda.Supplier;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String... args){

        Supplier<String> supplier = () -> "Test CI/CD";
        System.out.println(supplier.get());

    }

    public static void test(){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(8);
        numbers.add(9);
        numbers.add(2);
        numbers.add(1);

        numbers.forEach((n) -> {
            if(n % 2 == 0){
                System.out.println(n);
            }
        });
    }
}