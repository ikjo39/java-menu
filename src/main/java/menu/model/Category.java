package menu.model;

import java.util.Arrays;

public enum Category {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(2, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식")
    ;

    private final int order;
    private final String name;

    Category(int order, String name) {
        this.order = order;
        this.name = name;
    }

    public static Category from(int order) {
        return Arrays.stream(Category.values())
                .filter(category -> order == category.order)
                .findAny()
                .orElseThrow(() -> new IllegalStateException());
    }
}
