package menu.model;

import menu.constant.ExceptionMessage;

public class CoachName {
    private static final int MINIMUM_COACH_NAME_LENGTH = 2;
    private static final int MAXIMUM_COACH_NAME_LENGTH = 4;

    private final String name;

    public CoachName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateEmptyName(name);
        validateLessThanMinimumLength(name);
        validateMoreThanMaximumLength(name);
    }

    private void validateEmptyName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.BLANK_COACH_NAME.getMessage());
        }
    }

    private void validateLessThanMinimumLength(String name) {
        if (name.length() < MINIMUM_COACH_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.LESS_THAN_MINIMUM_COACH_NAME.getMessage());
        }
    }

    private void validateMoreThanMaximumLength(String name) {
        if (name.length() > MAXIMUM_COACH_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.MORE_THAN_MAXIMUM_COACH_NAME.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
