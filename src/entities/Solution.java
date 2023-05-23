package entities;

import dataStructures.ListAction;

public class Solution {
    private Problem problem;
    private ListAction listAction;

    public Solution() {
        this.listAction = new ListAction();
    }

    public Solution(ListAction listAction) {
        this.listAction = listAction;
    }

    public Solution(Problem problem, ListAction listAction) {
        this.problem = problem;
        this.listAction = listAction;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public ListAction getListAction() {
        return listAction;
    }

    public void setListAction(ListAction listAction) {
        this.listAction = listAction;
    }
}
