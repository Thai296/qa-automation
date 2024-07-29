package constants;

public enum EnvironmentType {
    LOCAL("local"),
    REMOTE("remote");

    private final String environment;

    EnvironmentType(String environment) {
        this.environment = environment;
    }

    public String getEnvironment() {
        return environment;
    }

    public static EnvironmentType fromString(String environment) {
        for (EnvironmentType environmentType : EnvironmentType.values()) {
            if (environmentType.getEnvironment().equalsIgnoreCase(environment)) {
                return environmentType;
            }
        }

        throw new IllegalArgumentException("No enum constant for environment: " + environment);
    }
}
