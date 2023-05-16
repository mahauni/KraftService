package enums;

public enum ESG {
    ENVIRONMENTAL("Environmental"),
    SOCIAL("Social"),
    GOVERNMENTAL("Governmental");

    private String details;

    ESG(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }
}
