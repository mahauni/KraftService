package javaBeans;

public class jbSolution {
    private int idAction;
    private int idProblem;

    public jbSolution() {
    }

    public jbSolution(int idAction, int idProblem) {
        this.idAction = idAction;
        this.idProblem = idProblem;
    }

    public int getIdAction() {
        return idAction;
    }

    public void setIdAction(int idAction) {
        this.idAction = idAction;
    }

    public int getIdProblem() {
        return idProblem;
    }

    public void setIdProblem(int idProblem) {
        this.idProblem = idProblem;
    }
}
