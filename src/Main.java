import Command.*;
import Menu.*;
import Tool.User;
import com.mysql.cj.x.protobuf.MysqlxExpr;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) throws SQLException {
        User user = new User();
        user.login();
        Menu tmp_menu = init_program(user);
        Scanner scanner = new Scanner(System.in);
        int user_choice = 0;
        while (tmp_menu.getName().equals("Welcome"))
        {
            tmp_menu.displayMenu();
            user_choice = 0;
            int size = tmp_menu.getChildList().size();
            while (user_choice <= 0 || (user_choice > size))
                user_choice = scanner.nextInt();
            if (user_choice == size)
                return;
            tmp_menu = tmp_menu.getChildList().get(user_choice - 1);
            while (!tmp_menu.getName().equals("Welcome")) {
                tmp_menu.displayMenu();
                user_choice = 0;
                size = tmp_menu.getCommandList().size();
                while (user_choice <= 0 || (user_choice > size))
                    user_choice = scanner.nextInt();
                if (user_choice == size) {
                    tmp_menu = tmp_menu.getParent();
                }
                else
                    tmp_menu.getCommandList().get(user_choice - 1).executeCommand(user);
            }
        }
    }

    public static Menu init_program(User user) {
        ArrayList<Menu> menus = initMenu(user);
        ArrayList<Command> commands = initCommand();
        Menu menuPrincipal = menus.get(0);
        for (Menu menu : menus) {
            menu.init(menus, commands);
        }
        return menuPrincipal;
    }

    public static ArrayList<Menu> initMenu(User user) {
        ArrayList<Menu> menus = new ArrayList<Menu>();

        Menu menuPrincipal = new MenuPrincipal("Welcome", null, null, null);
        menus.add(menuPrincipal);

        Menu menuDraftHelper = new MenuDraftHelper("Draft Helper", menuPrincipal, null, null);
        menus.add(menuDraftHelper);

        Menu menuRanking = new MenuRanking("Ranking", menuPrincipal, null, null);
        menus.add(menuRanking);

        Menu menuMap = new MenuMap("Map", menuPrincipal, null, null);
        menus.add(menuMap);

        if (user.getUser_id() == 1) {
            Menu menuAdmin = new MenuAdmin("Admin", menuPrincipal, null, null);
            menus.add(menuAdmin);
        }

        Menu menuExit = new MenuExit("Exit", menuPrincipal, null, null);
        menus.add(menuExit);

        return menus;
    }

    public static ArrayList<Command> initCommand() {
        ArrayList<Command> commands = new ArrayList<Command>();

        //ranking
        Command commandCreateRanking = new CommandCreateRanking("Create your ranking", 1);
        Command commandEditRanking = new CommandEditRanking("Edit your ranking", 2);
        Command commandGlobalRanking = new CommandGlobalRanking("Global ranking", 3);
        Command commandByUserRanking = new CommandByUserRanking("By user", 4);
        //drafthelper
        Command commandChooseUsersForDraft = new CommandChooseUsersForDraft("Choose players", 5);
        Command commandLaunchDraftHelper = new CommandLaunchDraftHelper("Launch draft", 6);
        //admin
        Command commandAddUser = new CommandAddUser("Add user", 7);
        Command commandDeleteUser = new CommandDeleteUser("Delete user", 8);
        Command commandAddCiv = new CommandAddCiv("Add civ", 9);
        //return
        Command commandReturn = new CommandReturn("Return", 404);

        commands.add(commandCreateRanking);
        commands.add(commandEditRanking);
        commands.add(commandGlobalRanking);
        commands.add(commandByUserRanking);
        commands.add(commandChooseUsersForDraft);
        commands.add(commandLaunchDraftHelper);
        commands.add(commandAddUser);
        commands.add(commandDeleteUser);
        commands.add(commandAddCiv);
        commands.add(commandReturn);
        return commands;
    }
}
