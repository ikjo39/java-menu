package menu.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Menu {
    GYU_DONG(Category.JAPANESE, "규동"),
    U_DONG(Category.JAPANESE, "우동"),
    MISO_SHIRU(Category.JAPANESE, "미소시루"),
    SUSHI(Category.JAPANESE, "스시"),
    GATCHDONG(Category.JAPANESE, "가츠동"),
    ONIGIRI(Category.JAPANESE, "오니기리"),
    HI_RICE(Category.JAPANESE, "하이라이스"),
    RAMEN(Category.JAPANESE, "라멘"),
    OKONOMIYAKKI(Category.JAPANESE, "오코노미야끼"),

    KIMBAP(Category.KOREAN, "김밥"),
    KIMCHI_JJIGAE(Category.KOREAN, "김치찌개"),
    SSAM_BAP(Category.KOREAN, "쌈밥"),
    MISO_JJIGAE(Category.KOREAN, "된장찌개"),
    BIBIMBAP(Category.KOREAN, "비빔밥"),
    KALGUKSU(Category.KOREAN, "칼국수"),
    BULGOGI(Category.KOREAN, "불고기"),
    DDEOKBOKKI(Category.KOREAN, "떡볶이"),
    STIR_FRIED_MEAT(Category.KOREAN, "제육볶음"),

    KANPUNGGI(Category.CHINESE, "깐풍기"),
    BOKKEMMYEON(Category.CHINESE, "볶음면"),
    DONGPA_MEAT(Category.CHINESE, "동파육"),
    JJAJANGMYEON(Category.CHINESE, "짜장면"),
    JJAMPONG(Category.CHINESE, "짬뽕"),
    MAPA_TOFU(Category.CHINESE, "마파두부"),
    TANGSU_MEAT(Category.CHINESE, "탕수육"),
    TOMATO_EGG_BOKKEUM(Category.CHINESE, "토마토 달걀볶음"),
    RED_PEPPER_JAPCHAE(Category.CHINESE, "고추잡채"),

    PATTAI(Category.ASIAN, "팟타이"),
    KAO_PAT(Category.ASIAN, "카오 팟"),
    NASHIGORANG(Category.ASIAN, "나시고렝"),
    PINEAPPLE_BOKKEM_RICE(Category.ASIAN, "파인애플 볶음밥"),
    RICE_NOODLES(Category.ASIAN, "쌀국수"),
    TOM_YANG_KUK(Category.ASIAN, "똠얌꿍"),
    BAN_MI(Category.ASIAN, "반미"),
    WALLNAM_SSAM(Category.ASIAN, "월남쌈"),
    BUNTZA(Category.ASIAN, "분짜"),

    LAZANYA(Category.WESTERN, "라자냐"),
    GRATIN(Category.WESTERN, "그라탱"),
    NYOKKI(Category.WESTERN, "뇨끼"),
    KKISHU(Category.WESTERN, "끼슈"),
    FRENCH_TOAST(Category.WESTERN, "프렌치 토스트"),
    BAGYETT(Category.WESTERN, "바게트"),
    SPAGHETTI(Category.WESTERN, "스파게티"),
    PIZZA(Category.WESTERN, "피자"),
    PANINI(Category.WESTERN, "파니니");

    private final Category category;
    private final String name;

    Menu(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public static boolean hasMenuName(String name) {
        return Arrays.stream(Menu.values())
                .anyMatch(menu -> menu.name.equals(name));
    }

    public static List<String> getMenusFrom(Category category) {
        return Arrays.stream(Menu.values())
                .filter(menu -> category.equals(menu.category))
                .map(menu -> menu.name)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }
}
