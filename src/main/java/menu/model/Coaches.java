package menu.model;

import java.util.List;
import menu.constant.ExceptionMessage;

public class Coaches {
    private static final int MINIMUM_COACHES_SIZE = 2;
    private static final int MAXIMUM_COACHES_SIZE = 5;

    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        validateCoachesSize(coaches.size());
        this.coaches = coaches;
    }

    private void validateCoachesSize(int size) {
        validateLessThanMinimumSize(size);
        validateMoreThanMaximumSize(size);
    }

    private void validateLessThanMinimumSize(int size) {
        if (size < MINIMUM_COACHES_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.LESS_THAN_MINIMUM_COACHES_SIZE.getMessage());
        }
    }

    private void validateMoreThanMaximumSize(int size) {
        if (size > MAXIMUM_COACHES_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.MORE_THAN_MAXIMUM_COACHES_SIZE.getMessage());
        }
    }
}
