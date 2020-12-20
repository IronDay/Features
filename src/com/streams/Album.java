package com.streams;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Album{
    private List<Artists> artists = new ArrayList<>();
    private List<Tracks> track = new ArrayList<>();

    public Album(Tracks track,Artists artists) {
        this.track.add(track);
        this.artists.add(artists);
    }

    public Album(){

    }

    public List<Tracks> getTracks(){
        return  track;
    }
    public Stream<Artists> getMusicians(){
        return this.artists.stream();
    }

    public Stream<Tracks> getTrack() {
        return track.stream();
    }

    public void setTrack(List<Tracks> track) {
        this.track = track;
    }

    public List<Artists> getArtists() {
        return artists;
    }

    public void setArtists(List<Artists> artists) {
        this.artists = artists;
    }
}
