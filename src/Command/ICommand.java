package Command;

import Tool.User;

import java.sql.SQLException;

public interface ICommand {
    public void executeCommand(User user) throws SQLException;
}
