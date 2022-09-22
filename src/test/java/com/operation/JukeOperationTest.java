package com.operation;

import com.data.Songs;
import com.dao.SongsDAO;
import com.dao.ArtistDAO;
import com.dao.PlayListDAO;
import com.dao.GenreDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class JukeOperationTest {
    JukeOperation jukeOperation ;
    ArtistDAO artistDAO;
    GenreDAO genreDAO;
    PlayListDAO playListDAO;
    SongsDAO songsDAO;

    @BeforeEach
    void setUp() {
        jukeOperation = new JukeOperation();
        playListDAO = new PlayListDAO();
        artistDAO = new ArtistDAO();
        songsDAO = new SongsDAO();
        genreDAO = new GenreDAO();
    }

    @AfterEach
    void tearDown() {
        jukeOperation = null;
        artistDAO = null;
        genreDAO = null;
    }

    @Test
    void displayAllSongs() throws SQLException, ClassNotFoundException {
        List<Songs> songsList = jukeOperation.displayAllSongs();
        assertEquals(6,songsList.size());
    }

    @Test
    void searchSongBySongName() throws SQLException, ClassNotFoundException {
        String songName = "Soft Piano Music_16000_mono.wav";
        List<Songs> songsList = jukeOperation.searchSongBySongName(songName);
        assertEquals(1,songsList.size());

    }
    @Test
    void songsOfGenre() throws SQLException, ClassNotFoundException {

        String genreType = "pop";
        List<Songs> songsList = genreDAO.songsOfGenre(genreType);
        assertEquals(1,songsList.size());
    }
    @Test
    void songsOfArtist() throws SQLException, ClassNotFoundException {

        String artistName = "sou";
        List<Songs> songsList = artistDAO.songsOfArtist(artistName);
        assertEquals(2,songsList.size());
    }
    @Test
    void getPathOfSong() throws SQLException, ClassNotFoundException {

        int songID = 4;
        String pathOfTheSong = songsDAO.getPathOfTheSong(songID);
        assertEquals("src/main/resources/Srivalli(PagalWorld.com.se).wav",pathOfTheSong);
    }

}