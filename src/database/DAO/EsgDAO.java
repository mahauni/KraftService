package database.DAO;

import database.connection.DatabaseConnection;
import javaBeans.ESG;

import java.sql.Connection;

public class EsgDAO {
    private static Connection connection;

    public EsgDAO() {
        connection = DatabaseConnection.connect();
    }

    public void insert(ESG esg) {}

    public void delete() {}

    public void update() {}

    public void selectAll() {}

    public void selectById() {}
}
