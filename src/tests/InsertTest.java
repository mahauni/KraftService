package tests;

import dataStructures.ListProblem;
import database.DAO.ActionDAO;
import database.DAO.EsgDAO;
import database.connection.DatabaseConnection;
import javaBeans.Action;
import javaBeans.ESG;
import utils.UtilsEncode;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class InsertTest {
    public static void main(String[] args) throws Exception {
        // This test if for postgres database, if you want to use oracle or other, is best to change the
        // SQL to create table and to drop the table of your database
        Random rand = new Random();

        createTables();

        ESG social = new ESG(1, enums.ESG.SOCIAL, "Social 1");
        ESG govern = new ESG(2, enums.ESG.GOVERNMENTAL, "Governmental 1");
        ESG enviro = new ESG(3, enums.ESG.ENVIRONMENTAL, "Environmental 1");

        ESG[] esgs = { social, govern, enviro };

        ListProblem socialList = new ListProblem();
        ListProblem governList = new ListProblem();
        ListProblem enviroList = new ListProblem();

        ActionDAO actDao = new ActionDAO();

        Date sqlDate = new Date(System.currentTimeMillis());

        Action ac1 = new Action("Action 1", "Both date null", null, null);
        Action ac2 = new Action("Action 2", "Start date null", null, sqlDate);
        Action ac3 = new Action("Action 3", "Finish date null", sqlDate, null);
        Action ac4 = new Action("Action 4", "None date null", sqlDate, sqlDate);

        actDao.insert(ac1);
        actDao.insert(ac2);
        actDao.insert(ac3);
        actDao.insert(ac4);

        EsgDAO esgDao = new EsgDAO();

        int numberESG = 1000;
        for (int i = 1; i <= numberESG; i++) {
            int esgInt = rand.nextInt(3);

            ESG esg = new ESG(esgs[esgInt].getEsg(), UtilsEncode.encode(Integer.toString(i)));

            esgDao.insert(esg);
        }

        deleteTables();
    }

    private static void createTables() throws SQLException {
        String CreateTable = "CREATE TABLE ESG(ID SERIAL PRIMARY KEY, ESG VARCHAR NOT NULL, DESCRIPTION TEXT NOT NULL)";
        Connection c = DatabaseConnection.connect();
        PreparedStatement stmt = c.prepareStatement(CreateTable);
        stmt.execute();
        stmt.close();

        CreateTable = "CREATE TABLE ACTIONS(ID SERIAL PRIMARY KEY, NAME VARCHAR NOT NULL, DESCRIPTION TEXT NOT NULL, START DATE, FINISH DATE)";
        stmt = c.prepareStatement(CreateTable);
        stmt.execute();
        stmt.close();
    }

    private static void deleteTables() throws SQLException {
        String DeleteTable = "DROP TABLE ESG";
        Connection c = DatabaseConnection.connect();
        PreparedStatement stmt = c.prepareStatement(DeleteTable);
        stmt.execute();
        stmt.close();

        DeleteTable = "DROP TABLE ACTIONS";
        stmt = c.prepareStatement(DeleteTable);
        stmt.execute();
        stmt.close();
    }
}
