package Menu;

import Command.Command;

import java.util.ArrayList;

public class MenuMap extends Menu{
    public MenuMap(String name, Menu parent, ArrayList<Menu> childList, ArrayList<Command> commandList) {
        super(name, parent, childList, commandList);
    }
}
