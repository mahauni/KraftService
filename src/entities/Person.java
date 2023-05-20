package entities;

import dataStructures.ListProblem;
import dataStructures.ListUrl;

public class Person {
    private javaBeans.Person person;
    private ListUrl urls;
    private ListProblem problems;

    public Person() {
    }

    public Person(javaBeans.Person person, ListUrl urls, ListProblem problems) {
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

    public ListUrl getUrls() {
        return urls;
    }

    public void setUrls(ListUrl urls) {
        this.urls = urls;
    }

    public ListProblem getProblems() {
        return problems;
    }

    public void setProblems(ListProblem problems) {
        this.problems = problems;
    }
}
