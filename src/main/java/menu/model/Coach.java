package menu.model;

import java.util.List;
import menu.model.generator.BasicMenuGenerator;

public class Coach {
    private final String name;
    private final CanNotEatMenu canNotEatMenu;
    private final BasicMenuGenerator basicMenuGenerator;
    private List<String> availableMenus;

    public Coach(String name, CanNotEatMenu canNotEatMenu, BasicMenuGenerator basicMenuGenerator) {
        this.name = name;
        this.canNotEatMenu = canNotEatMenu;
        this.basicMenuGenerator = basicMenuGenerator;
    }

    public void getAvailableMenu(Category category) {
        List<String> menus = Menu.getMenusFrom(category);
        String menu = basicMenuGenerator.getGeneratedMenu(menus);
        while (canNotEatMenu.contains(menu) && availableMenus.contains(menu)) {
            menu = basicMenuGenerator.getGeneratedMenu(menus);
        }
        availableMenus.add(menu);
    }

    public List<String> getAvailableMenus() {
        return availableMenus;
    }
}
