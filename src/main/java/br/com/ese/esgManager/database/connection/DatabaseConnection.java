package br.com.ese.esgManager.database.connection;

import io.github.cdimascio.dotenv.Dotenv;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DataSource connections;

    // for development only
     private static final Dotenv dotenv = Dotenv.load();

    // singleton
    public static Connection connect() throws SQLException {
        if (connections == null) {
            String url = dotenv.get("url");
            String passwd = dotenv.get("passwd");
            String user = dotenv.get("user");
//            String url = System.getenv("url");
//            String passwd = System.getenv("passwd");
//            String user = System.getenv("user");
            DatabasePools pools = new DatabasePools(url, passwd, user);
            connections = pools.getPools();
        }

        return connections.getConnection();
    }
}
