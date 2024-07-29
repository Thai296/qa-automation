package constants;

public enum BrowserType {
    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge");

    private final String name;

    BrowserType(String name) {
        this.name = name;
    }

    public String getBrowserType() {
        return name;
    }

    public static BrowserType fromString(String browserName) {
        for (BrowserType type : BrowserType.values()) {
            if (type.getBrowserType().equalsIgnoreCase(browserName)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant for browser name: " + browserName);
    }
}
