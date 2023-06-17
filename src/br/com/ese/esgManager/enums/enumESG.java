package br.com.ese.esgManager.enums;

public enum enumESG {
    ENVIRONMENTAL("Environmental"),
    SOCIAL("Social"),
    GOVERNMENTAL("Governmental");

    private String details;

    enumESG(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }
}
