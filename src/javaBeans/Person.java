package javaBeans;

public class Person {
    private int id;
    private String email;
    private String telephone;
    private String name;

    public Person() {
    }

    public Person(int id, String email, String telephone, String alias) {
        this.id = id;
        this.email = email;
        this.telephone = telephone;
        this.name = alias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
