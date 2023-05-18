package javaBeans;

import dataStructures.ListGeneric;

public class Location {
    private int id;
    private String location;
    // make a new queue for the
    private ListGeneric<URL> urls;

    public Location() {
    }

    public Location(int id, String location) {
        this.id = id;
        this.location = location;
    }

    public Location(int id, String location, ListGeneric<URL> urls) {
        this.id = id;
        this.location = location;
        this.urls = urls;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ListGeneric<URL> getUrls() {
        return urls;
    }

    public void setUrls(ListGeneric<URL> urls) {
        this.urls = urls;
    }
}
