package entities;

public enum ESG {
    ENVIROMENTAL("Enviromental"),
    SOCIAL("Social"),
    GOVERNAMENTAL("Governamental");

    private String details;

    ESG(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }
}
