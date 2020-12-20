package com.germanstuff.consumption;

import java.util.*;

public class Main {
  public static void main(String[] args) {

    Person person  = new Person("Kengni","Jule",25);
    Person person1  = new Person("Jean","Jie",25);
    Person person2  = new Person("Negua","Jule",25);

    ArrayList<Person> personList = new ArrayList<>();

    String name = "John";
    String surname = "John";

    if(name.equals(surname))
    {
      System.out.println("Equals");
    }
    else
    {
      System.out.println("different");
    }

    /*personList.add(person);
    personList.add(person1);
    personList.add(person2);*/

    Iterator<Person> iter = personList.iterator();
    while(iter.hasNext())
    {
      System.out.println(iter.next());
    }

    /*ListIterator<Person> listIterator = personList.listIterator();
    while(listIterator.hasPrevious())
    {
      System.out.println(listIterator.next());
    }*/

  }
}
