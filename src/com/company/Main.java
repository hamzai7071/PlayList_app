package com.company;

import javax.xml.namespace.QName;
import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Album", "AC/DC");

        album.addSong("TNT", 4.5);
        album.addSong("highway to hell", 3.0);
        album.addSong("thunderStruck", 5.0);
        albums.add(album);

        album = new Album("Albums", "Eminem");

        album.addSong("Rap", 4.5);
        album.addSong("Not Afraid", 3.5);
        album.addSong("Lose yourself", 4.5);
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlaylist("TNT", playList_1);
        albums.get(0).addToPlaylist("HighWay to hell", playList_1);
        albums.get(1).addToPlaylist("Rap", playList_1);
        albums.get(1).addToPlaylist("Lose Yourself", playList_1);
        play(playList_1);

    }

    private static void play(LinkedList<Song>playlist){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();

        if(playlist.size() == 0 ){
            System.out.println("This playlist has no song"  );
        }
        else {
            System.out.println("now playing" + listIterator.next().toString());
            printMenu();
        }
        while (!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {

                case 0:
                    System.out.println("playlist complete");
                    quit = true;
                    break;

                case 1:
                    if (!forward){
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                }
                if (listIterator.hasNext()) {
                    System.out.println("now playing" + listIterator.next().toString());
                } else {
                    System.out.println("not song availble");
                    forward = false;
                }
                break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) ;
                        listIterator.previous();
                    }
                    forward = false;
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("we are the first song");
                        forward = false;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of ths list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing" + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;

                case 4:
                    printList(playlist);
                    break;

                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playlist.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing" + listIterator.next().toString());
                            forward = true;

                        }
                        else {
                            if(listIterator.hasPrevious())
                            System.out.println("Playing song " +listIterator.previous().toString());
                        }
                    }
            }
        }
    }
    // Giving acces to user for the playlist
    private static void printMenu(){
        System.out.println("Available option\n press");
        System.out.println("0- to quit\n"+
                "-1 - to play next song \n" +
                "-2 - to play previous song \n"+
                "-3 - to replay the cureent song\n"+
                "-4 - list of all songs \n"+
                "-5 - print all availble options\n"+
                "-6 - delete the current song");

    }
    //itrating the playlist
    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("--------------" );

        while (iterator.hasNext()){
            System.out.println(iterator.hasNext());
        }
        System.out.println("-----------");
    }
}
