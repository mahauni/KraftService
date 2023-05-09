package JavaBeans;

import java.util.ArrayList;

public class Responsibility {
    private ArrayList<Department> responsibility;

    public Responsibility() {
    }

    public Responsibility(ArrayList<Department> responsibility) {
        this.responsibility = responsibility;
    }

    public ArrayList<Department> getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(ArrayList<Department> responsibility) {
        this.responsibility = responsibility;
    }
}
