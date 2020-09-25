package Command;

import Tool.PrintTools;
import Tool.SqlTools;
import Tool.User;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public abstract class Command implements ICommand {
    String name;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Command(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void executeCommand(User user) throws SQLException {

    }

    public boolean already_ranked(@NotNull User user, int civ_id) throws SQLException {
        SqlTools sqlTools = new SqlTools();
        sqlTools.execQuery("SELECT * FROM ranking WHERE user_id = " + user.getUser_id() + " and civ_id = " + civ_id);
        ResultSet rs = sqlTools.getrS();
        boolean rep = !rs.next();
        sqlTools.getMyConn().close();
        return rep;
    }

    public String pick_user() throws SQLException {
        SqlTools sql = new SqlTools();
        String username = null;
        boolean good_choice = false;
        Scanner user_choice = new Scanner(System.in);

        //acquisition de tous les users
        sql.execQuery("Select * from user");
        ResultSet rS = sql.getrS();
        while (rS.next()) {
            System.out.println(rS.getString("username"));
        }

        //choix d'un user + vérif
        while (!good_choice) {
            System.out.println("Please select a valid user");
            username = user_choice.nextLine();
            sql.getMyConn().close();
            sql.execQuery("Select * from user");
            rS = sql.getrS();
            while (rS.next()) {
                if (rS.getString("username").equals(username) || username.equals("exit"))
                    good_choice = true;
            }
        }
        sql.getMyConn().close();
        return username;
    }
}
