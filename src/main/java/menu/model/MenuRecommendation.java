package menu.model;

import java.util.List;
import menu.model.generator.BasicOrderGenerator;

public class MenuRecommendation {
    public static final int MAXIMUM_CATEGORY_COUNT = 2;
    private final Coaches coaches;
    private final BasicOrderGenerator basicOrderGenerator;
    private List<Category> categories;

    public MenuRecommendation(Coaches coaches, BasicOrderGenerator basicOrderGenerator) {
        this.coaches = coaches;
        this.basicOrderGenerator = basicOrderGenerator;
    }

    public RecommendResult getResults() {
        for (int i = 0; i < 5; i++) {
            recommend();
        }
        return new RecommendResult(categories, coaches);
    }

    private void recommend() {
        /*
         * 시나리오
         * 0. 월요일 부터 금요일 반복
         * 1. 카테고리 선택
         * 1-A. 추천할 수 없는 카테고리 일 경우 다시
         * 2. 메뉴를 랜덤으로 찾아 추가
         * 2-A. 메뉴가 적합하지 않을 시 다시 랜덤 돌리기
         * 3.
         * */
        Category generatedCategory = Category.from(basicOrderGenerator.generateCategoryOrder());
        while (getCount(generatedCategory) > MAXIMUM_CATEGORY_COUNT) {
            generatedCategory = Category.from(basicOrderGenerator.generateCategoryOrder());
        }
        categories.add(generatedCategory);
        coaches.addMenu(generatedCategory);
    }

    private long getCount(Category finalGeneratedCategory) {
        return categories.stream()
                .filter(category -> category.equals(finalGeneratedCategory))
                .count();
    }
}
