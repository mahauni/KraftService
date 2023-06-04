package database.DAO;

import database.connection.DatabaseConnection;
import javaBeans.jbProfile;

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

    public void insert(jbProfile jbProfile) {
        String sql = "INSERT INTO PROFILES(URL, IDPERSON, IDLOCATION) VALUES(?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, jbProfile.getURL());
            stmt.setInt(2, jbProfile.getIdPerson());
            stmt.setInt(3, jbProfile.getIdLocation());

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

    public void update(jbProfile jbProfile) {
        String sql = "UPDATE PROFILES SET IDPERSON=?, IDLOCATION=? WHERE ID=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, jbProfile.getIdPerson());
            stmt.setInt(2, jbProfile.getIdLocation());
            stmt.setString(3, jbProfile.getURL());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<jbProfile> selectAll() {
        List<jbProfile> urls = new ArrayList<>();
        String sql = "SELECT * FROM PROFILES";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                jbProfile jbProfile = new jbProfile();
                jbProfile.setURL(rs.getString("URL"));
                jbProfile.setIdPerson(rs.getInt("IDPERSON"));
                jbProfile.setIdLocation(rs.getInt("IDLOCATION"));

                urls.add(jbProfile);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return urls;
    }

    public jbProfile selectById(int id) {
        jbProfile jbProfile = null;
        String sql = "SELECT * FROM PROFILES WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                jbProfile = new jbProfile();
                jbProfile.setURL(rs.getString("URL"));
                jbProfile.setIdPerson(rs.getInt("IDPERSON"));
                jbProfile.setIdLocation(rs.getInt("IDLOCATION"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jbProfile;
    }
}
