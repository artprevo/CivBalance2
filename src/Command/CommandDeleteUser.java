package Command;

import Tool.SqlTools;
import Tool.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CommandDeleteUser extends Command {
    public CommandDeleteUser(String name, int id) {
        super(name, id);
    }

    @Override
    public void executeCommand(User user) throws SQLException {
        String username = pick_user();
        SqlTools sqlTools = new SqlTools();
        System.out.println("Are you sure you want to delete " + username + " from the database ? Y or N");
        Scanner scanner = new Scanner(System.in);
        String user_choice = scanner.nextLine();
        if (user_choice.equals("y")) {
            int user_id;
            sqlTools.execQuery("Select * from user where username = '" + username + "'");
            sqlTools.getrS().next();
            user_id = sqlTools.getrS().getInt("user_id");
            sqlTools.execUpdate("delete from ranking where user_id = " + user_id);
            sqlTools.execUpdate("delete from user where user_id = " + user_id);
        }
    }
}
