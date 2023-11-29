package menu.controller;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import menu.model.Coach;
import menu.model.Coaches;
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
        Coaches coaches = getCoaches();
    }

    private Coaches getCoaches() {
        return retryUntilSuccess(() -> new Coaches(getCoaches(inputView.readCoachNames())));
    }

    private List<Coach> getCoaches(List<String> coachNames) {
        return coachNames.stream()
                .map(Coach::new)
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
