package entities;

import dataStructures.ListAction;
import javaBeans.jbDepartment;

public class entitiesResponsibility {
    private jbDepartment jbDepartment;
    private ListAction responsibility;

    public entitiesResponsibility() {
        this.responsibility = new ListAction();
    }

    public entitiesResponsibility(ListAction responsibility) {
        this.responsibility = responsibility;
    }

    public entitiesResponsibility(jbDepartment jbDepartment, ListAction responsibility) {
        this.jbDepartment = jbDepartment;
        this.responsibility = responsibility;
    }

    public jbDepartment getDepartment() {
        return jbDepartment;
    }

    public void setDepartment(jbDepartment jbDepartment) {
        this.jbDepartment = jbDepartment;
    }

    public ListAction getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(ListAction responsibility) {
        this.responsibility = responsibility;
    }
}