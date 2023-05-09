package JavaBeans;

import java.util.ArrayList;

public class Solution {
    private ArrayList<Action> actions;

    public Solution() {
    }

    public Solution(ArrayList<Action> actions) {
        this.actions = actions;
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    public void setActions(ArrayList<Action> actions) {
        this.actions = actions;
    }
}
