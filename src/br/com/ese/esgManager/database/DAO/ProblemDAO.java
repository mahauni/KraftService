package br.com.ese.esgManager.database.DAO;

import br.com.ese.esgManager.database.connection.DatabaseConnection;
import br.com.ese.esgManager.javaBeans.jbProblem;

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
    // finish this one marker
    public void insert(jbProblem jbProblem) {
        String sql = "INSERT INTO PROBLEMS(DESCRIPTION, COMPLETED, IDPERSON, IDESG, IDLOCATION) VALUES(?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, jbProblem.getDescription());
            stmt.setBoolean(2, jbProblem.isCompleted());
            stmt.setInt(3, jbProblem.getIdPerson());
            stmt.setInt(4, jbProblem.getIdEsg());
            stmt.setInt(5, jbProblem.getIdLocation());

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

    public void update(jbProblem jbProblem) {
        String sql = "UPDATE PROBLEMS SET DESCRIPTION=?, COMPLETED=?, IDPERSON=?, IDESG=?, IDLOCATION=?  WHERE ID=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, jbProblem.getDescription());
            stmt.setBoolean(2, jbProblem.isCompleted());
            stmt.setInt(3, jbProblem.getIdPerson());
            stmt.setInt(4, jbProblem.getIdEsg());
            stmt.setInt(5, jbProblem.getIdLocation());
            stmt.setInt(6, jbProblem.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<jbProblem> selectAll() {
        List<jbProblem> jbProblems = new ArrayList<>();
        String sql = "SELECT * FROM PROBLEMS";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                jbProblem jbProblem = new jbProblem();
                jbProblem.setId(rs.getInt("ID"));
                jbProblem.setDescription(rs.getString("DESCRIPTION"));
                jbProblem.setCompleted(rs.getBoolean("COMPLETED"));
                jbProblem.setIdPerson(rs.getInt("IDPERSON"));
                jbProblem.setIdEsg(rs.getInt("IDESG"));
                jbProblem.setIdLocation(rs.getInt("IDLOCATION"));

                jbProblems.add(jbProblem);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jbProblems;
    }

    public jbProblem selectById(int id) {
        jbProblem jbProblem = null;
        String sql = "SELECT * FROM PROBLEMS WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                jbProblem = new jbProblem();
                jbProblem.setId(rs.getInt("ID"));
                jbProblem.setDescription(rs.getString("DESCRIPTION"));
                jbProblem.setCompleted(rs.getBoolean("COMPLETED"));
                jbProblem.setIdPerson(rs.getInt("IDPERSON"));
                jbProblem.setIdEsg(rs.getInt("IDESG"));
                jbProblem.setIdLocation(rs.getInt("IDLOCATION"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jbProblem;
    }
}
