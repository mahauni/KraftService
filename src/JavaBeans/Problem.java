package JavaBeans;

import java.util.ArrayList;

public class Problem {
    private int id;
    private String description;
    private boolean completed;
    private Person person;
    private ESG esg;
    private Location location;
    private Solution solutions;

    public Problem() {
    }

    public Problem(int id, String description, boolean completed, Person person, ESG esg, Location location) {
        this.id = id;
        this.description = description;
        this.completed = completed;
        this.person = person;
        this.esg = esg;
        this.location = location;
    }

    public Problem(int id, String description, boolean completed, Person person, ESG esg, Location location, Solution solutions) {
        this.id = id;
        this.description = description;
        this.completed = completed;
        this.person = person;
        this.esg = esg;
        this.location = location;
        this.solutions = solutions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ESG getEsg() {
        return esg;
    }

    public void setEsg(ESG esg) {
        this.esg = esg;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Solution getActions() {
        return solutions;
    }

    public void setActions(Solution solutions) {
        this.solutions = solutions;
    }
}
