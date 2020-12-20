package com.streams.exercise;

import com.streams.Album;
import com.streams.Artists;
import com.streams.Tracks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CommonStream {
  public static int addUp(Stream<Integer> numbers) {
    return numbers.reduce(0, (acc, element) -> acc + element);
  }

  public static List<String> artistConcat(Stream<Artists> artistsStream) {
    return artistsStream
        .map(artists -> artists.getName() + " " + artists.getTown())
        .collect(Collectors.toList());
  }

  public static List<Tracks> listOfAlbums(Stream<Album> artistsStream) {
    return artistsStream
        .flatMap(album -> album.getTrack())
        .filter(tracks -> tracks.getLength() < 3)
        .collect(Collectors.toList());
  }

  public static void main(String[] args) {

    /*Method to find the string with the largest lowercase letters in the string liste*/
    List<String> stringList = new ArrayList<>();
    stringList.add("John");
    stringList.add("is leaving");
    stringList.add("right now");
    stringList.add("to London");

   /*Optional<String> counter = stringList*/
    /* Method to count the number of lowercase character inside a given string with new java feature rules*/
    /*Old fashion method procedure*/
    String string = "John is a honest man";
    int count = 0;
    for (char elt:string.toCharArray()){
      if(Character.isLowerCase(elt)){
        ++count;
      }
    }
    /*end of the old fashion procedure*/

    long upperCount = string.chars()
                            .filter(elt->Character.isLowerCase(elt))
                            .count();

    System.out.println(upperCount);
/*end of the method*/
    /* ArrayList<Artists> artistsMembers = new ArrayList<>();
      artistsMembers.add(new Artists("Jil","Vicente","Havana",30));
      long totalMembers = artistsMembers.stream()
                                       .count();

    System.out.println(totalMembers);*/
    /*ArrayList<Integer> arrayList = new ArrayList<>();
    arrayList.add(120);
    arrayList.add(12);
    arrayList.add(10);*/

    /*System.out.println(addUp(arrayList.stream()));*/

    /*Artists artists1 = new Artists("Kenny", "Chesney", "Memphis", 50);
    Artists artists2 = new Artists("Luke", "Combs", "Raleigh", 40);
    Artists artists3 = new Artists("Sean", "Paul", "Kingston", 42);
    Artists artists4 = new Artists("Sean", "Garrett", "Nashville", 32);
    Artists artists5 = new Artists("Justin", "Timberlake", "Cincinnati", 37);
    Artists artists6 = new Artists("The Band", "Perry", "Palo Alto", 20);

    List<Artists> artistsList = new ArrayList<>();
    artistsList.add(artists1);
    artistsList.add(artists2);
    artistsList.add(artists3);
    artistsList.add(artists4);
    artistsList.add(artists5);
    artistsList.add(artists6);*/

    /*artistConcat(artistsList.stream()).forEach(System.out::println);*/

    /*Album album1 = new Album(new Tracks("I go back", 14), artists1);
    Album album2 = new Album(new Tracks("Hurricane", 33), artists2);
    Album album3 = new Album(new Tracks("She doesn't know", 44), artists3);
    Album album4 = new Album(new Tracks("God is great", 54), artists4);
    Album album5 = new Album(new Tracks("Can't stop the feeling", 64), artists5);
    Album album6 = new Album(new Tracks("If i die young", 84), artists6);

    List<Album> allAlbums = new ArrayList<Album>();
    allAlbums.add(album1);
    allAlbums.add(album2);
    allAlbums.add(album3);
    allAlbums.add(album4);
    allAlbums.add(album5);
    allAlbums.add(album6);

    List<Album> leastThreeAlbums = new ArrayList<>();

    allAlbums.stream()
        .forEach(
            album -> {
              album
                  .getTracks()
                  .forEach(
                      tracks -> {
                        if (tracks.getLength() < 50) {
                          leastThreeAlbums.add(album);
                        }
                      });
            });

    leastThreeAlbums.forEach(album -> album.getTracks().forEach(tracks -> System.out.println(tracks.getName())));*/

    /*for (Album album : allAlbums) {
      for (Tracks tracks : album.getTracks()) {
        if (tracks.getLength() < 32) {
          leastThreeAlbums.add(album);
        }
      }
    }

    leastThreeAlbums.forEach(
        album -> album.getTracks().forEach(tracks -> System.out.println(tracks.getName())));*/
  }
}
