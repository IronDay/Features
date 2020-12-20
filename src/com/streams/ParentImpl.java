package com.streams;

public class ParentImpl implements Parent {
  @Override
  public void message(String body) {
    System.out.println("Hello,my message says: " + body);
  }

  @Override
  public void getLastMessage() {
    System.out.println("My last message");
  }
}
