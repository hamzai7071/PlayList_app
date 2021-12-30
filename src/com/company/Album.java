package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

// Naming of album and the singer along with the array of playlist
public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    //Constructors
    public Album(String name, String artist ) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>() ;
    }
    public Song findSong(String title){
        for(Song checkedSong:songs) {
            if (checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;
        

    }


    //Adding playlist in the Album by creating new function
    // Making boolean function for adding playlist

    public boolean addSong(String title, double duration){

        // We will create the findSong method in down to check the playlist
        if(findSong(title) == null ){
            // adding
            songs.add(new Song(title,duration) );
            System.out.println(title + "susccess-fully added");
            return true;
        }
        else {
            System.out.println("Song with name " + title + "Already exits");
            return false;
        }
    }

    // Adding song to playlist and song must be in the play list by using LinkedList
    // It will add the songs from array list to created index list.

    public boolean addPlayList(int trackNumber, LinkedList<Song> PlayList  ){
        int index = trackNumber - 1;
        if(index> 0 && index <= this.songs.size()){
            PlayList.add(this.songs.get(index));
            return true;
        }
        System.out.println("this album does not have songs with tracknumber " + trackNumber  );
        return false;
    }
    public boolean addToPlaylist(String title,LinkedList<Song> PlayList ){
        //checking if song is in album
        for(Song checkedSong: this.songs) {
            if (checkedSong.getTitle().equals(title)) {
                PlayList.add(checkedSong);
                return true;
            }
        }
        System.out.println(title + "No songs in album");
        return false;
        }

    }
