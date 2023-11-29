package menu.model;

import java.util.List;

public class RecommendResult {
    private final List<Category> categories;
    private final Coaches coaches;

    public RecommendResult(List<Category> categories, Coaches coaches) {
        this.categories = categories;
        this.coaches = coaches;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Coaches getCoaches() {
        return coaches;
    }
}
