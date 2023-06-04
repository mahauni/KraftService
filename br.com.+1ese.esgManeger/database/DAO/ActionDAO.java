package database.DAO;

// changed javabean and need to fix this bullshit

import database.connection.DatabaseConnection;
import javaBeans.jbAction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActionDAO {
    private static Connection connection;

    public ActionDAO() throws SQLException {
        connection = DatabaseConnection.connect();
    }

    public void insert(jbAction jbAction) {
        String sql = "INSERT INTO ACTIONS(NAME, DESCRIPTION, START, FINISH) VALUES(?, ?, CAST(NULLIF(?, null) AS DATE), CAST(NULLIF(?, null) AS DATE))";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, jbAction.getName());
            stmt.setString(2, jbAction.getDescription());
            stmt.setDate(3, jbAction.getStart());
            stmt.setDate(4, jbAction.getFinish());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM ACTIONS WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(jbAction jbAction) {
        String sql = "UPDATE ACTIONS SET NAME=?, DESCRIPTION=?, START=CAST(NULLIF(?, null) AS DATE), FINISH=CAST(NULLIF(?, null) AS DATE) WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, jbAction.getName());
            stmt.setString(2, jbAction.getDescription());
            stmt.setDate(3, jbAction.getStart());
            stmt.setDate(4, jbAction.getFinish());
            stmt.setInt(5, jbAction.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<jbAction> selectAll() {
        List<jbAction> jbActions = new ArrayList<>();
        String sql = "SELECT * FROM ACTIONS";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                jbAction jbAction = new jbAction();
                jbAction.setId(rs.getInt("ID"));
                jbAction.setName(rs.getString("NAME"));
                jbAction.setDescription(rs.getString("DESCRIPTION"));
                jbAction.setStart(rs.getDate("START"));
                jbAction.setFinish(rs.getDate("FINISH"));

                jbActions.add(jbAction);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jbActions;
    }

    public jbAction selectById(int id) {
        jbAction jbAction = null;
        String sql = "SELECT * FROM ACTIONS WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                jbAction = new jbAction();
                jbAction.setId(rs.getInt("ID"));
                jbAction.setName(rs.getString("NAME"));
                jbAction.setDescription(rs.getString("DESCRIPTION"));
                jbAction.setStart(rs.getDate("START"));
                jbAction.setFinish(rs.getDate("FINISH"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jbAction;
    }
}
