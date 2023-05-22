package tests;

import dataStructures.ListAction;
import dataStructures.ListProblem;
import database.DAO.EsgDAO;
import database.connection.DatabaseConnection;
import entities.Person;
import entities.Problem;
import entities.Solution;
import javaBeans.Action;
import javaBeans.ESG;
import javaBeans.Location;
import utils.UtilsEncode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class InsertTest {
    public static void main(String[] args) throws Exception {
        // This test if for postgres database, if you want to use oracle or other, is best to change the
        // SQL to create table and to drop the table of your database
        Random rand = new Random();

        String CreateTable = "CREATE TABLE ESG(ID SERIAL PRIMARY KEY, ESG VARCHAR, DESCRIPTION TEXT)";
        Connection c = DatabaseConnection.connect();
        PreparedStatement stmt = c.prepareStatement(CreateTable);
        stmt.execute();
        stmt.close();


        ESG social = new ESG(1, enums.ESG.SOCIAL, "Social 1");
        ESG govern = new ESG(2, enums.ESG.GOVERNMENTAL, "Governmental 1");
        ESG enviro = new ESG(3, enums.ESG.ENVIRONMENTAL, "Environmental 1");

        ESG[] esgs = { social, govern, enviro };

        ListProblem socialList = new ListProblem();
        ListProblem governList = new ListProblem();
        ListProblem enviroList = new ListProblem();

        EsgDAO dao = new EsgDAO();

        int numberESG = 1000;
        for (int i = 1; i <= numberESG; i++) {
            int esgInt = rand.nextInt(3);

            ESG esg = new ESG(esgs[esgInt].getEsg(), UtilsEncode.encode(Integer.toString(i)));

            dao.insert(esg);
        }


        String DeleteTable = "DROP TABLE ESG";
        stmt = c.prepareStatement(DeleteTable);
        stmt.execute();
        stmt.close();
    }
}
