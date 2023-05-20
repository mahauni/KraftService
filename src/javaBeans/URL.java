package javaBeans;

public class URL {
    private int idPerson;
    private int idLocation;
    private String URL;

    public URL() {
    }

    public URL(int idPerson, int idLocation, String URL) {
        this.idPerson = idPerson;
        this.idLocation = idLocation;
        this.URL = URL;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
