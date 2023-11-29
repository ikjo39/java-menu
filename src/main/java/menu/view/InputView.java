package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String COACH_DELIMITER = ",";
    private static final String ENTER_COACH_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public List<String> readCoachNames() {
        System.out.println(ENTER_COACH_NAMES);
        String input = Console.readLine();
        return Arrays.stream(input.split(COACH_DELIMITER))
                .collect(Collectors.toUnmodifiableList());
    }
}
