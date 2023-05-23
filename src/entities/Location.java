package entities;

import dataStructures.ListProfile;

public class Location {
    private javaBeans.Location location;
    private ListProfile urls;

    public Location() {
    }

    public Location(javaBeans.Location location, ListProfile urls) {
        this.location = location;
        this.urls = urls;
    }

    public javaBeans.Location getLocation() {
        return location;
    }

    public void setLocation(javaBeans.Location location) {
        this.location = location;
    }

    public ListProfile getUrls() {
        return urls;
    }

    public void setUrls(ListProfile urls) {
        this.urls = urls;
    }
}
