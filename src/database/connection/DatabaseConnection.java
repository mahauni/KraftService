package database.connection;

import utils.UtilsDotEnv;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DataSource connections;

    // singleton
    public static Connection connect() throws SQLException {
        if (connections == null) {
            UtilsDotEnv values = new UtilsDotEnv("./.env");
            String url = values.getEnv("url");
            String passwd = values.getEnv("passwd");
            String user = values.getEnv("user");
            DatabasePools connections = new DatabasePools(url, passwd, user);
        }

        return connections.getConnection();
    }
}
