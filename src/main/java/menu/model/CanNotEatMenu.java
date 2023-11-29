package menu.model;

import java.util.List;
import menu.constant.ExceptionMessage;

public class CanNotEatMenu {
    private static final int MENU_SIZE_WHEN_BLANK = 1;
    private static final int MENU_INDEX_WHEN_BLANK = 0;
    private static final int MINIMUM_MENUS_SIZE = 0;
    private static final int MAXIMUM_MENUS_SIZE = 2;

    private final List<String> menus;

    public CanNotEatMenu(List<String> menus) {
        validateMenus(menus);
        this.menus = menus;
    }

    private void validateMenus(List<String> menus) {
        validateMenusSize(menus.size());
        validateMenuName(menus);
        validateMenuNameDuplicated(menus);
    }

    private void validateMenusSize(int size) {
        validateLessThanMinimumSize(size);
        validateMoreThanMaximumSize(size);
    }

    private void validateLessThanMinimumSize(int size) {
        if (size < MINIMUM_MENUS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMoreThanMaximumSize(int size) {
        if (size > MAXIMUM_MENUS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMenuName(List<String> menus) {
        if (menus.size() == MENU_SIZE_WHEN_BLANK && menus.get(MENU_INDEX_WHEN_BLANK).isBlank()) {
            return;
        }
        menus.forEach(this::validateMenuName);
    }

    private void validateMenuName(String name) {
        if (!Menu.hasMenuName(name)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MENU_NAME.getMessage());
        }
    }

    private void validateMenuNameDuplicated(List<String> menus) {
        long distinctCount = menus.stream().distinct().count();
        if (distinctCount != menus.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_MENU_NAMES.getMessage());
        }
    }
}
