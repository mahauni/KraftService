package entities;

import javaBeans.ESG;
import javaBeans.Location;

public class Problem {
    private javaBeans.Problem problem;
    private ESG esg;
    private Person person;
    private Location location;
    private Solution solution;

    public Problem() {
    }

    public Problem(javaBeans.Problem problem, Person person, ESG esg, Location location, Solution solution) {
        this.problem = problem;
        this.esg = esg;
        this.person = person;
        this.location = location;
        this.solution = solution;
    }

    public javaBeans.Problem getProblem() {
        return problem;
    }

    public void setProblem(javaBeans.Problem problem) {
        this.problem = problem;
    }

    public ESG getEsg() {
        return esg;
    }

    public void setEsg(ESG esg) {
        this.esg = esg;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }
}
