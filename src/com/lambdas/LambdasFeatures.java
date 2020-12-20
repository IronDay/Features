package com.lambdas;

import java.util.concurrent.Semaphore;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdasFeatures {
  static int ressource = 0;
  private static void incre(){
    ++ressource;
  }

  private static void decre(){
    --ressource;
  }

  public static void main(String[] args) throws InterruptedException {
    /*Predicate<Integer> atLeast5 = x -> x > 5;
    BinaryOperator<Long> addLongs = (x, y) -> x - y;
    BinarySum<Double> binSum = (x, y) -> x > y ? x : y;

    Function<Integer, Double> calc = (x) -> (double) x / 6;
    Function<Integer, Boolean> testCalc = (x) -> x == 5;

    System.out.println(atLeast5.test(25));
    System.out.println(addLongs.apply(20L, 10L));
    System.out.println(binSum.compare(26d, -15d));
    System.out.println(calc.apply(25));
    System.out.println(testCalc.apply(25));*/

    /*Runnable helloRunnable =
        () -> {
          int count = 10;
          while (count > 0) {
            System.out.println(count);
            --count;
            try {
              Thread.sleep(1000);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        };

    Thread thread = new Thread(helloRunnable);
    thread.start();
    thread.join();*/


    Runnable incRunnable=()->{
      int count = 0;
      while (count <= 10){
        incre();
        count++;
      }

      /*try{
        Thread.sleep(10000);
      }catch (InterruptedException e){
        e.printStackTrace();
      }*/
    };

    Runnable decreRunnable=()->{
      int count = 0;
      while (count < 10){
        decre();
        count++;
      }

      /*try{
        Thread.sleep(10000);
      }catch (InterruptedException e){
        e.printStackTrace();
      }*/
    };


    Thread t1 = new Thread(incRunnable);
    Thread t2 = new Thread(decreRunnable);

    t1.start();
    t2.start();

    t1.join();
    t2.join();

    System.out.println(ressource);
  }
}
