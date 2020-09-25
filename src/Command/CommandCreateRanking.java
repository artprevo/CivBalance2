package Command;

import Tool.InputTools;
import Tool.SqlTools;
import Tool.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommandCreateRanking extends Command {

    public CommandCreateRanking(String name, int id) {
        super(name, id);
    }

    @Override
    public void executeCommand(User user) throws SQLException {
        SqlTools sqlTools = new SqlTools();
        InputTools input = new InputTools();
        sqlTools.execQuery("SELECT * FROM civbalance.civ");
        ResultSet rs = sqlTools.getrS();
        while (rs.next()) {
            if (already_ranked(user, rs.getInt("civ_id"))) {
                System.out.println("Choose a tier for " + rs.getString("name") + " (" + rs.getString("leader") + ") FROM 1 to 7");
                int tierChosen = input.tierInput();
                System.out.println(tierChosen);
                sqlTools.execUpdate("INSERT INTO `ranking` (civ_id, tier_id, user_id) VALUES (" + rs.getInt("civ_id") + "," + tierChosen + "," + user.getUser_id() + ")");
            }
        }
        sqlTools.getMyConn().close();
    }
}
