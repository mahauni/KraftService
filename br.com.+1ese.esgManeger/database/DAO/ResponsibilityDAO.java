package database.DAO;

import database.connection.DatabaseConnection;
import javaBeans.jbResponsibility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResponsibilityDAO {
    private static Connection connection;

    public ResponsibilityDAO() throws SQLException {
        connection = DatabaseConnection.connect();
    }

    public void insert(jbResponsibility jbResponsibility) {
        String sql = "INSERT INTO RESPONSIBILITIES(IDDEPARTMENT, IDACTION) VALUES(?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, jbResponsibility.getIdDepartment());
            stmt.setInt(2, jbResponsibility.getIdAction());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM RESPONSIBILITIES WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(jbResponsibility jbResponsibility) {
        String sql = "UPDATE RESPONSIBILITIES SET IDDEPARTMENT=?, IDACTION=? WHERE ID=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, jbResponsibility.getIdDepartment());
            stmt.setInt(2, jbResponsibility.getIdAction());
            stmt.setInt(3, (jbResponsibility.getIdDepartment() * 10) + jbResponsibility.getIdAction());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<jbResponsibility> selectAll() {
        List<jbResponsibility> jbResponsibilities = new ArrayList<>();
        String sql = "SELECT * FROM RESPONSIBILITIES";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                jbResponsibility jbResponsibility = new jbResponsibility();
                jbResponsibility.setIdDepartment(rs.getInt("IDDEPARTMENT"));
                jbResponsibility.setIdAction(rs.getInt("IDACTION"));

                jbResponsibilities.add(jbResponsibility);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jbResponsibilities;
    }

    public jbResponsibility selectById(int id) {
        jbResponsibility jbResponsibility = null;
        String sql = "SELECT * FROM RESPONSIBILITIES WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                jbResponsibility = new jbResponsibility();
                jbResponsibility.setIdDepartment(rs.getInt("IDDEPARTMENT"));
                jbResponsibility.setIdAction(rs.getInt("IDACTION"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jbResponsibility;
    }
}
