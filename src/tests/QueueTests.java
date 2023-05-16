package tests;

import dataStructures.ActionQueue;
import dataStructures.ProblemQueue;
import javaBeans.*;
import utils.UtilsEncode;

import java.util.Random;

public class QueueTests {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();

        ESG social = new ESG(1, enums.ESG.SOCIAL, "Social 1");
        ESG govern = new ESG(2, enums.ESG.GOVERNMENTAL, "Governmental 1");
        ESG enviro = new ESG(3, enums.ESG.ENVIRONMENTAL, "Environmental 1");

        ESG[] esgs = { social, govern, enviro };

        ProblemQueue socialList = new ProblemQueue();
        ProblemQueue governList = new ProblemQueue();
        ProblemQueue enviroList = new ProblemQueue();

        ActionQueue listAction = new ActionQueue();
        int numberActions = 1150;
        for (int i = 1; i <= numberActions; i++) {
            Action action = new Action(i, "Hash of " + i, UtilsEncode.encode(Integer.toString(i)));
            listAction.enqueue(action);
        }

        int numberProblems = 1000;
        for (int i = 1; i <= numberProblems; i++) {
            int numActions = rand.nextInt(3);
            ActionQueue actions = new ActionQueue();
            for (int j = 0; j < numActions; j++) {
                actions.enqueue(listAction.dequeue());
            }
            Solution solution = new Solution(actions);
            Problem problem = new Problem(i, "Problem " + i, rand.nextBoolean(), new Person(), esgs[rand.nextInt(3)], new Location(), solution);

            switch (problem.getEsg().getEsg()) {
                case ENVIRONMENTAL -> enviroList.enqueue(problem);
                case SOCIAL -> socialList.enqueue(problem);
                case GOVERNMENTAL -> governList.enqueue(problem);
            }
        }

        System.out.println("Environmental list length: " + enviroList.length());
        for (int i = 0; i < 7; i++) {
            Problem problem = enviroList.dequeue();
            System.out.println("id: " + problem.getId() + " | How many actions: " + problem.getSolution().getActions().length());
            System.out.println("Actions:");
            problem.getSolution().getActions().printActions();
            System.out.println();
        }

        System.out.println("Social list length: " + socialList.length());
        for (int i = 0; i < 7; i++) {
            Problem problem = socialList.dequeue();
            System.out.println("id: " + problem.getId() + " | How many actions: " + problem.getSolution().getActions().length());
            System.out.println("Actions:");
            problem.getSolution().getActions().printActions();
            System.out.println();
        }

        System.out.println("Governmental list length: " + governList.length());
        for (int i = 0; i < 7; i++) {
            Problem problem = governList.dequeue();
            System.out.println("id: " + problem.getId() + " | How many actions: " + problem.getSolution().getActions().length());
            System.out.println("Actions:");
            problem.getSolution().getActions().printActions();
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
