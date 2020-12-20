package com.miller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Person {
  private String _name;
  private String _surname;
  private Gender _gender;
  private int _age;
  private static Connection connection;

    {
        try {
      connection = DriverManager.getConnection("jdbc:sqlite:src\\com\\lazygui\\database.db");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public Person(String name, String surname, Gender gender, int age) {
    this._name = name;
    this._surname = surname;
    this._gender = gender;
    this._age = age;
  }

  public Person() {}

  public static boolean savePerson(Person person) throws SQLException {
    String sql = "INSERT INTO person(name, surname, gender, age) VALUES('"+person.get_name()+"','"+person.get_surname()+"','"+person.get_gender()+"','"+person.get_age()+"')";
    Statement stmt = connection.createStatement();

    return stmt.execute(sql);
  }

  public String get_name() {
    return _name;
  }

  public void set_name(String _name) {
    this._name = _name;
  }

  public String get_surname() {
    return _surname;
  }

  public void set_surname(String _surname) {
    this._surname = _surname;
  }

  public Gender get_gender() {
    return _gender;
  }

  public void set_gender(Gender _gender) {
    this._gender = _gender;
  }

  public int get_age() {
    return _age;
  }

  public void set_age(int _age) {
    this._age = _age;
  }

  public static List<Person> getPersons(List<Person> persons) {
    List<Person> result = new ArrayList<Person>();

    for (Person person : persons) {
      if (person.get_age() > 20) {
        result.add(person);
      }
    }

    return result;
  }

  public static List<Person> getPersons() throws SQLException {
    List<Person> result = new ArrayList<Person>();

    String sql = "SELECT * FROM person";
    Statement statement = DriverManager.getConnection("jdbc:sqlite:src\\com\\lazygui\\database.db").createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next())
    {
      result.add(new Person(resultSet.getString("name"),resultSet.getString("surname"),Gender.valueOf(resultSet.getString("gender")),resultSet.getInt("age")));
    }

    return result;
  }

  public static List<Person> getPersonsByCondition(
      List<Person> persons, Condition<Person> condition) {
    List<Person> result = new ArrayList<Person>();
    for (Person person : persons) {
      if (condition.test(person)) {
        result.add(person);
      }
    }

    return result;
  }

  public static List<Person> getPersonsByCondition(Condition<Person> condition) throws SQLException {
    List<Person> result = new ArrayList<Person>();
    List<Person> anotherResults = new ArrayList<>();

    String sql = "SELECT * FROM person";
    Statement statement = DriverManager.getConnection("jdbc:sqlite:src\\com\\lazygui\\database.db").createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next())
    {
      result.add(new Person(resultSet.getString("name"),resultSet.getString("surname"),Gender.valueOf(resultSet.getString("gender")),resultSet.getInt("age")));
    }

    for (Person person : result) {
      if (condition.test(person)) {
        anotherResults.add(person);
      }
    }

    return anotherResults;
  }

  @Override
  public String toString() {
    return "Person{"
        + "_name='"
        + _name
        + '\''
        + ", _surname='"
        + _surname
        + '\''
        + ", _gender="
        + _gender
        + ", _age="
        + _age
        + '}';
  }

  public static void main(String[] args) {
    Person person = new Person("John", "Lafferty", Gender.MALE, 25);
    Person person1 = new Person("James", "Lafferty", Gender.MALE, 35);
    Person person2 = new Person("Lorna", "Campbell", Gender.FEMALE, 35);
    Person person3 = new Person("Jim", "Bake", Gender.MALE, 75);
    Person person4 = new Person("Sullivan", "Weller", Gender.FEMALE, 15);

    List<Person> persons = new ArrayList<Person>();
    persons.add(person);
    persons.add(person1);
    persons.add(person2);
    persons.add(person3);
    persons.add(person4);

    List<Person> results = getPersonsByCondition(persons, Person -> Person.get_age() < 32);
    for (Person result : results) {
      System.out.println(result);
    }

    
    /*List<Person> result =
    getPersonsByCondition(
        persons,
        new Condition<Person>() {
          @Override
          public boolean test(Person person) {
            return person.get_name().equals("James");
          }
        });*/

    /*for (Person personnality : result) {
      System.out.println(personnality);
    }*/

    /*List<Person> result = getPersons(persons);
    for (Person elt : result) {
      System.out.println("Person = " + elt);
    }*/

    /*List<Person> anotherResult = getPersonsByCondition(persons, new YoungerThanCondition(25));
    for (Person retrieve : anotherResult) {
      System.out.println(retrieve);
    }*/
  }
}
