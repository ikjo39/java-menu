package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.constant.ExceptionMessage;

public class InputView {
    private static final String COACH_DELIMITER = ",";
    private static final String MENU_DELIMITER = ",";
    private static final String ENTER_COACH_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String ENTER_CAN_NOT_EAT = "%s(이)가 못 먹는 메뉴를 입력해 주세요.%n";

    public List<String> readCoachNames() {
        System.out.println();
        System.out.println(ENTER_COACH_NAMES);
        String input = Console.readLine();
        validateEndWithDelimiter(input, COACH_DELIMITER);
        return Arrays.stream(input.split(COACH_DELIMITER))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> readCanNotEatMenu(String name) {
        System.out.println();
        System.out.printf(ENTER_CAN_NOT_EAT, name);
        String input = Console.readLine();
        validateEndWithDelimiter(input, MENU_DELIMITER);
        return Arrays.stream(input.split(MENU_DELIMITER))
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateEndWithDelimiter(String input, String delimiter) {
        if (input.endsWith(delimiter)) {
            throw new IllegalArgumentException(ExceptionMessage.END_WITH_DELIMITER.getMessage());
        }
    }
}
