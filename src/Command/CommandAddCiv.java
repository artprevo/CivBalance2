package Command;

import Tool.SqlTools;
import Tool.User;

import java.util.Scanner;

public class CommandAddCiv extends Command {
    public CommandAddCiv(String name, int id) {
        super(name, id);
    }

    @Override
    public void executeCommand(User user) {
        String name;
        String leader;
        Scanner user_choice = new Scanner(System.in);
        System.out.println("Name : ");
        name = user_choice.nextLine();
        System.out.println("Leader : ");
        leader = user_choice.nextLine();
        SqlTools sql = new SqlTools();
        sql.execUpdate("INSERT INTO `civ` (name, leader) VALUES ('" + name + "', '" + leader + "');");
        System.out.println("Civ added");
    }
}
