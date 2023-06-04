package entities;

import dataStructures.ListProfile;
import javaBeans.jbLocation;

public class entitiesLocation {
    private jbLocation jbLocation;
    private ListProfile urls;

    public entitiesLocation() {
    }

    public entitiesLocation(jbLocation jbLocation, ListProfile urls) {
        this.jbLocation = jbLocation;
        this.urls = urls;
    }

    public jbLocation getLocation() {
        return jbLocation;
    }

    public void setLocation(jbLocation jbLocation) {
        this.jbLocation = jbLocation;
    }

    public ListProfile getUrls() {
        return urls;
    }

    public void setUrls(ListProfile urls) {
        this.urls = urls;
    }
}
