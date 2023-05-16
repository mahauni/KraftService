package javaBeans;

public class ESG {
    private int id;
    private enums.ESG esg;
    private String description;

    public ESG() {
    }

    public ESG(int id, enums.ESG esg, String description) {
        this.id = id;
        this.esg = esg;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public enums.ESG getEsg() {
        return esg;
    }

    public void setEsg(enums.ESG esg) {
        this.esg = esg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
