package menu.view;

public class OutputView {
    private static final String INTRODUCTION = "점심 메뉴 추천을 시작합니다.";
    private static final String MENU_RECOMMENDATION_RESULTS = "메뉴 추천 결과입니다.";

    public void printIntroduction() {
        System.out.println(INTRODUCTION);
    }

    public void printMenuRecommendationResults() {
        System.out.println(MENU_RECOMMENDATION_RESULTS);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
