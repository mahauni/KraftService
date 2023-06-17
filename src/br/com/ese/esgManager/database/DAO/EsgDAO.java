package br.com.ese.esgManager.database.DAO;

import br.com.ese.esgManager.database.connection.DatabaseConnection;
import br.com.ese.esgManager.enums.enumESG;
import br.com.ese.esgManager.javaBeans.jbESG;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EsgDAO {
    private static Connection connection;

    public EsgDAO() throws SQLException {
        connection = DatabaseConnection.connect();
    }

    public void insert(jbESG jbEsg) {
        String sql = "INSERT INTO ESG(ESG, DESCRIPTION) VALUES(?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, jbEsg.getEsg().toString());
            stmt.setString(2, jbEsg.getDescription());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM ESG WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // maybe do something that only this one can set the id and others not
    public void update(jbESG jbEsg) {
        String sql = "UPDATE ESG SET ESG=?, DESCRIPTION=? WHERE ID=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, jbEsg.getEsg().toString());
            stmt.setString(2, jbEsg.getDescription());
            stmt.setInt(3, jbEsg.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<jbESG> selectAll() {
        List<jbESG> jbEsgs = new ArrayList<>();
        String sql = "SELECT * FROM ESG";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                jbESG jbEsg = new jbESG();
                jbEsg.setId(rs.getInt("ID"));
                jbEsg.setEsg(enumESG.valueOf(rs.getString("ESG")));
                jbEsg.setDescription(rs.getString("DESCRIPTION"));

                jbEsgs.add(jbEsg);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jbEsgs;
    }

    public jbESG selectById(int id) {
        jbESG jbEsg = null;
        String sql = "SELECT * FROM ESG WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                jbEsg = new jbESG();
                jbEsg.setId(rs.getInt("ID"));
                jbEsg.setEsg(enumESG.valueOf(rs.getString("ESG")));
                jbEsg.setDescription(rs.getString("DESCRIPTION"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jbEsg;
    }
}
