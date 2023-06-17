package br.com.ese.esgManager.database.DAO;

import br.com.ese.esgManager.database.connection.DatabaseConnection;
import br.com.ese.esgManager.javaBeans.jbDepartment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    private static Connection connection;

    public DepartmentDAO() throws SQLException {
        connection = DatabaseConnection.connect();
    }

    public void insert(jbDepartment jbDepartment) {
        String sql = "INSERT INTO DEPARTMENTS(NAME) VALUES(?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, jbDepartment.getName());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM DEPARTMENTS WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(jbDepartment jbDepartment) {
        String sql = "UPDATE DEPARTMENTS SET NAME=? WHERE ID=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, jbDepartment.getName());
            stmt.setInt(2, jbDepartment.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<jbDepartment> selectAll() {
        List<jbDepartment> jbDepartments = new ArrayList<>();
        String sql = "SELECT * FROM DEPARTMENTS";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                jbDepartment jbDepartment = new jbDepartment();
                jbDepartment.setId(rs.getInt("ID"));
                jbDepartment.setName(rs.getString("DEPARTMENT"));

                jbDepartments.add(jbDepartment);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jbDepartments;
    }

    public jbDepartment selectById(int id) {
        jbDepartment jbDepartment = null;
        String sql = "SELECT * FROM DEPARTMENTS WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                jbDepartment = new jbDepartment();
                jbDepartment.setId(rs.getInt("ID"));
                jbDepartment.setName(rs.getString("DEPARTMENT"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jbDepartment;
    }
}
