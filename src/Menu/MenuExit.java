package Menu;

import Command.Command;

import java.util.ArrayList;

public class MenuExit extends Menu {

    public MenuExit(String name, Menu parent, ArrayList<Menu> childList, ArrayList<Command> commandList) {
        super(name, parent, childList, commandList);
    }

}
