package Menu;

import Command.Command;

import java.util.ArrayList;

public interface IMenu {
    public void init(ArrayList<Menu> menus, ArrayList<Command> commands);
}
