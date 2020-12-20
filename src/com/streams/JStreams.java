package com.streams;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;

public class JStreams {
  public static void main(String[] args) {
    Album album1 = new Album(new Tracks("I go back",14),new Artists("Kenny","Chesney","Memphis",50));
    Album album2 = new Album(new Tracks("Hurricane",33),new Artists("Luke","Combs","Raleigh",40));
    Album album3 = new Album(new Tracks("She doesn't know",44),new Artists("Sean","Paul","Kingston",42));
    Album album4 = new Album(new Tracks("God is great",54),new Artists("Sean","Garrett","Nashville",32));
    Album album5 = new Album(new Tracks("Can't stop the feeling",64),new Artists("Justin","Timberlake","Cincinnati",37));
    Album album6 = new Album(new Tracks("If i die young",84),new Artists("The Band","Perry","Palo Alto",20));


    List<Album> allAlbums = new ArrayList<Album>();
    allAlbums.add(album1);
    allAlbums.add(album2);
    allAlbums.add(album3);
    allAlbums.add(album4);
    allAlbums.add(album5);
    allAlbums.add(album6);

    Set<String> trackNames = allAlbums.stream()
             .flatMap(album -> album.getTrack())
             .filter(tracks -> tracks.getLength()<60)
             .map(tracks -> tracks.getName())
             .collect(Collectors.toSet());
             /*.forEach(name->trackNames.add(name));*/
        /*.forEach(
            album -> {
              album
                  .getTrack()
                  .filter(tracks -> tracks.getLength() > 60)
                  .map(tracks -> tracks.getName().toUpperCase())
                  .forEach(tracks -> trackNames.add(tracks));*/
              /*.forEach(tracks->{
                if(tracks.getLength()<60){
                  trackNames.add(tracks.getName());
                }
              });
            });*/

    trackNames.forEach(System.out::println);

    /*Set<String> origins = album1.getMusicians()
                                .filter(artists -> artists.getName().startsWith("Ken"))
                                .map(artists -> artists.getTown())
                                .collect(Collectors.toSet());

    origins.forEach(System.out::println);*/
    /*ArrayList<Artists> allArtists = new ArrayList<Artists>();
    allArtists.add(new Artists("John", "Kirk", "London", 25));
    allArtists.add(new Artists("Abraham", "Ridley", "Colorado Springs", 25));
    allArtists.add(new Artists("Kim", "Manslow", "Houston", 45));
    allArtists.add(new Artists("Kenny", "Chesney", "Memphis", 50));
    allArtists.add(new Artists("John", "Letton", "London", 65));
    allArtists.add(new Artists("Florida", "Georgia", "Atlanta", 30));

    long count = allArtists.stream().filter(e -> e.isFrom("London")).count();

    List<String> begNumber =
        Stream.of("a", "b", "12Hello")
            .filter(string -> Character.isDigit(string.charAt(0)))
            .collect(Collectors.toList());

    List<Integer> togetherNumber =
        Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4, 5))
            .flatMap(number -> number.stream())
            .collect(Collectors.toList());
    Artists youngestArtist =
        allArtists.stream().min(Comparator.comparing(artists -> artists.getAge())).get();

    int result = Stream.of(1, 2, 3, 4).reduce(1, (acc, element) -> acc * element);

    BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;

    int accResult = accumulator.apply(1,accumulator.apply(2,accumulator.apply(3,4)));
    int accResult = accumulator.apply(accumulator.apply(1, 2), accumulator.apply(3, 4));

    assertEquals(10, accResult);
    assertEquals(24, result);
    assertEquals("John", youngestArtist.getName());
    assertEquals(Arrays.asList("12Hello"), begNumber);
    assertEquals(Arrays.asList(1, 2, 3, 4, 5), togetherNumber);

    begNumber.forEach(System.out::println);*/

    /*allArtists.stream()
    .filter(artists -> {
      System.out.println(artists.getSurname());
      return artists.isFrom("Atlanta");
    });*/

    /*List<String> upperArtist = allArtists.stream()
                                         .filter(artists -> artists.isFrom("Houston") || artists.isFrom("Memphis"))
                                         .map(artists -> (artists.getSurname()+" "+artists.getName()).toUpperCase())
                                         .collect(Collectors.toList());

    upperArtist.forEach(System.out::println);

    System.out.println(count);*/
  }
}
