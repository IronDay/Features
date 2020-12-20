package com.germanstuff.datacenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class User {
  private final HashMap<String, String> accounts = new HashMap<>();
  //public static int count = 0;

  public void createAccount(String name, String matriculation, String password) {
    accounts.put(createID(name, matriculation), password);
    //++count;
  }

  public String getPassword(String identifier) {
    if (accounts.containsKey(identifier)) {
      return accounts.get(identifier);
    }
    return null;
  }

  public String printInfos(String identifier) {
    if (accounts.containsKey(identifier)) {
      return (identifier + " , " + accounts.get(identifier));
    }

    return null;
  }

  public void printAccounts() {
    for (String ids : accounts.keySet()) {
      System.out.println(ids);
    }
  }

  public void printPasswords() {
    for (String password : accounts.values()) {
      System.out.println(password);
    }
  }

  public void printAllInfos() {
    for (String id : accounts.keySet()) {
      System.out.println(id + " ==> " + accounts.get(id));
    }
  }

  public ArrayList<String> getAccounts() {
    ArrayList<String> keys = new ArrayList<>();
    for (String id : accounts.keySet()) {
      keys.add(id);
    }

    return keys;
  }

  public ArrayList<String> getPasswords() {
    ArrayList<String> passList = new ArrayList<String>();
    for (String password : accounts.values()) {
      passList.add(password);
    }
    return passList;
  }

  private String createID(String name, String matriculation) {
    return matriculation.substring(0,3) + name.substring(0,3);
  }

  public static void test(){
    User user = new User();
    user.createAccount("Florian","199820","fleche");
    user.createAccount("Bosco","199624","bourdin");

    System.out.println("-----Accounts----------");

    System.out.println("Password: " + user.getPassword("199Flo"));
    System.out.println("infos: " + user.printInfos("199Flo"));

    System.out.println("--------- All accounts ----------");
    for (String elt : user.getAccounts()){
      System.out.println(elt);
    }

    System.out.println("--------- All passwords ----------");
    for (String pass : user.getPasswords()){
      System.out.println(pass);
    }

    System.out.println("------------ All accounts infos --------------");
    user.printAllInfos();


  }

  public static void main(String[] args) {
    User.test();
  }
}
