package br.com.ese.esgManager.javaBeans;

import br.com.ese.esgManager.enums.enumESG;

public class jbESG {
    private int id;
    private enumESG enumEsg;
    private String description;

    public jbESG() {
    }

    public jbESG(int id, enumESG enumEsg, String description) {
        this.id = id;
        this.enumEsg = enumEsg;
        this.description = description;
    }

    public jbESG(enumESG enumEsg, String description) {
        this.enumEsg = enumEsg;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public enumESG getEsg() {
        return enumEsg;
    }

    public void setEsg(enumESG enumEsg) {
        this.enumEsg = enumEsg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
