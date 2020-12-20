package com.miller;

public class YoungerThanCondition implements Condition<Person> {
  private final int _age;

  public YoungerThanCondition(int age) {
    this._age = age;
  }

  @Override
  public boolean test(Person person) {
    return person.get_age() > _age;
  }
}
