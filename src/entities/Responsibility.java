package entities;

import dataStructures.ListAction;
import javaBeans.Department;

public class Responsibility {
    private Department department;
    private ListAction responsibility;

    public Responsibility() {
        this.responsibility = new ListAction();
    }

    public Responsibility(ListAction responsibility) {
        this.responsibility = responsibility;
    }

    public Responsibility(Department department, ListAction responsibility) {
        this.department = department;
        this.responsibility = responsibility;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public ListAction getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(ListAction responsibility) {
        this.responsibility = responsibility;
    }
}