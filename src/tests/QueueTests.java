package tests;

import dataStructures.ListAction;
import dataStructures.ListProblem;
import entities.Person;
import entities.Problem;
import entities.Solution;
import javaBeans.Action;
import javaBeans.ESG;
import javaBeans.Location;
import utils.UtilsEncode;

import java.util.Random;

public class QueueTests {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();

        ESG social = new ESG(1, enums.ESG.SOCIAL, "Social 1");
        ESG govern = new ESG(2, enums.ESG.GOVERNMENTAL, "Governmental 1");
        ESG enviro = new ESG(3, enums.ESG.ENVIRONMENTAL, "Environmental 1");

        ESG[] esgs = { social, govern, enviro };

        ListProblem socialList = new ListProblem();
        ListProblem governList = new ListProblem();
        ListProblem enviroList = new ListProblem();

        ListAction listAction = new ListAction();
        int numberActions = 1150;
        for (int i = 1; i <= numberActions; i++) {
            Action action = new Action(i, "Hash of " + i, UtilsEncode.encode(Integer.toString(i)));
            listAction.enqueue(action);
        }

        int numberProblems = 1000;
        for (int i = 1; i <= numberProblems; i++) {
            int numActions = rand.nextInt(3);
            ListAction actions = new ListAction();
            for (int j = 0; j < numActions; j++) {
                actions.enqueue(listAction.dequeue());
            }
            Solution solution = new Solution(actions);
            int esgInt = rand.nextInt(3);
            // Using the problem(javaBeans.problem, entities.Person, javaBeans.ESG, javaBeans.Location)
            Problem problem = new Problem(new javaBeans.Problem(i, "Problem " + i, rand.nextBoolean(), 1, esgInt, 1), new Person(), esgs[esgInt], new Location(), solution);

            switch (problem.getEsg().getEsg()) {
                case ENVIRONMENTAL -> enviroList.enqueue(problem);
                case SOCIAL -> socialList.enqueue(problem);
                case GOVERNMENTAL -> governList.enqueue(problem);
            }
        }

        System.out.println("Environmental list length: " + enviroList.length());
        for (int i = 0; i < 7; i++) {
            Problem problem = enviroList.dequeue();
            System.out.println("id: " + problem.getProblem().getId() + " | How many actions: " + problem.getSolution().getListAction().length());
            System.out.println("Actions:");
            problem.getSolution().getListAction().printActions();
            System.out.println();
        }

        System.out.println("Social list length: " + socialList.length());
        for (int i = 0; i < 7; i++) {
            Problem problem = socialList.dequeue();
            System.out.println("id: " + problem.getProblem().getId() + " | How many actions: " + problem.getSolution().getListAction().length());
            System.out.println("Actions:");
            problem.getSolution().getListAction().printActions();
            System.out.println();
        }

        System.out.println("Governmental list length: " + governList.length());
        for (int i = 0; i < 7; i++) {
            Problem problem = governList.dequeue();
            System.out.println("id: " + problem.getProblem().getId() + " | How many actions: " + problem.getSolution().getListAction().length());
            System.out.println("Actions:");
            problem.getSolution().getListAction().printActions();
            System.out.println();
        }

        System.out.println("Action list length: " + listAction.length());
        for (int i = 0; i < 7; i++) {
            Action action = listAction.dequeue();
            System.out.println("Actions without any problem: ");
            System.out.println(action);
        }
    }
}
