package Database.Connection;

import Utils.DotEnv.DotEnv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private final String url;
	private final String passwd;
	private final String user;

	public ConnectionFactory() {
		DotEnv values = new DotEnv();
		this.url = values.getEnv("url");
		this.passwd = values.getEnv("passwd");
		this.user = values.getEnv("user");
	}

	public Connection conectar() {
		try {
			return DriverManager.getConnection(this.url, this.user, this.passwd);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
