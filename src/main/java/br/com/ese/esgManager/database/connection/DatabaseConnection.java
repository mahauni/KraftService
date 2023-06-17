package br.com.ese.esgManager.database.connection;

import br.com.ese.esgManager.utils.UtilsDotEnv;

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
            DatabasePools pools = new DatabasePools(url, passwd, user);
            connections = pools.getPools();
        }

        return connections.getConnection();
    }
}
