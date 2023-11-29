package menu.constant;

public enum ExceptionMessage {
    BLANK_COACH_NAME("코치의 이름은 공백일 수 없습니다."),
    LESS_THAN_MINIMUM_COACH_NAME("코치의 이름은 최소 2글자 이상 입력해야 합니다."),
    MORE_THAN_MAXIMUM_COACH_NAME("코치의 이름은 최대 5글자 이상 입력해야 합니다."),
    LESS_THAN_MINIMUM_COACHES_SIZE("코치는 최소 2명 이상 입력해야 합니다."),
    MORE_THAN_MAXIMUM_COACHES_SIZE("코치는 최대 5명 이상 입력해야 합니다.")
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
