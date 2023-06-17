package br.com.ese.esgManager.database.DAO;

// fix this because we have one more camp to fill

import br.com.ese.esgManager.database.connection.DatabaseConnection;
import br.com.ese.esgManager.javaBeans.jbLocation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationDAO {
    private static Connection connection;

    public LocationDAO() throws SQLException {
        connection = DatabaseConnection.connect();
    }

    public void insert(jbLocation jbLocation) {
        String sql = "INSERT INTO LOCATIONS(LOCATION) VALUES(?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, jbLocation.getLocation());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM LOCATIONS WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(jbLocation jbLocation) {
        String sql = "UPDATE LOCATIONS SET LOCATION=? WHERE ID=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, jbLocation.getLocation());
            stmt.setInt(2, jbLocation.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<jbLocation> selectAll() {
        List<jbLocation> jbLocations = new ArrayList<>();
        String sql = "SELECT * FROM LOCATIONS";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                jbLocation jbLocation = new jbLocation();
                jbLocation.setId(rs.getInt("ID"));
                jbLocation.setLocation(rs.getString("LOCATION"));

                jbLocations.add(jbLocation);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jbLocations;
    }

    public jbLocation selectById(int id) {
        jbLocation jbLocation = null;
        String sql = "SELECT * FROM LOCATIONS WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                jbLocation = new jbLocation();
                jbLocation.setId(rs.getInt("ID"));
                jbLocation.setLocation(rs.getString("LOCATION"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jbLocation;
    }
}
