package menu.constant;

public enum ExceptionMessage {
    ;

    private static final String HEADER = "[ERROR]";

    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format("%s %s", HEADER, message);
    }

    public String getMessage() {
        return message;
    }
}
