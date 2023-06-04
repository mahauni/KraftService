package tests;

import dataStructures.ListProblem;
import database.DAO.ActionDAO;
import database.DAO.EsgDAO;
import database.connection.DatabaseConnection;
import enums.enumESG;
import javaBeans.jbAction;
import javaBeans.jbESG;
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

        jbESG social = new jbESG(1, enumESG.SOCIAL, "Social 1");
        jbESG govern = new jbESG(2, enumESG.GOVERNMENTAL, "Governmental 1");
        jbESG enviro = new jbESG(3, enumESG.ENVIRONMENTAL, "Environmental 1");

        jbESG[] jbEsgs = { social, govern, enviro };

        ListProblem socialList = new ListProblem();
        ListProblem governList = new ListProblem();
        ListProblem enviroList = new ListProblem();

        ActionDAO actDao = new ActionDAO();

        Date sqlDate = new Date(System.currentTimeMillis());

        jbAction ac1 = new jbAction("Action 1", "Both date null", null, null);
        jbAction ac2 = new jbAction("Action 2", "Start date null", null, sqlDate);
        jbAction ac3 = new jbAction("Action 3", "Finish date null", sqlDate, null);
        jbAction ac4 = new jbAction("Action 4", "None date null", sqlDate, sqlDate);

        actDao.insert(ac1);
        actDao.insert(ac2);
        actDao.insert(ac3);
        actDao.insert(ac4);

        EsgDAO esgDao = new EsgDAO();

        int numberESG = 1000;
        for (int i = 1; i <= numberESG; i++) {
            int esgInt = rand.nextInt(3);

            jbESG jbEsg = new jbESG(jbEsgs[esgInt].getEsg(), UtilsEncode.encode(Integer.toString(i)));

            esgDao.insert(jbEsg);
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
