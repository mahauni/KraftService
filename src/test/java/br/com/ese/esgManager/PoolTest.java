package br.com.ese.esgManager;

import br.com.ese.esgManager.database.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class PoolTest {
    public static void main(String[] args) throws SQLException {
        for (int i = 0; i < 50; i++) {
            Connection connection = DatabaseConnection.connect();
            System.out.println("Connection: " + i);
        }
    }
}
