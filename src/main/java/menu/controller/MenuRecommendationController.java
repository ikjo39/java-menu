package menu.controller;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import menu.model.CanNotEatMenu;
import menu.model.CoachName;
import menu.model.CoachNames;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommendationController {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuRecommendationController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printIntroduction();
        CoachNames coachNames = getCoaches();
        List<CanNotEatMenu> canNotEatMenus = getCanNotEatMenus(coachNames.getCoachNames());
        outputView.printMenuRecommendationResults();
    }

    private List<CanNotEatMenu> getCanNotEatMenus(List<String> names) {
        return retryUntilSuccess(() ->  names.stream()
                .map(name -> new CanNotEatMenu(inputView.readCanNotEatMenu(name)))
                .collect(Collectors.toUnmodifiableList()));
    }

    private CoachNames getCoaches() {
        return retryUntilSuccess(() -> new CoachNames(getCoaches(inputView.readCoachNames())));
    }

    private List<CoachName> getCoaches(List<String> coachNames) {
        return coachNames.stream()
                .map(CoachName::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private <R> R retryUntilSuccess(Supplier<R> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
