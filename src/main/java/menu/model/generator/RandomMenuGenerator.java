package menu.model.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomMenuGenerator implements BasicMenuGenerator{
    private static final int FIRST_INDEX = 0;

    @Override
    public String getGeneratedMenu(List<String> menus) {
        return Randoms.shuffle(menus).get(FIRST_INDEX);
    }
}
