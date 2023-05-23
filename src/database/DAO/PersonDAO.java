package database.DAO;

// Make the list of url per person and maybe for location too? idk but certanly for person

import database.connection.DatabaseConnection;
import javaBeans.Person;

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
    public void insert(Person person) {
        String sql = "INSERT INTO PERSONS(NAME, EMAIL, TELEPHONE) VALUES(?, ?, NULLIF(?, null))";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, person.getName());
            stmt.setString(2, person.getEmail());
            stmt.setString(3, person.getTelephone());

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

    public void update(Person person) {
        String sql = "UPDATE PERSONS SET NAME=?, EMAIL=?, TELEPHONE=NULLIF(?, null) WHERE ID=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, person.getName());
            stmt.setString(2, person.getEmail());
            stmt.setString(3, person.getTelephone());
            stmt.setInt(4, person.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Person> selectAll() {
        List<Person> persons = new ArrayList<>();
        String sql = "SELECT * FROM PERSONS";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("ID"));
                person.setName(rs.getString("NAME"));
                person.setEmail(rs.getString("EMAIL"));
                person.setTelephone(rs.getString("TELEPHONE"));


                persons.add(person);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public Person selectById(int id) {
        Person person = null;
        String sql = "SELECT * FROM PERSONS WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                person = new Person();
                person.setId(rs.getInt("ID"));
                person.setName(rs.getString("NAME"));
                person.setEmail(rs.getString("EMAIL"));
                person.setTelephone(rs.getString("TELEPHONE"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }
}
