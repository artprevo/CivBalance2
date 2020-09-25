package Command;

import Tool.PrintTools;
import Tool.SqlTools;
import Tool.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CommandByUserRanking extends Command{


    public CommandByUserRanking(String name, int id) {
        super(name, id);
    }

    @Override
    public void executeCommand(User user) throws SQLException {
        PrintTools pT = new PrintTools();
        SqlTools sql = new SqlTools();
        String username = pick_user();
        //affichage du ranking
        sql.execQuery("Select * from user where username = '" + username + "'");
        ResultSet rS = sql.getrS();
        rS.next();
        pT.printRankingList(rS.getInt("user_id"));
        sql.getMyConn().close();
    }
}
