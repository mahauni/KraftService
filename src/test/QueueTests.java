package test;

import br.com.ese.esgManager.dataStructures.ListAction;
import br.com.ese.esgManager.dataStructures.ListProblem;
import br.com.ese.esgManager.dataStructures.ListProfile;
import br.com.ese.esgManager.entities.entitiesPerson;
import br.com.ese.esgManager.entities.entitiesProblem;
import br.com.ese.esgManager.entities.entitiesSolution;
import br.com.ese.esgManager.enums.enumESG;
import br.com.ese.esgManager.javaBeans.*;
import br.com.ese.esgManager.utils.UtilsEncode;

import java.sql.Date;
import java.util.Random;
import java.util.Scanner;

public class QueueTests {
    static ListProblem socialList = new ListProblem();
    static ListProblem governList = new ListProblem();
    static ListProblem enviroList = new ListProblem();
    static ListAction actionList = new ListAction();
    static Scanner sc = new Scanner(System.in);
    static jbESG[] jbEsgs = new jbESG[3];

    public static void main(String[] args) throws Exception {
        init();
        int option;
        app: while (true) {
            menu();
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    loadData();
                    break;
                case 2:
                    getLengthList();
                    break;
                case 3:
                    getTopList();
                    break;
                case 4:
                    getDequeueList();
                    break;
                case 5:
                    getEnqueueList();
                    break;
                case 6:
                    smallTestAllLists();
                    break;
                case 0:
                    break app;
                default:
                    System.out.println("Not available command, try another one.");
                    break;
            }
        }
    }

    public static void init() {
        jbEsgs[0] = new jbESG(1, enumESG.SOCIAL, "Social 1");
        jbEsgs[1] = new jbESG(2, enumESG.GOVERNMENTAL, "Governmental 1");
        jbEsgs[2] = new jbESG(3, enumESG.ENVIRONMENTAL, "Environmental 1");
    }

    public static void loadData() throws Exception {
        Random rand = new Random();

        int numberActions = 1150;
        for (int i = 1; i <= numberActions; i++) {
            jbAction jbAction = new jbAction(i, "Hash of " + i, UtilsEncode.encode(Integer.toString(i)));
            actionList.enqueue(jbAction);
        }

        int numberProblems = 1000;
        for (int i = 1; i <= numberProblems; i++) {
            int numActions = rand.nextInt(3);
            ListAction actions = new ListAction();
            for (int j = 0; j < numActions; j++) {
                actions.enqueue(actionList.dequeue());
            }
            entitiesSolution entitiesSolution = new entitiesSolution(actions);
            entitiesPerson entitiesPerson = new entitiesPerson(new jbPerson(1, "TestName", "TestEmail@gmail.com"), new ListProfile(), new ListProblem());
            int esgInt = rand.nextInt(3);
            // Using the problem(br.com.ese.esgManager.javaBeans.problem, br.com.ese.esgManager.entities.Person, br.com.ese.esgManager.javaBeans.ESG, br.com.ese.esgManager.javaBeans.Location)
            entitiesProblem entitiesProblem = new entitiesProblem(new jbProblem(i, "Problem " + i, rand.nextBoolean(), entitiesPerson.getPerson().getId(), esgInt, 1), entitiesPerson, jbEsgs[esgInt], new jbLocation(), entitiesSolution);

            switch (entitiesProblem.getEsg().getEsg()) {
                case ENVIRONMENTAL:
                    enviroList.enqueue(entitiesProblem);
                    break;
                case SOCIAL:
                    socialList.enqueue(entitiesProblem);
                    break;
                case GOVERNMENTAL:
                    governList.enqueue(entitiesProblem);
                    break;
            }
        }

        System.out.println("Data loaded!");
    }

    public static void smallTestAllLists() {
        System.out.println("Environmental list length: " + enviroList.length());
        for (int i = 0; i < 7; i++) {
            entitiesProblem entitiesProblem = enviroList.dequeue();
            System.out.println("id: " + entitiesProblem.getProblem().getId() + " | How many actions: " + entitiesProblem.getSolution().getListAction().length());
            System.out.println("Actions:");
            entitiesProblem.getSolution().getListAction().printActions();
            System.out.println();
        }

        System.out.println("Social list length: " + socialList.length());
        for (int i = 0; i < 7; i++) {
            entitiesProblem entitiesProblem = socialList.dequeue();
            System.out.println("id: " + entitiesProblem.getProblem().getId() + " | How many actions: " + entitiesProblem.getSolution().getListAction().length());
            System.out.println("Actions:");
            entitiesProblem.getSolution().getListAction().printActions();
            System.out.println();
        }

        System.out.println("Governmental list length: " + governList.length());
        for (int i = 0; i < 7; i++) {
            entitiesProblem entitiesProblem = governList.dequeue();
            System.out.println("id: " + entitiesProblem.getProblem().getId() + " | How many actions: " + entitiesProblem.getSolution().getListAction().length());
            System.out.println("Actions:");
            entitiesProblem.getSolution().getListAction().printActions();
            System.out.println();
        }

        System.out.println("Action list length: " + actionList.length());
        for (int i = 0; i < 7; i++) {
            jbAction jbAction = actionList.dequeue();
            System.out.println("Actions without any problem: ");
            System.out.println(jbAction);
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
                case 1:
                    System.out.println("socialList length: " + socialList.length());
                    break;
                case 2:
                    System.out.println("governList length: " + governList.length());
                    break;
                case 3:
                    System.out.println("enviroList length: " + enviroList.length());
                    break;
                case 4:
                    System.out.println("actionList length: " + actionList.length());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Not available command, try another one.");
                    getLengthList();
                    break;

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
                case 1:
                    System.out.println("socialList top element: " + socialList.peak());
                    break;
                case 2:
                    System.out.println("governList top element: " + governList.peak());
                    break;
                case 3:
                    System.out.println("enviroList top element: " + enviroList.peak());
                    break;
                case 4:
                    System.out.println("actionList top element: " + actionList.peak());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Not available command, try another one.");
                    getTopList();
                    break;
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
                case 1:
                    System.out.println("socialList dequeue value: " + socialList.dequeue());
                    break;
                case 2:
                    System.out.println("governList dequeue value: " + governList.dequeue());
                    break;
                case 3:
                    System.out.println("enviroList dequeue value: " + enviroList.dequeue());
                    break;
                case 4:
                    System.out.println("actionList dequeue value: " + actionList.dequeue());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Not available command, try another one.");
                    getDequeueList();
                    break;
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
                case 1:
                    enqueueListProblem(jbEsgs[0].getId(), jbEsgs[0], socialList);
                    break;
                case 2:
                    enqueueListProblem(jbEsgs[1].getId(), jbEsgs[1], governList);
                    break;
                case 3:
                    enqueueListProblem(jbEsgs[2].getId(), jbEsgs[2], enviroList);
                    break;
                case 4:
                    System.out.println("Type your name:");
                    String name = sc.nextLine();
                    System.out.println("Type a description of the action:");
                    String description = sc.nextLine();
                    jbAction jbAction = new jbAction(actionList.last().getId() + 1, name, description, new Date(System.currentTimeMillis()), null);
                    System.out.println("Action added to the list:");
                    System.out.println(jbAction);
                    actionList.enqueue(jbAction);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Not available command, try another one.");
                    getEnqueueList();
                    break;
            }
        }
    }

    public static void enqueueListProblem(int esgId, jbESG jbEsg, ListProblem list) {
        System.out.println("Type your name:");
        String name = sc.nextLine();
        System.out.println("Type your email:");
        String email = sc.nextLine();
        System.out.println("Type a description o your problem:");
        String description = sc.nextLine();
        entitiesProblem entitiesProblem = new entitiesProblem(
                new jbProblem(list.last().getProblem().getId() + 1, description, false,  2, esgId, 1),
                new entitiesPerson(new jbPerson(2, name, email), new ListProfile(), new ListProblem()),
                jbEsg, new jbLocation(), new entitiesSolution());
        System.out.println("Problem added to the list:");
        System.out.println(entitiesProblem);
        list.enqueue(entitiesProblem);
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
