package javaBeans;

import java.util.ArrayList;

public class Responsibility {
    private int idDepartment;
    private int idAction;

    public Responsibility() {
    }

    public Responsibility(int idDepartment, int idAction) {
        this.idDepartment = idDepartment;
        this.idAction = idAction;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public int getIdAction() {
        return idAction;
    }

    public void setIdAction(int idAction) {
        this.idAction = idAction;
    }
}
