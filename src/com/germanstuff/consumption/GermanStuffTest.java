package com.germanstuff;

public class GermanStuffTest {
  public static void main(String[] args) {
    Consumers cons1 = new Consumers("Markus", 125.05);
    Consumers cons2 = new Consumers("Kiel", 25.50);
    Consumers cons3 = new Consumers("Herbert", 170.15);
    Consumers cons4 = new Consumers("Ralph", 145.50);

    Suppliers suppliers = new Suppliers("RWE");
    suppliers.CaptureConsumers(cons1);
    suppliers.CaptureConsumers(cons2);
    suppliers.CaptureConsumers(cons3);
    suppliers.CaptureConsumers(cons4);

    suppliers.recordCustomers("July",350);

    suppliers.removeConsumer("Ralph");

    suppliers.druckeListe();

    /*System.out.println("------ Consumers One ------");

    System.out.println("Name of the first consumers: " + cons1.getName());
    System.out.println("The consumption of the first consumers: " + cons1.getConsumption());

    System.out.println("------ Consumers Two ------");

    System.out.println("Name of the second consumers: " + cons2.getName());
    System.out.println("The consumption of the second consumers: " + cons2.getConsumption());

    System.out.println();

    System.out.println("----- Supplier Test ------");

    Suppliers supplier = new Suppliers("RWE");

    if (supplier.CaptureConsumers(cons1)
        && supplier.CaptureConsumers(cons2)
        && supplier.CaptureConsumers(cons3)
        && supplier.CaptureConsumers(cons4))
    {
      System.out.println("Ajoute avec succes");
    } else {
      System.out.println("Problem");
    }*/

    /*if (supplier.CaptureConsumers(cons2)) {
      System.out.println("Succeed !!");
    } else {
      System.out.println("Problem");
    }*/

    /*if(supplier.RemoveConsumer(cons2))
    {
      System.out.println(cons2.getName() + " has been removed successfully");
    }
    else{
      System.out.println("problem");
    }*/

    /*System.out.println("Max: " + supplier.maxConsumption());
    System.out.println("Min: " + supplier.minConsumption());
    System.out.println("Mean: " + supplier.meanOfConsumption());

    System.out.println("Maximal Consumers: " + supplier.maximalConsumers().toString());
    System.out.println("Minimal Consumers: " + supplier.minimalConsumers().toString());*/
    //supplier.removeConsumer("Ralhp");

    //supplier.druckeListe();
    //supplier.druckeListe();

    //supplier.leereListe();
  }
}
