package database.connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DatabasePools {
	private final String url;
	private final String passwd;
	private final String user;
	private static DataSource connectionPools = null;

	DatabasePools(String url, String passwd, String user) {
		this.url = url;
		this.passwd = passwd;
		this.user = user;
	}

	DataSource getPools() throws SQLException {
		if (connectionPools == null) {
			final ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
			comboPooledDataSource.setJdbcUrl(this.url);
			comboPooledDataSource.setUser(this.user);
			comboPooledDataSource.setPassword(this.passwd);

			comboPooledDataSource.setMaxPoolSize(10);
			connectionPools = comboPooledDataSource;
		}

		return connectionPools;
	}
}
