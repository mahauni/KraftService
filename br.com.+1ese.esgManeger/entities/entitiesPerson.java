package entities;

import dataStructures.ListProblem;
import dataStructures.ListProfile;
import javaBeans.jbPerson;

public class entitiesPerson {
    private jbPerson jbPerson;
    private ListProfile urls;
    private ListProblem problems;

    public entitiesPerson() {
    }

    public entitiesPerson(jbPerson jbPerson, ListProfile urls, ListProblem problems) {
        this.jbPerson = jbPerson;
        this.urls = urls;
        this.problems = problems;
    }

    public jbPerson getPerson() {
        return jbPerson;
    }

    public void setPerson(jbPerson jbPerson) {
        this.jbPerson = jbPerson;
    }

    public ListProfile getUrls() {
        return urls;
    }

    public void setUrls(ListProfile urls) {
        this.urls = urls;
    }

    public ListProblem getProblems() {
        return problems;
    }

    public void setProblems(ListProblem problems) {
        this.problems = problems;
    }

    // review this later to see if is needed to add more
    @Override
    public String toString() {
        return "Person { " +
                "person name=" + jbPerson.getName() +
                "person email=" + jbPerson.getEmail() +
                ", urls=" + urls.length() +
                ", problems=" + problems.length() +
                " }";
    }
}
