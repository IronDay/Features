package com.germanstuff.workshop;

import java.util.Arrays;

public class Workshop {
  private final Vehicle[] place;
  private final int available;

  public Workshop(int placeAvailable) {
    this.place = new Vehicle[placeAvailable];
    this.available = placeAvailable;
  }

  public int registerVehicle(Vehicle vehicle) {
    int location = 0;
    if (!full()) {
      if (gibPlatz(vehicle) != -1) {
        System.out.println("Registration failed");
        return -1;
      }

      location = this.freeSpace();
      place[location] = vehicle;
      System.out.println("Vehicle registered");
    }
    return location;
  }

  public int deregisterVehicle(Vehicle vehicle) {
    for (int index = 0; index != place.length; ++index) {
      if (place[index] == vehicle) {
        place[index] = null;
        System.out.println("Vehicle de-registered");
        return index;
      }
      // break;
    }

    return -1;
  }

  public void printArray() {
    for (int index = 0; index != getSize(); ++index) {
      if (place[index] != null) {
        System.out.println(
            "Location: "
                + index
                + "; Vehicle[Type: "
                + place[index].getType()
                + ", Owner: "
                + place[index].getOwner()
                + "]");
      }
    }
  }

  public Vehicle[] getPlaces() {
    return place;
  }

  private boolean[] DetermeBeigung() {
    boolean[] result = new boolean[available];
    int index = 0;
    for (Vehicle vehicle : place) {
      if (vehicle != null) {
        result[index] = true;
        ++index;
      }

      result[index] = false;
    }

    return result;
  }

  public void determine() {
   // boolean[] result = DetermeBeigung();
    int placeNumber = 0;
    for (boolean elt : DetermeBeigung()) {
      if (elt) {
        ++placeNumber;
      }
    }

    System.out.println("Place allocated: " + placeNumber);
  }

  private int gibPlatz(Vehicle vehicle) {
    for (int iter = 0; iter != place.length; ++iter) {
      if (place[iter] == vehicle) {
        return iter;
      }
      break;
    }

    return -1;
  }

  private int freeSpace() {
    for (int index = 0; index != place.length; ++index) {
      if (place[index] == null) {
        return index;
      }
      // break;
    }
    return -1;
  }

  private int getSize() {
    int size = 0;
    for (Vehicle vehicle : place) {
      if (vehicle != null) {
        ++size;
      }
    }
    return size;
  }

  private boolean full() {
    /*if (place.length == available) {
      return true;
    } else {
      return false;
    }*/
    return getSize() == available;
  }

  public static void main(String[] args) {
    Vehicle f1 = new Vehicle("VW-Passat", "Jan");
    Vehicle f2 = new Vehicle("Merc-B-200", "Tobias");
    Vehicle f3 = new Vehicle("VW-UP", "Chris");
    Vehicle f4 = new Vehicle("5er-BMW", "Nele");
    Vehicle f5 = new Vehicle("Merc-CLK", "Anne");
    Vehicle f6 = new Vehicle("Audi-A3", "Ziad");

    Workshop workshop = new Workshop(11);

    workshop.registerVehicle(f1);
    workshop.registerVehicle(f2);
    workshop.registerVehicle(f3);
    workshop.registerVehicle(f1);

    workshop.determine();

    /*System.out.println("-------- First registration process ---------");

    workshop.printArray();

    System.out.println();
    System.out.println();

    System.out.println("------ Registration of f4 and f5 ----------");

    workshop.registerVehicle(f4);
    workshop.registerVehicle(f5);

    System.out.println("--------- After f4 and f5 ------------");

    workshop.printArray();

    System.out.println();
    System.out.println();

    workshop.deregisterVehicle(f2);
    workshop.registerVehicle(f5);
    workshop.deregisterVehicle(f3);
    workshop.deregisterVehicle(f6);

    System.out.println();
    System.out.println("-----After deregistration-----");

    workshop.printArray();*/
  }
}
