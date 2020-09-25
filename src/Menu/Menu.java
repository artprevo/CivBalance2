package Menu;

import Command.Command;

import java.util.ArrayList;

public abstract class Menu implements IMenu {

    String name;
    Menu parent;
    ArrayList<Menu> childList;
    ArrayList<Command> commandList;

    public Menu(String name, Menu parent, ArrayList<Menu> childList, ArrayList<Command> commandList) {
        this.name = name;
        this.parent = parent;
        this.childList = childList;
        this.commandList = commandList;
    }

    public void displayMenu() {
        if (this.childList != null)
            displayChildList();
        else if (this.commandList != null)
            displayCommandList();
        System.out.println();
    }

    public void displayChildList() {
        int i = 1;
        for (Menu menu : this.childList) {
            System.out.print(i++ + ": " + menu.getName() + " ");
        }
    }

    public void displayCommandList() {
        int i = 1;
        for (Command command : this.commandList) {
            System.out.print(i++ + ": " + command.getName() + " ");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public ArrayList<Menu> getChildList() {
        return childList;
    }

    public void setChildList(ArrayList<Menu> childList) {
        this.childList = childList;
    }

    public ArrayList<Command> getCommandList() {
        return commandList;
    }

    public void setCommandList(ArrayList<Command> commandList) {
        this.commandList = commandList;
    }

    public void init(ArrayList<Menu>menus, ArrayList<Command> commands) {

    }
}
