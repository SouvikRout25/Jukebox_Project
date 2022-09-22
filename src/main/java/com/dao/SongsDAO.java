package com.dao;
import com.data.Songs;
import com.connection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SongsDAO {
    public String getPathOfTheSong(int songId) throws ClassNotFoundException, SQLException {

        Connection connection = DBConnection.getConnection();
        String sql = "SELECT SongName from songs where songId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, songId);
        ResultSet resultSet = preparedStatement.executeQuery();
        String songPath = null;
        if (resultSet.next()) {
            songPath= "src/main/resources/";
            songPath += resultSet.getString(1);
        }

        return songPath;
    }
}
