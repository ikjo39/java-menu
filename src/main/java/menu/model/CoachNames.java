package menu.model;

import java.util.List;
import java.util.stream.Collectors;
import menu.constant.ExceptionMessage;

public class CoachNames {
    private static final int MINIMUM_COACHES_SIZE = 2;
    private static final int MAXIMUM_COACHES_SIZE = 5;

    private final List<CoachName> coachNames;

    public CoachNames(List<CoachName> coachNames) {
        validateCoachesSize(coachNames.size());
        this.coachNames = coachNames;
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

    public List<String> getCoachNames() {
        return coachNames.stream()
                .map(CoachName::getName)
                .collect(Collectors.toUnmodifiableList());
    }
}
