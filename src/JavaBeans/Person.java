package JavaBeans;

import java.util.ArrayList;

public class Person {
    private int id;
    private String Email;
    private String Telephone;
    private String Alias;

    public Person() {
    }

    public Person(int id, String email, String telephone, String alias) {
        this.id = id;
        Email = email;
        Telephone = telephone;
        Alias = alias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getAlias() {
        return Alias;
    }

    public void setAlias(String alias) {
        Alias = alias;
    }
}
