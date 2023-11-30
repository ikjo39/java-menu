package menu.constant;

public enum ExceptionMessage {
    END_WITH_DELIMITER("입력값은 구분자로 끝날 수 없습니다."),

    BLANK_COACH_NAME("코치의 이름은 공백일 수 없습니다."),
    LESS_THAN_MINIMUM_COACH_NAME("코치의 이름은 최소 2글자 이상 입력해야 합니다."),
    MORE_THAN_MAXIMUM_COACH_NAME("코치의 이름은 최대 5글자 이하 입력해야 합니다."),
    LESS_THAN_MINIMUM_COACHES_SIZE("코치는 최소 2명 이상 입력해야 합니다."),
    MORE_THAN_MAXIMUM_COACHES_SIZE("코치는 최대 5명 이하 입력해야 합니다."),

    LESS_THAN_MINIMUM_MENUS_SIZE("못먹는 메뉴는 최소 0개 이상 입력해야 합니다."),
    MORE_THAN_MAXIMUM_MENUS_SIZE("못먹는 메뉴는 최대 2개 이하 입력해야 합니다."),
    INVALID_MENU_NAME("존재하지 않는 메뉴 이름입니다."),
    DUPLICATED_MENU_NAMES("못 먹는 메뉴가 중복되었습니다."),
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
