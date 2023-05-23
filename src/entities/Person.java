package entities;

import dataStructures.ListProblem;
import dataStructures.ListProfile;

public class Person {
    private javaBeans.Person person;
    private ListProfile urls;
    private ListProblem problems;

    public Person() {
    }

    public Person(javaBeans.Person person, ListProfile urls, ListProblem problems) {
        this.person = person;
        this.urls = urls;
        this.problems = problems;
    }

    public javaBeans.Person getPerson() {
        return person;
    }

    public void setPerson(javaBeans.Person person) {
        this.person = person;
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
                "person name=" + person.getName() +
                "person email=" + person.getEmail() +
                ", urls=" + urls.length() +
                ", problems=" + problems.length() +
                " }";
    }
}
