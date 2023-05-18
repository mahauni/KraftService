package database.DAO;

// fix this because we have one more camp to fill

import database.connection.DatabaseConnection;
import javaBeans.Location;

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

    public void insert(Location location) {
        String sql = "INSERT INTO LOCATIONS(LOCATION) VALUES(?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, location.getLocation());

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

    public void update(Location location) {
        String sql = "UPDATE LOCATIONS SET LOCATION=? WHERE ID=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, location.getLocation());
            stmt.setInt(2, location.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Location> selectAll() {
        List<Location> locations = new ArrayList<>();
        String sql = "SELECT * FROM LOCATIONS";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Location location = new Location();
                location.setId(rs.getInt("ID"));
                location.setLocation(rs.getString("LOCATION"));

                locations.add(location);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locations;
    }

    public Location selectById(int id) {
        Location location = null;
        String sql = "SELECT * FROM LOCATIONS WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                location = new Location();
                location.setId(rs.getInt("ID"));
                location.setLocation(rs.getString("LOCATION"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return location;
    }
}
