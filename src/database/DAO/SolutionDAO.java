package database.DAO;

import database.connection.DatabaseConnection;
import javaBeans.Solution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolutionDAO {
    private static Connection connection;

    public SolutionDAO() throws SQLException {
        connection = DatabaseConnection.connect();
    }

    public void insert(Solution solution) {
        String sql = "INSERT INTO SOLUTIONS(IDPROBLEM, IDACTION) VALUES(?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, solution.getIdProblem());
            stmt.setInt(2, solution.getIdAction());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM SOLUTIONS WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Solution solution) {
        String sql = "UPDATE SOLUTIONS SET IDPROBLEM=?, IDACTION=? WHERE ID=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, solution.getIdProblem());
            stmt.setInt(2, solution.getIdAction());
            stmt.setInt(3, (solution.getIdProblem() * 10) + solution.getIdAction());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Solution> selectAll() {
        List<Solution> solutions = new ArrayList<>();
        String sql = "SELECT * FROM SOLUTIONS";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Solution solution = new Solution();
                solution.setIdProblem(rs.getInt("IDPROBLEM"));
                solution.setIdAction(rs.getInt("IDACTION"));

                solutions.add(solution);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return solutions;
    }

    public Solution selectById(int id) {
        Solution solution = null;
        String sql = "SELECT * FROM SOLUTIONS WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                solution = new Solution();
                solution.setIdProblem(rs.getInt("IDPROBLEM"));
                solution.setIdAction(rs.getInt("IDACTION"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return solution;
    }
}
