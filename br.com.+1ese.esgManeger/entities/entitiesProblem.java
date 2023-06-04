package entities;

import javaBeans.jbESG;
import javaBeans.jbLocation;
import javaBeans.jbProblem;

public class entitiesProblem {
    private jbProblem jbProblem;
    private jbESG jbEsg;
    private entitiesPerson entitiesPerson;
    private jbLocation jbLocation;
    private entitiesSolution entitiesSolution;

    public entitiesProblem() {
    }

    public entitiesProblem(jbProblem jbProblem, entitiesPerson entitiesPerson, jbESG jbEsg, jbLocation jbLocation, entitiesSolution entitiesSolution) {
        this.jbProblem = jbProblem;
        this.jbEsg = jbEsg;
        this.entitiesPerson = entitiesPerson;
        this.jbLocation = jbLocation;
        this.entitiesSolution = entitiesSolution;
    }

    public jbProblem getProblem() {
        return jbProblem;
    }

    public void setProblem(jbProblem jbProblem) {
        this.jbProblem = jbProblem;
    }

    public jbESG getEsg() {
        return jbEsg;
    }

    public void setEsg(jbESG jbEsg) {
        this.jbEsg = jbEsg;
    }

    public entitiesPerson getPerson() {
        return entitiesPerson;
    }

    public void setPerson(entitiesPerson entitiesPerson) {
        this.entitiesPerson = entitiesPerson;
    }

    public jbLocation getLocation() {
        return jbLocation;
    }

    public void setLocation(jbLocation jbLocation) {
        this.jbLocation = jbLocation;
    }

    public entitiesSolution getSolution() {
        return entitiesSolution;
    }

    public void setSolution(entitiesSolution entitiesSolution) {
        this.entitiesSolution = entitiesSolution;
    }

    @Override
    public String toString() {
        return "Problem { " +
                "problem=" + jbProblem.getDescription() +
                ", esg=" + jbEsg.getEsg().toString()+
                ", person=" + entitiesPerson.getPerson().getName() +
                ", location=" + jbLocation.getLocation() +
                ", solutions=" + entitiesSolution.getListAction().length() +
                " }";
    }
}
