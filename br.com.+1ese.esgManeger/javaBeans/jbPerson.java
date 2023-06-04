package javaBeans;

public class jbPerson {
    private int id;
    private String name;
    private String email;
    private String telephone = null;

    public jbPerson() {
    }

    public jbPerson(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public jbPerson(String name, String email, String telephone) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }

    public jbPerson(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public jbPerson(int id, String email, String telephone, String alias) {
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
