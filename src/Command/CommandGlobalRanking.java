package Command;

import Tool.Civ;
import Tool.SqlTools;
import Tool.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommandGlobalRanking extends Command {

    public CommandGlobalRanking(String name, int id) {
        super(name, id);
    }

    @Override
    public void executeCommand(User user) throws SQLException {
        SqlTools sqlTools = new SqlTools();
        ArrayList<Civ> civArrayList = new ArrayList<Civ>();

        sqlTools.execQuery("Select * from civ");
        ResultSet rS = sqlTools.getrS();
        while (rS.next()) {
            Civ civ = new Civ();
            civ.setName(rS.getString("name"));
            civ.setCiv_id(rS.getInt("civ_id"));
            civ.setLeader(rS.getString("leader"));
            civArrayList.add(civ);
        }
        for (Civ civ : civArrayList) {
            sqlTools.execQuery("Select * from ranking where civ_id = " + civ.getCiv_id());
            rS = sqlTools.getrS();
            ArrayList<Integer> tierList = new ArrayList<Integer>();
            while (rS.next()) {
                tierList.add(rS.getInt("tier_id"));
            }
            civ.setTierList(tierList);
        }
        // TODO
    }
}
