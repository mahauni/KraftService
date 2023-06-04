package database.DAO;

// Make the list of url per person and maybe for location too? idk but certanly for person

import database.connection.DatabaseConnection;
import javaBeans.jbPerson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    private static Connection connection;

    public PersonDAO() throws SQLException {
        connection = DatabaseConnection.connect();
    }

    // make the telephone to be nullif
    public void insert(jbPerson jbPerson) {
        String sql = "INSERT INTO PERSONS(NAME, EMAIL, TELEPHONE) VALUES(?, ?, NULLIF(?, null))";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, jbPerson.getName());
            stmt.setString(2, jbPerson.getEmail());
            stmt.setString(3, jbPerson.getTelephone());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM PERSONS WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(jbPerson jbPerson) {
        String sql = "UPDATE PERSONS SET NAME=?, EMAIL=?, TELEPHONE=NULLIF(?, null) WHERE ID=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, jbPerson.getName());
            stmt.setString(2, jbPerson.getEmail());
            stmt.setString(3, jbPerson.getTelephone());
            stmt.setInt(4, jbPerson.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<jbPerson> selectAll() {
        List<jbPerson> jbPeople = new ArrayList<>();
        String sql = "SELECT * FROM PERSONS";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                jbPerson jbPerson = new jbPerson();
                jbPerson.setId(rs.getInt("ID"));
                jbPerson.setName(rs.getString("NAME"));
                jbPerson.setEmail(rs.getString("EMAIL"));
                jbPerson.setTelephone(rs.getString("TELEPHONE"));


                jbPeople.add(jbPerson);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jbPeople;
    }

    public jbPerson selectById(int id) {
        jbPerson jbPerson = null;
        String sql = "SELECT * FROM PERSONS WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                jbPerson = new jbPerson();
                jbPerson.setId(rs.getInt("ID"));
                jbPerson.setName(rs.getString("NAME"));
                jbPerson.setEmail(rs.getString("EMAIL"));
                jbPerson.setTelephone(rs.getString("TELEPHONE"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jbPerson;
    }
}
