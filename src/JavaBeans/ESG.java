package JavaBeans;

public class ESG {
    private int id;
    private Enums.ESG esg;
    private String description;

    public ESG() {
    }

    public ESG(int id, Enums.ESG esg, String description) {
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

    public Enums.ESG getEsg() {
        return esg;
    }

    public void setEsg(Enums.ESG esg) {
        this.esg = esg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
