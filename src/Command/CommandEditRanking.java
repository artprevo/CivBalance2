package Command;

import Tool.SqlTools;
import Tool.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CommandEditRanking extends Command {

    public CommandEditRanking(String name, int id) {
        super(name, id);
    }

    @Override
    public void executeCommand(User user) throws SQLException {
        System.out.println("Please enter a civ:");
        Scanner scanner = new Scanner(System.in);
        String civ_name = scanner.nextLine();
        System.out.println("Enter the new tier for " + civ_name + " on a scale from 1 to 7");
        int new_tier = scanner.nextInt();
        SqlTools sqlTools = new SqlTools();
        sqlTools.execQuery("Select * from civ where name = '" + civ_name + "'");
        ResultSet rS = sqlTools.getrS();
        rS.next();
        int civ_id = rS.getInt("civ_id");
        if (!already_ranked(user, civ_id))
            sqlTools.execUpdate("UPDATE ranking set tier_id = " + new_tier + " where civ_id = " + civ_id + " and user_id = " + user.getUser_id());
            else
            sqlTools.execUpdate("INSERT INTO `ranking` (civ_id, tier_id, user_id) VALUES (" + civ_id + "," + new_tier + "," + user.getUser_id() + ")");
        sqlTools.getMyConn().close();
    }
}