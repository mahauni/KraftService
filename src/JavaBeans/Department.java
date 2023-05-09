package JavaBeans;

public class Department {
    private int id;
    private String name;
    private Responsibility responsibility;

    public Department() {
    }

    public Department(int id, String name, Responsibility responsibility) {
        this.id = id;
        this.name = name;
        this.responsibility = responsibility;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Responsibility getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(Responsibility responsibility) {
        this.responsibility = responsibility;
    }
}