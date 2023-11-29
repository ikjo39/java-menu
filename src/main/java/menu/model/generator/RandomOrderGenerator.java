package menu.model.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomOrderGenerator implements BasicOrderGenerator {
    private static final int MINIMUM_ORDER = 1;
    private static final int MAXIMUM_ORDER = 5;

    @Override
    public int generateCategoryOrder() {
        return Randoms.pickNumberInRange(MINIMUM_ORDER, MAXIMUM_ORDER);
    }
}
