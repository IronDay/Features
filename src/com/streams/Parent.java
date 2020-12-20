package com.streams;

public interface Parent {
  public void message(String body);

  public default void welcome() {
    System.out.println("Parent: Hi!");
  }

  public void getLastMessage();
}
