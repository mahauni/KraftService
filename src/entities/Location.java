package entities;

import dataStructures.ListUrl;

public class Location {
    private javaBeans.Location location;
    private ListUrl urls;

    public Location() {
    }

    public Location(javaBeans.Location location, ListUrl urls) {
        this.location = location;
        this.urls = urls;
    }

    public javaBeans.Location getLocation() {
        return location;
    }

    public void setLocation(javaBeans.Location location) {
        this.location = location;
    }

    public ListUrl getUrls() {
        return urls;
    }

    public void setUrls(ListUrl urls) {
        this.urls = urls;
    }
}
