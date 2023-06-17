package br.com.ese.esgManager.database.DAO;

import br.com.ese.esgManager.database.connection.DatabaseConnection;
import br.com.ese.esgManager.javaBeans.jbSolution;

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

    public void insert(jbSolution jbSolution) {
        String sql = "INSERT INTO SOLUTIONS(IDPROBLEM, IDACTION) VALUES(?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, jbSolution.getIdProblem());
            stmt.setInt(2, jbSolution.getIdAction());

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

    public void update(jbSolution jbSolution) {
        String sql = "UPDATE SOLUTIONS SET IDPROBLEM=?, IDACTION=? WHERE ID=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, jbSolution.getIdProblem());
            stmt.setInt(2, jbSolution.getIdAction());
            stmt.setInt(3, (jbSolution.getIdProblem() * 10) + jbSolution.getIdAction());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<jbSolution> selectAll() {
        List<jbSolution> jbSolutions = new ArrayList<>();
        String sql = "SELECT * FROM SOLUTIONS";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                jbSolution jbSolution = new jbSolution();
                jbSolution.setIdProblem(rs.getInt("IDPROBLEM"));
                jbSolution.setIdAction(rs.getInt("IDACTION"));

                jbSolutions.add(jbSolution);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jbSolutions;
    }

    public jbSolution selectById(int id) {
        jbSolution jbSolution = null;
        String sql = "SELECT * FROM SOLUTIONS WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                jbSolution = new jbSolution();
                jbSolution.setIdProblem(rs.getInt("IDPROBLEM"));
                jbSolution.setIdAction(rs.getInt("IDACTION"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jbSolution;
    }
}
