/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polpetta.exam_lug_server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

@WebService(endpointInterface = "it.polpetta.exam_lug_server.WS_IFace")
public class WS_Impl implements WS_IFace{
    
    private Connection connection = null;
    
    public WS_Impl() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:/home/biar/msecs-1-se-2019_07.db");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    @Override
    public String getMovie(int id){
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM MOVIES WHERE ID = ?;");
            statement.setInt(1, id);
            statement.setQueryTimeout(30);
            
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                String result = "["+rs.getInt("ID")+","+
                        rs.getString("directorID")+","+
                        rs.getString("title")+","+
                        rs.getString("year")+"]";
                return result;                
            } else {
                return null;
            }
        } catch(SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }    
    }
    
    @Override
    public List<String> listMovies() {
        ArrayList<String> movies = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            ResultSet rs = statement.executeQuery("SELECT * FROM MOVIES;");
            while(rs.next()) {
                String movie = "["+rs.getInt("ID")+","+
                    rs.getString("directorID")+","+
                    rs.getString("title")+","+
                    rs.getString("year")+"]";
                movies.add(movie);
            }
            return movies;
        } catch(SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    @Override
    public String getDirector(int id){
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM DIRECTORS WHERE ID = ?;");
            statement.setInt(1, id);
            statement.setQueryTimeout(30);

            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                String result = "["+rs.getInt("ID")+","+
                        rs.getString("name")+","+
                        rs.getString("yearOfBirth")+"]";
                return result;
            } else {
                return null;
            }
        } catch(SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        
    }
    
    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
                System.err.println(e);
        }
    }    
}
