public class Achievement {
    private final String code;
    private final String description;

    public Achievement(String code, String description) {
        this.code = code;
        this.description = description;
    }
    public String getCode() { return code; }
    public String getDescription() { return description; }
    @Override
    public String toString() {
        return code + ": " + description;
    }
}
