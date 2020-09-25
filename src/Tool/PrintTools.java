package Tool;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrintTools {

    public void printByUserByTier(int user_id, int tier_id) throws SQLException {
        SqlTools sqlTools = exeQuery("SELECT * FROM civbalance.ranking WHERE user_id = " + user_id + " and tier_id = " + tier_id);
        ResultSet rs = sqlTools.getrS();
        System.out.println(getTierName(tier_id) + " :" + '\n');
        while (rs.next())
            System.out.println(getCivName(rs.getInt("civ_id")) + " (" + getLeaderName(rs.getInt("civ_id")) + ")");
        System.out.println();
        sqlTools.getMyConn().close();
    }

    public void printRankingList(int user_id) throws SQLException {
        int tier_id = 1;
        while (tier_id <= 7) {
            printByUserByTier(user_id, tier_id);
            tier_id++;
        }
    }

    // used for printing purpose
    public String getCivName(int civ_id) throws SQLException {
        SqlTools sqlTools = exeQuery("SELECT name FROM civbalance.civ WHERE civ_id = " + civ_id);
        ResultSet rs = sqlTools.getrS();
        rs.next();
        String name = rs.getString("name");
        sqlTools.getMyConn().close();
        return name;
    }

    // used for printing purpose
    public String getLeaderName(int civ_id) throws SQLException {
        SqlTools sqlTools = exeQuery("SELECT leader FROM civbalance.civ WHERE civ_id = " + civ_id);
        ResultSet rs = sqlTools.getrS();
        rs.next();
        String leader = rs.getString("leader");
        sqlTools.getMyConn().close();
        return leader;
    }

    // used for printing purpose
    public String getTierName(int tier_id) throws SQLException {
        SqlTools sqlTools = exeQuery("SELECT name FROM civbalance.tier WHERE tier_id = " + tier_id);
        ResultSet rs = sqlTools.getrS();
        rs.next();
        String name = rs.getString("name");
        sqlTools.getMyConn().close();
        return name;
    }

    private SqlTools exeQuery(String requete) {
        SqlTools RS = new SqlTools();
        RS.execQuery(requete);
        return RS;
    }
}
