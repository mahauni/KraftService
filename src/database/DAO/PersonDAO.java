package database.DAO;

import database.connection.DatabaseConnection;
import javaBeans.Person;

import java.sql.Connection;

public class PersonDAO {
    private static Connection connection;

    public PersonDAO() {
        connection = DatabaseConnection.connect();
    }

    public void insert(Person person) {}

    public void delete() {}

    public void update() {}

    public void selectAll() {}

    public void selectById() {}
}
