package Command;

import Tool.SqlTools;
import Tool.User;

import java.util.Scanner;

public class CommandAddUser extends Command {
    public CommandAddUser(String name, int id) {
        super(name, id);
    }

    public void executeCommand(User user) {
        String username;
        String password;
        Scanner user_choice = new Scanner(System.in);
        System.out.println("username : ");
        username = user_choice.nextLine();
        System.out.println("password : ");
        password = user_choice.nextLine();
        SqlTools sql = new SqlTools();
        sql.execUpdate("INSERT INTO `user` (username, password) VALUES ('" + username + "', '" + password + "');");
        System.out.println("User added");
    }
}
