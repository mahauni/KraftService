package javaBeans;

public class Problem {
    private int id;
    private String description;
    private boolean completed;
    private int idPerson;
    private int idEsg;
    private int idLocation;

    public Problem() {
    }

    public Problem(int id, String description, boolean completed, int idPerson, int idEsg, int idLocation) {
        this.id = id;
        this.description = description;
        this.completed = completed;
        this.idPerson = idPerson;
        this.idEsg = idEsg;
        this.idLocation = idLocation;
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

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getIdEsg() {
        return idEsg;
    }

    public void setIdEsg(int idEsg) {
        this.idEsg = idEsg;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }
}
