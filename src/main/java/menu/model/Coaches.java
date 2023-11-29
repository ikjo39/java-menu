package menu.model;

import java.util.List;
import java.util.stream.Collectors;

public class Coaches {
    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public void addMenu(Category category) {
        coaches.forEach(coach -> coach.getAvailableMenu(category));
    }

    public List<List<String>> getMenus() {
        return coaches.stream()
                .map(Coach::getAvailableMenus)
                .collect(Collectors.toList());
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
