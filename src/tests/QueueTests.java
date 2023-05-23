package tests;

import dataStructures.ListAction;
import dataStructures.ListProblem;
import dataStructures.ListProfile;
import entities.Person;
import entities.Problem;
import entities.Solution;
import javaBeans.Action;
import javaBeans.ESG;
import javaBeans.Location;
import utils.UtilsEncode;

import java.sql.Date;
import java.util.Random;
import java.util.Scanner;

public class QueueTests {
    static ListProblem socialList = new ListProblem();
    static ListProblem governList = new ListProblem();
    static ListProblem enviroList = new ListProblem();
    static ListAction actionList = new ListAction();
    static Scanner sc = new Scanner(System.in);
    static ESG[] esgs = new ESG[3];

    public static void main(String[] args) throws Exception {
        init();
        int option;
        app: while (true) {
            menu();
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1 -> loadData();
                case 2 -> getLengthList();
                case 3 -> getTopList();
                case 4 -> getDequeueList();
                case 5 -> getEnqueueList();
                case 6 -> smallTestAllLists();
                case 0 -> {
                    break app;
                }
                default -> {
                    System.out.println("Not available command, try another one.");
                }
            }
        }
    }

    public static void init() {
        esgs[0] = new ESG(1, enums.ESG.SOCIAL, "Social 1");
        esgs[1] = new ESG(2, enums.ESG.GOVERNMENTAL, "Governmental 1");
        esgs[2] = new ESG(3, enums.ESG.ENVIRONMENTAL, "Environmental 1");
    }

    public static void loadData() throws Exception {
        Random rand = new Random();

        int numberActions = 1150;
        for (int i = 1; i <= numberActions; i++) {
            Action action = new Action(i, "Hash of " + i, UtilsEncode.encode(Integer.toString(i)));
            actionList.enqueue(action);
        }

        int numberProblems = 1000;
        for (int i = 1; i <= numberProblems; i++) {
            int numActions = rand.nextInt(3);
            ListAction actions = new ListAction();
            for (int j = 0; j < numActions; j++) {
                actions.enqueue(actionList.dequeue());
            }
            Solution solution = new Solution(actions);
            Person person = new Person(new javaBeans.Person(1, "TestName", "TestEmail@gmail.com"), new ListProfile(), new ListProblem());
            int esgInt = rand.nextInt(3);
            // Using the problem(javaBeans.problem, entities.Person, javaBeans.ESG, javaBeans.Location)
            Problem problem = new Problem(new javaBeans.Problem(i, "Problem " + i, rand.nextBoolean(), person.getPerson().getId(), esgInt, 1), person, esgs[esgInt], new Location(), solution);

            switch (problem.getEsg().getEsg()) {
                case ENVIRONMENTAL -> enviroList.enqueue(problem);
                case SOCIAL -> socialList.enqueue(problem);
                case GOVERNMENTAL -> governList.enqueue(problem);
            }
        }

        System.out.println("Data loaded!");
    }

    public static void smallTestAllLists() {
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

        System.out.println("Action list length: " + actionList.length());
        for (int i = 0; i < 7; i++) {
            Action action = actionList.dequeue();
            System.out.println("Actions without any problem: ");
            System.out.println(action);
        }
    }

    public static void getLengthList() {
        int option;
        while (true) {
            System.out.println("Which List do you want to get the length?");
            System.out.println("1. socialList");
            System.out.println("2. governList");
            System.out.println("3. enviroList");
            System.out.println("4. actionList");
            System.out.println("0. Go back");
            System.out.print("Type the number: ");

            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1 -> System.out.println("socialList length: " + socialList.length());
                case 2 -> System.out.println("governList length: " + governList.length());
                case 3 -> System.out.println("enviroList length: " + enviroList.length());
                case 4 -> System.out.println("actionList length: " + actionList.length());
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("Not available command, try another one.");
                    getLengthList();
                }
            }
        }
    }

    public static void getTopList() {
        int option;
        while (true) {
            System.out.println("Which List do you want to get the first element?");
            System.out.println("1. socialList");
            System.out.println("2. governList");
            System.out.println("3. enviroList");
            System.out.println("4. actionList");
            System.out.println("0. Go back");
            System.out.print("Type the number: ");

            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1 -> System.out.println("socialList top element: " + socialList.peak());
                case 2 -> System.out.println("governList top element: " + governList.peak());
                case 3 -> System.out.println("enviroList top element: " + enviroList.peak());
                case 4 -> System.out.println("actionList top element: " + actionList.peak());
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("Not available command, try another one.");
                    getTopList();
                }
            }
        }
    }

    public static void getDequeueList() {
        int option;
        while (true) {
            System.out.println("Which List do you want to dequeue?");
            System.out.println("1. socialList");
            System.out.println("2. governList");
            System.out.println("3. enviroList");
            System.out.println("4. actionList");
            System.out.println("0. Go back");
            System.out.print("Type the number: ");

            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1 -> System.out.println("socialList dequeue value: " + socialList.dequeue());
                case 2 -> System.out.println("governList dequeue value: " + governList.dequeue());
                case 3 -> System.out.println("enviroList dequeue value: " + enviroList.dequeue());
                case 4 -> System.out.println("actionList dequeue value: " + actionList.dequeue());
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("Not available command, try another one.");
                    getDequeueList();
                }
            }
        }
    }

    public static void getEnqueueList() {
        int option;
        while (true) {
            System.out.println("Which List do you want to enqueue?");
            System.out.println("1. socialList");
            System.out.println("2. governList");
            System.out.println("3. enviroList");
            System.out.println("4. actionList");
            System.out.println("0. Go back");
            System.out.print("Type the number: ");

            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1 -> {
                    enqueueListProblem(esgs[0].getId(), esgs[0], socialList);
                }
                case 2 -> {
                    enqueueListProblem(esgs[1].getId(), esgs[1], governList);
                }
                case 3 -> {
                    enqueueListProblem(esgs[2].getId(), esgs[2], enviroList);
                }
                case 4 -> {
                    System.out.println("Type your name:");
                    String name = sc.nextLine();
                    System.out.println("Type a description of the action:");
                    String description = sc.nextLine();
                    Action action = new Action(actionList.last().getId() + 1, name, description, new Date(System.currentTimeMillis()), null);
                    System.out.println("Action added to the list:");
                    System.out.println(action);
                    actionList.enqueue(action);
                }
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("Not available command, try another one.");
                    getEnqueueList();
                }
            }
        }
    }

    public static void enqueueListProblem(int esgId, ESG esg, ListProblem list) {
        System.out.println("Type your name:");
        String name = sc.nextLine();
        System.out.println("Type your email:");
        String email = sc.nextLine();
        System.out.println("Type a description o your problem:");
        String description = sc.nextLine();
        Problem problem = new Problem(
                new javaBeans.Problem(list.last().getProblem().getId() + 1, description, false,  2, esgId, 1),
                new Person(new javaBeans.Person(2, name, email), new ListProfile(), new ListProblem()),
                esg, new Location(), new Solution());
        System.out.println("Problem added to the list:");
        System.out.println(problem);
        list.enqueue(problem);
    }

    public static void menu() {
        System.out.println("-------- WHAT DO YOU WANT TO DO --------");
        System.out.println("1. Load data");
        System.out.println("2. Get length of one of the lists");
        System.out.println("3. Get the first item in the lists");
        System.out.println("4. Dequeue one item of the lists");
        System.out.println("5. Enqueue one item to the list");
        System.out.println("6. Use our automated test to see all the dequeue of our list");
        System.out.println("0. Exit program");
        System.out.print("Type the number: ");
    }
}
