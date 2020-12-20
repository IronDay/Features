package com.streams;

import org.testng.log4testng.Logger;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AnotherStreams {
  private static void overloadedMethod(Object object) {
    System.out.println("Object");
  }

  private static void overloadedMethod(String string) {
    System.out.println("String");
  }

  private static void overloadedMethod(BinaryOperator<Integer> lambda) {
    System.out.println("BinaryOperator");
  }

  private static void overloadedMethod(IntegerBiFunction lambda) {
    System.out.println("IntegerBinaryOperator");
  }

  private static void overloadedMethod(Predicate<Integer> predicate){
    System.out.println("Predicate");
  }

  private static void overloadedMethod(IntPredicate predicate){
    System.out.println("IntPredicate");
  }

  public static void main(String[] args) {
    /*BinaryOperator<Integer> binaryOperator = Integer::sum;
    int sum = binaryOperator.apply(10, 20);
    System.out.println("The sum is : "+ sum);*/
    //overloadedMethod("abc");
    //overloadedMethod((x, y) -> x + y);
    //overloadedMethod((x)->true);

    List<String> list1 = Arrays.asList ("JDK 1.0","J2SE 1.2","J2SE 5.0","J2SE 5.0",
                                        "Java SE 8","Java SE 11","Java SE 14");
    List<Integer> list2 = Arrays.asList(1996,1998,2004,2014,2018,2020);



    List<Person> personList =
        Arrays.asList(
            new Person("Kenny", "Chesney", 25),
            new Person("Keith", "Rowling", 45),
            new Person("Jim", "Steinz", 68),
            new Person("Phil", "MacPherson", 74),
            new Person("Jack", "Weller", 18),
            new Person("Sullivan", "Weller", 16));
    IntSummaryStatistics personAgeStatistics =
        personList.stream().mapToInt(Person::getAge).summaryStatistics();
    System.out.printf(
        "Max: %d, Min: %d, Ave: %.2f, Sum: %d",
        personAgeStatistics.getMax(),
        personAgeStatistics.getMin(),
        personAgeStatistics.getAverage(),
        personAgeStatistics.getSum());

    /*Person oldAgedPerson = personList.stream().max(Comparator.comparing(Person::getAge)).get();
    System.out.println(oldAgedPerson);

    int ageSum = personList.stream().map(Person::getAge).reduce(0, Integer::sum);
    System.out.println(ageSum);

    List<Integer> together =
        Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
            .flatMap(Collection::stream)
            .collect(Collectors.toList());

    together.forEach(System.out::println);*/
  }
}
