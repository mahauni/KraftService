package entities;

import dataStructures.ListAction;

public class Responsibility {
    private ListAction responsibility;

    public Responsibility(ListAction responsibility) {
        this.responsibility = responsibility;
    }

    public ListAction getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(ListAction responsibility) {
        this.responsibility = responsibility;
    }
}
