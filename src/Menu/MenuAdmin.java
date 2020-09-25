package Menu;

import Command.Command;

import java.util.ArrayList;

public class MenuAdmin extends Menu{
    public MenuAdmin(String name, Menu parent, ArrayList<Menu> childList, ArrayList<Command> commandList) {
        super(name, parent, childList, commandList);
    }

    @Override
    public void init(ArrayList<Menu>menus, ArrayList<Command> commands) {
        ArrayList<Command> commandList = new ArrayList<>();
        for (Command command : commands) {
            if (command.getId() == 7 || command.getId() == 8 || command.getId() == 9 || command.getId() == 404)
                commandList.add(command);
        }
        this.setCommandList(commandList);
    }
}
