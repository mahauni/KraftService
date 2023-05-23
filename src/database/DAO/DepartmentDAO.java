package database.DAO;

import database.connection.DatabaseConnection;
import javaBeans.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DepartmentDAO {
    private static Connection connection;

    public DepartmentDAO() throws SQLException {
        connection = DatabaseConnection.connect();
    }

    public void insert(Department department) {
        String sql = "INSERT INTO DEPARTMENTS(NAME) VALUES(?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, department.getName());

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

    public void update(Department department) {
        String sql = "UPDATE DEPARTMENTS SET NAME=? WHERE ID=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, department.getName());
            stmt.setInt(2, department.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Department> selectAll() {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM DEPARTMENTS";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("ID"));
                department.setName(rs.getString("DEPARTMENT"));

                departments.add(department);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    public Department selectById(int id) {
        Department department = null;
        String sql = "SELECT * FROM DEPARTMENTS WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                department = new Department();
                department.setId(rs.getInt("ID"));
                department.setName(rs.getString("DEPARTMENT"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }
}
