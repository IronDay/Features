package com.germanstuff.workshop;

public class Vehicle {
  private String type;
  private String owner;


  public Vehicle(String type, String owner) {
    this.type = type;
    this.owner = owner;
  }

  public Vehicle() {
    this.type = "";
    this.owner = "";
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  @Override
  public String toString() {
    return "Vehicle{" +
            "type='" + type + '\'' +
            ", owner='" + owner + '\'' +
            '}';
  }
}
