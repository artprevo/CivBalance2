package Menu;

import Command.Command;

import java.util.ArrayList;

public class MenuDraftHelper extends Menu{
    public MenuDraftHelper(String name, Menu parent, ArrayList<Menu> childList, ArrayList<Command> commandList) {
        super(name, parent, childList, commandList);
    }

    @Override
    public void init(ArrayList<Menu>menus, ArrayList<Command> commands) {
        ArrayList<Command> commandList = new ArrayList<>();
        for (Command command : commands) {
            if (command.getId() == 5 || command.getId() == 6 || command.getId() == 404)
                commandList.add(command);
        }
        this.setCommandList(commandList);
    }
}
