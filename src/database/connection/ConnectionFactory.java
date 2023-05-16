package database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private final String url;
	private final String passwd;
	private final String user;

	public ConnectionFactory(String url, String passwd, String user) {
		this.url = url;
		this.passwd = passwd;
		this.user = user;
	}

	public Connection connect() {
		try {
			return DriverManager.getConnection(this.url, this.user, this.passwd);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
