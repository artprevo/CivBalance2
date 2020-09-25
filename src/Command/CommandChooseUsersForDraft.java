package Command;

import Tool.User;

import java.sql.SQLException;

public class CommandChooseUsersForDraft extends Command {

    public CommandChooseUsersForDraft(String name, int id) {
        super(name, id);
    }

    @Override
    public void executeCommand(User user) throws SQLException {
        // TODO
    }
}
