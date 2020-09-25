package Menu;

import Command.Command;

import java.util.ArrayList;

public class MenuPrincipal extends Menu{
    public MenuPrincipal(String name, Menu parent, ArrayList<Menu> menus, ArrayList<Command> commandList) {
        super(name, parent, menus, commandList);
    }

    @Override
    public void init(ArrayList<Menu>menus, ArrayList<Command> commands) {
        ArrayList<Menu> childList = new ArrayList<>();
        for (Menu menu : menus) {
            if (!menu.getName().equals(this.getName()))
                childList.add(menu);
        }
        this.setChildList(childList);
    }
}
