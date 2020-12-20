package com.germanstuff;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Suppliers {
  private ArrayList<Consumers> customersList;
  private String supplierName;

  public Suppliers(String supplierName) {
    this.supplierName = supplierName;
    customersList = new ArrayList<>();
  }

  /*public void CaptureConsumers(Consumers consumer)
  {
      customersList.add(consumer);
  }*/

  public boolean CaptureConsumers(Consumers consumer) {
    /*if (customersList.add(consumer))
    {
        return true;
    }
    else
    {
        return false;
    }*/

    return customersList.add(consumer);
  }

  public void recordCustomers(String name, double consumption) {
    Consumers consumer = new Consumers(name, consumption);
    customersList.add(consumer);
    // CaptureConsumers(consumer);
  }

  /**
   * @param consumer
   * @return boolean
   */
  public boolean RemoveConsumer(Consumers consumer) {
    return customersList.remove(consumer);
  }

  public boolean removeConsumer(String name) {
      Iterator<Consumers> iterator = customersList.iterator();
      String clientName = null;
      boolean result = false;

      while (iterator.hasNext())
      {
          clientName = iterator.next().getName();
          if (clientName.equals(name))
          {
              iterator.remove();
              result = true;
          }
      }

      return result;
    /*Iterator<Consumers> iterator = customersList.iterator();
    boolean result = false;

    while (iterator.hasNext()) {
      if (iterator.next().getName().equals(name)) {
        iterator.remove();
        result = true;
      }
    }
    return result;*/
  }

  public void druckeListe() {
    for (Consumers consumer : customersList) {
      System.out.println(
          "Name: " + consumer.getName() + " , Consumption: " + consumer.getConsumption());
    }
  }

  public void leereListe() {
    customersList.clear();
  }

  public double totalConsumption() {
    double allConsumption = 0.0;
    for (Consumers consumer : customersList) {
      allConsumption += consumer.getConsumption();
    }

    return allConsumption;
  }

  public double maxConsumption() {
    Iterator<Consumers> iter = customersList.iterator();
    double max = 0.0;

    while (iter.hasNext()) {
      if (iter.next().getConsumption() > max) {
        max = iter.next().getConsumption();
      }
    }

    return max;
  }

  public double minConsumption() {
    Iterator<Consumers> iter = customersList.iterator();
    double min = customersList.get(0).getConsumption();

    while (iter.hasNext()) {
      if (iter.next().getConsumption() < min) {
        min = iter.next().getConsumption();
      }
    }

    return min;

    /*double min = customersList.get(0).getConsumption();

    for (int i = 0; i != customersList.size(); i++) {
      if (customersList.get(i).getConsumption() < min) {
        min = customersList.get(i).getConsumption();
      }
    }

    return min;*/
    /*ListIterator<Consumers> iter = customersList.listIterator();
    double min = customersList.get(0).getConsumption();

    while(iter.hasNext())
    {
      if (iter.next().getConsumption() < min)
      {
        min = iter.previous().getConsumption();
      }
    }

    return min;*/
  }

  double meanOfConsumption() {
    return totalConsumption() / customersList.size();
  }

  Consumers maximalConsumers() {
    Consumers consumers = customersList.get(0);
    for (int iter = 0; iter != customersList.size(); ++iter) {
      if (customersList.get(iter).getConsumption() > consumers.getConsumption()) {
        consumers = customersList.get(iter);
      }
    }

    return consumers;
  }

  Consumers minimalConsumers() {
    Consumers consumers = customersList.get(0);
    for (int iter = 0; iter != customersList.size(); ++iter) {
      if (customersList.get(iter).getConsumption() < consumers.getConsumption()) {
        consumers = customersList.get(iter);
      }
    }

    return consumers;
  }
}
