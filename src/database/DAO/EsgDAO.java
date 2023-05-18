package database.DAO;

import database.connection.DatabaseConnection;
import javaBeans.ESG;

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

    public void insert(ESG esg) {
        String sql = "INSERT INTO ESG(ESG, DESCRIPTION) VALUES(?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, esg.getEsg().toString());
            stmt.setString(2, esg.getDescription());

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
    public void update(ESG esg) {
        String sql = "UPDATE ESG SET ESG=?, DESCRIPTION=? WHERE ID=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, esg.getEsg().toString());
            stmt.setString(2, esg.getDescription());
            stmt.setInt(3, esg.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ESG> selectAll() {
        List<ESG> esgs = new ArrayList<>();
        String sql = "SELECT * FROM ESG";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ESG esg = new ESG();
                esg.setId(rs.getInt("ID"));
                esg.setEsg(enums.ESG.valueOf(rs.getString("ESG")));
                esg.setDescription(rs.getString("DESCRIPTION"));

                esgs.add(esg);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return esgs;
    }

    public ESG selectById(int id) {
        ESG esg = null;
        String sql = "SELECT * FROM ESG WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                esg = new ESG();
                esg.setId(rs.getInt("ID"));
                esg.setEsg(enums.ESG.valueOf(rs.getString("ESG")));
                esg.setDescription(rs.getString("DESCRIPTION"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return esg;
    }
}
