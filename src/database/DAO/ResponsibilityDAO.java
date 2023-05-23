package database.DAO;

import database.connection.DatabaseConnection;
import javaBeans.Responsibility;

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

    public void insert(Responsibility responsibility) {
        String sql = "INSERT INTO RESPONSIBILITIES(IDDEPARTMENT, IDACTION) VALUES(?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, responsibility.getIdDepartment());
            stmt.setInt(2, responsibility.getIdAction());

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

    public void update(Responsibility responsibility) {
        String sql = "UPDATE RESPONSIBILITIES SET IDDEPARTMENT=?, IDACTION=? WHERE ID=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, responsibility.getIdDepartment());
            stmt.setInt(2, responsibility.getIdAction());
            stmt.setInt(3, (responsibility.getIdDepartment() * 10) + responsibility.getIdAction());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Responsibility> selectAll() {
        List<Responsibility> responsibilitys = new ArrayList<>();
        String sql = "SELECT * FROM RESPONSIBILITIES";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Responsibility responsibility = new Responsibility();
                responsibility.setIdDepartment(rs.getInt("IDDEPARTMENT"));
                responsibility.setIdAction(rs.getInt("IDACTION"));

                responsibilitys.add(responsibility);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return responsibilitys;
    }

    public Responsibility selectById(int id) {
        Responsibility responsibility = null;
        String sql = "SELECT * FROM RESPONSIBILITIES WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                responsibility = new Responsibility();
                responsibility.setIdDepartment(rs.getInt("IDDEPARTMENT"));
                responsibility.setIdAction(rs.getInt("IDACTION"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return responsibility;
    }
}
