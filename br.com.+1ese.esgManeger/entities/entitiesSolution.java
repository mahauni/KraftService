package entities;

import dataStructures.ListAction;

public class entitiesSolution {
    private entitiesProblem entitiesProblem;
    private ListAction listAction;

    public entitiesSolution() {
        this.listAction = new ListAction();
    }

    public entitiesSolution(ListAction listAction) {
        this.listAction = listAction;
    }

    public entitiesSolution(entitiesProblem entitiesProblem, ListAction listAction) {
        this.entitiesProblem = entitiesProblem;
        this.listAction = listAction;
    }

    public entitiesProblem getProblem() {
        return entitiesProblem;
    }

    public void setProblem(entitiesProblem entitiesProblem) {
        this.entitiesProblem = entitiesProblem;
    }

    public ListAction getListAction() {
        return listAction;
    }

    public void setListAction(ListAction listAction) {
        this.listAction = listAction;
    }
}
