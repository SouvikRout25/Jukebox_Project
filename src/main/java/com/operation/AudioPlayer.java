package com.operation;

import com.data.Songs;
import com.main.Implementation;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AudioPlayer {
    List<Songs> songslist;
    int songIndex;

    public void PlaySong(List<Songs> songslist) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        Scanner scanner = new Scanner(System.in);
        this.songslist = songslist;
        for (int i = 0; i < songslist.size(); i++) {
            songIndex = i;
            PlaySong(songslist.get(i).getSongPath());
        }

    }

    public void PlaySong(String songPath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {


        Scanner scanner = new Scanner(System.in);
        try {
            File file = new File(songPath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            String response = " ";

            while (!response.equals("Q")) {
                System.out.println("P = play, T= Pause, S=Stop, L=Loop, R = Reset, Q = Quit,N = NextSong,O = previousSong,M = MAIN MENU");
                System.out.print("Enter your choice: ");

                response = scanner.next();
                response = response.toUpperCase();


                switch (response) {
                    case ("P"): {
                        clip.start();
                        break;
                    }
                    case ("T"): {
                        clip.stop();
                        break;
                    }
                    case ("S"): {
                        clip.setMicrosecondPosition(0);
                        clip.stop();
                        break;
                    }
                    case ("L"): {
                        clip.start();
                        clip.loop(Clip.LOOP_CONTINUOUSLY);
                    }

                    case ("R"):
                        clip.setMicrosecondPosition(0);
                        break;

                    case ("Q"):
                        clip.close();
                        break;
                    case ("N"):
                        if (songslist != null && songslist.size() != 0 && songIndex < songslist.size() - 1) {
                            clip.close();
                            songIndex += 1;
                            PlaySong(songslist.get(songIndex).getSongPath());
                        } else {
                            System.out.println("not possible");
                        }
                        break;
                    case ("O"):
                        if (songslist != null && songslist.size() != 0) {
                            clip.close();
                            songIndex = 0;
                            PlaySong(songslist.get(songIndex).getSongPath());
                        } else {
                            System.out.println("not possible");
                        }
                        break;
                    case ("M"):
                        String[] arg = new String[0];
                        Implementation.main(arg);
                        break;

                    default:
                        System.err.println("PLEASE SELECT THE CORRECT OPTION");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}