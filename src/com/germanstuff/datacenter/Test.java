package com.germanstuff.datacenter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Test {
  public static void main(String[] args) {
   HashMap<String,Long> hashMap = new HashMap<String,Long>();
   hashMap.put("Bosco",33695284L);
   hashMap.put("Bosco",3369527894L);

   Set<Integer> number = new HashSet<Integer>();
   number.add(1);
   number.add(1);
   number.add(1);
   number.add(1);

    System.out.println("size "+ number.size());

   HashMap<String,String> phoneBoook = new HashMap();
   phoneBoook.put("first","Jill");
   phoneBoook.put("second","Jill");

   int a = 20;
   String stringA = String.valueOf(a);

   //short b =25;
   int value = Integer.parseInt(stringA);

   for(int i = 0 ; i != phoneBoook.size(); ++i){
      System.out.println(phoneBoook.get(i));
   }

    System.out.println(phoneBoook.get(1));
    System.out.println(hashMap.get("Bosco"));
  }
}
