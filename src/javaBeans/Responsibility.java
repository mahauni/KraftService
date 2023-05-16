package javaBeans;

import java.util.ArrayList;

public class Responsibility {
    private ArrayList<Action> responsibility;

    public Responsibility() {
    }

    public Responsibility(ArrayList<Action> responsibility) {
        this.responsibility = responsibility;
    }

    public ArrayList<Action> getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(ArrayList<Action> responsibility) {
        this.responsibility = responsibility;
    }
}
