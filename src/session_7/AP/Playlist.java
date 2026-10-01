package session_7.AP;

import java.util.Arrays;

public class Playlist {
    private String[] songs;
    private int songCount;

    Playlist(int maxSize) {
        songs = new String[maxSize];
        songCount = 0;
    }

    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        } else {
            System.out.println("Playlist is full.");
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }
}

public class Main {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        System.out.println("Songs in playlist:");
        for (String song : copy) {
            System.out.println(song);
        }

        // Changing the copy
        copy[0] = "Hacked";

        System.out.println("\nAfter modifying the returned copy:");
        for (String song : p.getSongs()) {
            System.out.println(song);
        }

        System.out.println("\nSong count: " + p.getSongCount());
    }
}