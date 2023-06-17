package br.com.ese.esgManager.entities;

import br.com.ese.esgManager.javaBeans.jbESG;
import br.com.ese.esgManager.javaBeans.jbLocation;
import br.com.ese.esgManager.javaBeans.jbProblem;

public class entitiesProblem {
    private br.com.ese.esgManager.javaBeans.jbProblem jbProblem;
    private jbESG jbEsg;
    private entitiesPerson entitiesPerson;
    private br.com.ese.esgManager.javaBeans.jbLocation jbLocation;
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
