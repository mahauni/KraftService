package Database.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Database.Connection.ConnectionFactory;
import Database.Models.User;

public class UserDAO {
	//comandos DML CRUD
	private final Connection connection;
	public UserDAO() {
		ConnectionFactory connection = new ConnectionFactory();
		this.connection = connection.conectar();
	}
	
	//insert
	public void insert(User user) throws SQLException {
		String sql = "insert into USUARIO(id,nome,email,senha,dataregistro) VALUES(?,?,?,?,?)";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setLong(1, user.getId());
		stmt.setString(2, user.getName());
		stmt.setString(3, user.getEmail());
		stmt.setString(4, user.getPassword());
		stmt.setDate(5, user.getRegisterDate());
		
		stmt.execute();
		stmt.close();
	}
	
	//delete
	//update
	//selectALL
	//selectById
}
