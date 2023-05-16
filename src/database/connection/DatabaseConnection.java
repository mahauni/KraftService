package database.connection;

import utils.UtilsDotEnv;

import java.sql.Connection;

public class DatabaseConnection {
    private static Connection connection;

    // singleton
    public static Connection connect() {
        if (connection == null) {
            UtilsDotEnv values = new UtilsDotEnv("./.env");
            String url = values.getEnv("url");
            String passwd = values.getEnv("passwd");
            String user = values.getEnv("user");
            ConnectionFactory connect = new ConnectionFactory(url, passwd, user);
            connection = connect.connect();
        }

        return connection;
    }
}
