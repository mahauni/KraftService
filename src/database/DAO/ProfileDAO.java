package database.DAO;

import database.connection.DatabaseConnection;
import javaBeans.Profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfileDAO {
    private static Connection connection;

    public ProfileDAO() throws SQLException {
        connection = DatabaseConnection.connect();
    }

    public void insert(Profile profile) {
        String sql = "INSERT INTO PROFILES(URL, IDPERSON, IDLOCATION) VALUES(?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, profile.getURL());
            stmt.setInt(2, profile.getIdPerson());
            stmt.setInt(3, profile.getIdLocation());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        String sql = "DELETE FROM PROFILES WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Profile profile) {
        String sql = "UPDATE PROFILES SET IDPERSON=?, IDLOCATION=? WHERE ID=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, profile.getIdPerson());
            stmt.setInt(2, profile.getIdLocation());
            stmt.setString(3, profile.getURL());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Profile> selectAll() {
        List<Profile> urls = new ArrayList<>();
        String sql = "SELECT * FROM PROFILES";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Profile profile = new Profile();
                profile.setURL(rs.getString("URL"));
                profile.setIdPerson(rs.getInt("IDPERSON"));
                profile.setIdLocation(rs.getInt("IDLOCATION"));

                urls.add(profile);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return urls;
    }

    public Profile selectById(int id) {
        Profile profile = null;
        String sql = "SELECT * FROM PROFILES WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                profile = new Profile();
                profile.setURL(rs.getString("URL"));
                profile.setIdPerson(rs.getInt("IDPERSON"));
                profile.setIdLocation(rs.getInt("IDLOCATION"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profile;
    }
}
