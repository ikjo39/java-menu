package menu.controller;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import menu.model.CanNotEatMenu;
import menu.model.Coach;
import menu.model.CoachName;
import menu.model.CoachNames;
import menu.model.Coaches;
import menu.model.MenuRecommendation;
import menu.model.generator.RandomMenuGenerator;
import menu.model.generator.RandomOrderGenerator;
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
        Coaches coaches = new Coaches(getCoaches(coachNames, canNotEatMenus));
        outputView.printMenuRecommendationResults();
        MenuRecommendation menuRecommendation = new MenuRecommendation(coaches, new RandomOrderGenerator());
        outputView.printResult(menuRecommendation.getResults());
    }

    private List<Coach> getCoaches(CoachNames coachNames, List<CanNotEatMenu> canNotEatMenus) {
        return IntStream.range(0, canNotEatMenus.size())
                .mapToObj(i ->
                        new Coach(
                                coachNames.getCoachNames().get(i),
                                canNotEatMenus.get(i),
                                new RandomMenuGenerator()))
                .collect(Collectors.toList());
    }

    private List<CanNotEatMenu> getCanNotEatMenus(List<String> names) {
        return retryUntilSuccess(() -> names.stream()
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
