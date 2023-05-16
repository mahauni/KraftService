package javaBeans;

import dataStructures.ActionQueue;

import java.util.ArrayList;

public class Solution {
    private ActionQueue actions;

    public Solution() {
    }

    public Solution(ActionQueue actions) {
        this.actions = actions;
    }

    public ActionQueue getActions() {
        return actions;
    }

    public void setActions(ActionQueue actions) {
        this.actions = actions;
    }
}
