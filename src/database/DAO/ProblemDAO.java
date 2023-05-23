package database.DAO;

import database.connection.DatabaseConnection;
import javaBeans.Problem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProblemDAO {
    private static Connection connection;

    public ProblemDAO() throws SQLException {
        connection = DatabaseConnection.connect();
    }

    // make a way to have a boolean convert to either 0 or 1 based on false and true
    public void insert(Problem problem) {
        String sql = "INSERT INTO PROBLEMS(DESCRIPTION, COMPLETED, IDPERSON, IDESG, IDLOCATION) VALUES(?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, problem.getDescription());
            stmt.setString(2, problem.getDescription());
            stmt.setString(3, problem.getDescription());
            stmt.setString(4, problem.getDescription());
            stmt.setString(5, problem.getDescription());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM PROBLEMS WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Problem problem) {
        String sql = "UPDATE PROBLEMS SET NAME=?, EMAIL=?, TELEPHONE=? WHERE ID=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(4, problem.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Problem> selectAll() {
        List<Problem> problems = new ArrayList<>();
        String sql = "SELECT * FROM PROBLEMS";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Problem problem = new Problem();
                problem.setId(rs.getInt("ID"));


                problems.add(problem);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return problems;
    }

    public Problem selectById(int id) {
        Problem problem = null;
        String sql = "SELECT * FROM PROBLEMS WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                problem = new Problem();
                problem.setId(rs.getInt("ID"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return problem;
    }
}
