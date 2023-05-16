package javaBeans;

public class URL {
    private Location location;
    private Person person;
    private String URL;

    public URL() {
    }

    public URL(Location location, Person person, String URL) {
        this.location = location;
        this.person = person;
        this.URL = URL;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
