package com.streams;

import java.util.Collection;

public class Artists {
    private String name;
    private String surname;
    private String town;
    private int age;

    public Artists(String name, String surname, String town, int age) {
        this.name = name;
        this.surname = surname;
        this.town = town;
        this.age = age;
    }

    public Artists() {

    }

    public boolean isFrom(String town){
        if(this.town.equalsIgnoreCase(town)){
            return true;
        }else{
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
